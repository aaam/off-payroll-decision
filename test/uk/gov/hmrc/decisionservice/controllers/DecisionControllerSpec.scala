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

package uk.gov.hmrc.decisionservice.controllers

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.kenshoo.play.metrics.PlayModule
import play.api.http.Status.{BAD_REQUEST, OK}
import play.api.libs.json.Json.toJson
import play.api.libs.json.{JsValue, Json}
import play.api.test.{FakeRequest, Helpers}
import uk.gov.hmrc.decisionservice.models._
import uk.gov.hmrc.decisionservice.models.enums.{DecisionServiceVersion, ResultEnum}
import uk.gov.hmrc.decisionservice.services.mocks.MockDecisionService
import uk.gov.hmrc.decisionservice.util.TestFixture
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class DecisionControllerSpec extends UnitSpec with WithFakeApplication with TestFixture with MockDecisionService {
  override def bindModules = Seq(new PlayModule)
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  val fakeRequest = FakeRequest()
  val json: JsValue = Json.parse("{}")

  val testDecisionController = new DecisionController(stubMessagesControllerComponents(),mockDecisionService)

  "Decision Controller" must {

    "return a OK with a decision" in {

      val decisionRequest = DecisionRequest(DecisionServiceVersion.v1_5_0,"", Interview(
        setup = Some(Setup(None, None, None)),
        exit = Some(Exit(None)),
        personalService = Some(PersonalService(None, None, None, None, None)),
        control = Some(Control(None, None, None, None)),
        financialRisk = Some(FinancialRisk(None, None, None, None, None, None, None)),
        partAndParcel = Some(PartAndParcel(None, None, None, None)),
        businessOnOwnAccount = Some(BusinessOnOwnAccount(None, None, None, None, None))
      ))

      mockCalculateResult(decisionRequest)(DecisionResponse(DecisionServiceVersion.v1_5_0, "", Score(), ResultEnum.UNKNOWN, ResultEnum.UNKNOWN))

      val fakeRequest = FakeRequest(Helpers.POST, "/decide").withBody(toJson(decisionRequest))

      val response = await(testDecisionController.decide()(fakeRequest))

      status(response) shouldBe OK
      jsonBodyOf(response) shouldBe Json.obj(
        "version" -> DecisionServiceVersion.v1_5_0,
        "correlationID" -> "",
        "score" -> Json.obj(),
        "result" -> ResultEnum.UNKNOWN,
        "resultWithoutBooa" -> ResultEnum.UNKNOWN
      )
    }

    "return a 400 error for invalid json" in {

      val fakeRequest = FakeRequest(Helpers.POST, "/decide").withBody(Json.parse("{}"))

      val response = await(testDecisionController.decide()(fakeRequest))

      status(response) shouldBe BAD_REQUEST
      jsonBodyOf(response) shouldBe Json.parse(
        """{"code":400,"message":"{\"obj.version\":[{\"msg\":[\"error.path.missing\"],\"args\":[]}],\"obj.interview\":[{\"msg\":[\"error.path.missing\"],\"args\":[]}],\"obj.correlationID\":[{\"msg\":[\"error.path.missing\"],\"args\":[]}]}","details":"{\"incorrectRequest\":List((/interview,List(JsonValidationError(List(error.path.missing),WrappedArray()))), (/version,List(JsonValidationError(List(error.path.missing),WrappedArray()))), (/correlationID,List(JsonValidationError(List(error.path.missing),WrappedArray()))))}"}"""
      )
    }

    "return a 400 error for a non json response" in {

      val fakeRequest = FakeRequest(Helpers.POST, "/decide").withBody(toJson("{}"))

      val response = await(testDecisionController.decide()(fakeRequest))

      status(response) shouldBe BAD_REQUEST
      jsonBodyOf(response) shouldBe Json.parse(
        """{"code":400,"message":"{\"obj\":[{\"msg\":[\"error.expected.jsobject\"],\"args\":[]}]}","details":"{\"incorrectRequest\":List((,List(JsonValidationError(List(error.expected.jsobject),WrappedArray()))))}"}"""
      )
    }
  }
}
