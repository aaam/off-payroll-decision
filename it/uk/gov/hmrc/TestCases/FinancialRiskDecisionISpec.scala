package uk.gov.hmrc.TestCases

import play.api.libs.json.Json.obj

class FinancialRiskDecisionISpec extends BaseISpec {

  "Financial Risk Section" should {

    Seq(OldRuleEngine, NewRuleEngine).foreach { implicit engine =>

      s"POST ${engine.path}" should {

        "Scenario 1: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 2: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 3: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 4: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 5: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 6: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 7: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 8: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> true,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 9: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 10: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 11: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 12: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> true,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 13: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 14: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 15: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 16: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 17: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 18: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 19: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 20: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 21: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 22: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 23: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 24: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 25: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 26: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 27: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 28: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "outsideOfHoursNoCharge"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 29: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 30: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 31: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 32: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 33: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 34: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 35: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 36: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 37: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 38: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 39: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 40: return a 200, a OUTOFIR35 for financial risk and Outside IR35 result" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"OUTOFIR35"""")
            result.body should include(""""result":"Outside IR35"""")
          }
        }

        "Scenario 41: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 42: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 43: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 44: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 45: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 46: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 47: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 48: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 49: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 50: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 51: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 52: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 53: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 54: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 55: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 56: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 57: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 58: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 59: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 60: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 61: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 62: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 63: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 64: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 65: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 66: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 67: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 68: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 69: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 70: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCalendarPeriods",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 71: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 72: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 73: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeFixed",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 74: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 75: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 76: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomePieceRate",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 77: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 78: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 79: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> true,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 80: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> false,
              "expensesAreNotRelevantForRole" -> true,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 81: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 82: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 83: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 84: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeCommission",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 85: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "outsideOfHoursNoCosts"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 86: return a 200, a LOW for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"LOW"""")
          }
        }

        "Scenario 86: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "cannotBeCorrected"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }

        "Scenario 87: return a 200, a MEDIUM for financial risk" in {

          lazy val res = postRequest(engine.path,
            interview(financialRisk = obj(
              "workerProvidedMaterials" -> false,
              "workerProvidedEquipment" -> false,
              "workerUsedVehicle" -> false,
              "workerHadOtherExpenses" -> true,
              "expensesAreNotRelevantForRole" -> false,
              "workerMainIncome" -> "incomeProfitOrLosses",
              "paidForSubstandardWork" -> "noObligationToCorrect"
            ))
          )

          whenReady(res) { result =>
            result.status shouldBe OK
            result.body should include(""""financialRisk":"MEDIUM"""")
          }
        }
      }
    }
  }
}