/*
 * Copyright 2019 HM Revenue & Customs
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

package uk.gov.hmrc.decisionservice.services

import uk.gov.hmrc.decisionservice.config.ruleSets.PartAndParcelRules
import uk.gov.hmrc.decisionservice.models.PartAndParcel
import uk.gov.hmrc.decisionservice.models.enums.WeightedAnswerEnum
import uk.gov.hmrc.decisionservice.util.PartAndParcelRulesSet
import uk.gov.hmrc.play.test.UnitSpec

class PartAndParcelDecisionServiceSpec extends UnitSpec{

  object TestPartAndParcelDecisionService extends PartAndParcelDecisionService(new PartAndParcelRulesSet)

  "PartAndParcelDecisionServiceSpec" when {

    "decide is called with a PartAndParcel section with every value provided" should {

      "return a WeightedAnswer" in {

        val expectedAnswer = Some(WeightedAnswerEnum.MEDIUM)
        val actualAnswer = TestPartAndParcelDecisionService.decide(Some(PartAndParcel(
          Some(false),
          Some(false),
          Some(true),
          Some("workForEndClient")
        )))

        await(actualAnswer) shouldBe expectedAnswer

      }
    }

    "decide is called with a PartAndParcel section with medium scenarios populated" should {

      val expectedAnswer = Some(WeightedAnswerEnum.MEDIUM)
      val indexedArray = PartAndParcelRules.medium.value.zipWithIndex

      indexedArray.foreach {
        item =>

          val (jsValue, index) = item

          s"return an answer for scenario ${index + 1}" in {

            val actualAnswer = TestPartAndParcelDecisionService.decide(Some(jsValue.as[PartAndParcel]))

            await(actualAnswer) shouldBe expectedAnswer

          }
      }
    }

    "decide is called with a PartAndParcel section with low scenarios populated" should {

      val expectedAnswer = Some(WeightedAnswerEnum.LOW)
      val indexedArray = PartAndParcelRules.low.value.zipWithIndex

      indexedArray.foreach {
        item =>

          val (jsValue, index) = item

          s"return an answer for scenario ${index + 1}" in {

            val actualAnswer = TestPartAndParcelDecisionService.decide(Some(jsValue.as[PartAndParcel]))

            await(actualAnswer) shouldBe expectedAnswer

          }
      }
    }

    "decide is called with a PartAndParcel section with high scenarios populated" should {

      val expectedAnswer = Some(WeightedAnswerEnum.HIGH)
      val indexedArray = PartAndParcelRules.high.value.zipWithIndex

      indexedArray.foreach {
        item =>

          val (jsValue, index) = item

          s"return an answer for scenario ${index + 1}" in {

            val actualAnswer = TestPartAndParcelDecisionService.decide(Some(jsValue.as[PartAndParcel]))

            await(actualAnswer) shouldBe expectedAnswer

          }
      }
    }

    "decide is called with a PartAndParcel section with None for every value" should {

      "return a WeightedAnswer" in {

        val expectedAnswer = None
        val actualAnswer = TestPartAndParcelDecisionService.decide(Some(PartAndParcel(None, None, None, None)))

        await(actualAnswer) shouldBe expectedAnswer

      }
    }
  }

}