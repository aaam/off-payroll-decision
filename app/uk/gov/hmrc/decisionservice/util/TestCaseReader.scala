/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.decisionservice.util

import uk.gov.hmrc.decisionservice.model.api.DecisionRequest
import uk.gov.hmrc.decisionservice.model.rules.{>>>, CarryOver, Facts}
import uk.gov.hmrc.decisionservice.ruleengine.FileTokenizer.tokenize

import scala.util.Try

case class TestCase(expectedDecision:String, request:DecisionRequest)

case class ClusterTestCase(expectedDecision:CarryOver, request:Facts)
case class ClusterTestCaseFileMetaData(factsPath:String, clusterName:String, rulesPath:String, numOfValueColumns:Int)


object TestCaseReader {
  private val NUM_OF_CLUSTER_RESULT_COLUMNS = 3

  def readFlattenedTestCaseLines(path:String):Try[List[TestCase]] = {
    tokenize(path).map { tokens =>
        val clusterNames = tokens(0).dropRight(1)
        val tagNames = tokens(1)
        val answersAndDecision = tokens.drop(2)
        answersAndDecision.map(buildDecisionRequest(clusterNames, tagNames, _))
      }
    }

  def buildDecisionRequest(clusterNames:List[String], tagNames:List[String], answersAndDecision:List[String]):TestCase = {
    val expectedDecision = answersAndDecision.last
    val answers = answersAndDecision.dropRight(1)
    val interview = clusterNames.map{clusterName =>
      (clusterName -> (tagNames.zip(answers).toMap))
    }.toMap
    TestCase(expectedDecision, DecisionRequest("test-version", "test-correlation-id", interview))
  }

  def readClusterTestCaseLines(implicit metaData: ClusterTestCaseFileMetaData):Try[List[ClusterTestCase]] = {
    tokenize(metaData.factsPath).map { tokens =>
      val tagNames = tokens(0)
      val scenarios = tokens.drop(1)
      scenarios.map { scenario =>
        val (answers, rest) = scenario.splitAt(tagNames.size - NUM_OF_CLUSTER_RESULT_COLUMNS)
        ClusterTestCase(>>>.apply(rest), Facts(tagNames.zip(answers.map(>>>(_))).toMap))
      }
    }
  }

}
