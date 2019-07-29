package uk.gov.hmrc.helpers


import play.api.libs.json.Json

import uk.gov.hmrc.decisionservice.model.api.DecisionRequest

trait CaseTestData {


  // scalastyle:off


  val decisionCase1a = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map("setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),
    "exit" -> Map("officeHolder" -> "No"),
    "personalService" -> Map(),"control"-> Map(),
    "financialRisk" -> Map("expensesAreNotRelevantForRole" -> "No"),"partAndParcel"-> Map())))

  val decisionRespone1 = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase1b = Json.toJson(DecisionRequest("1.5.0-final","session-12345",
    Map("setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),
      "personalService" -> Map("workerSentActualSubstitute" -> "noSubstitutionHappened","possibleSubstituteRejection" -> "wouldReject","wouldWorkerPayHelper" -> "No"))))

  val decisionRespone1b = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase1c = Json.toJson(DecisionRequest("1.5.0-final","session-12345",
    Map("setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),"control" -> Map("engagerMovingWorker" -> "canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone" -> "workerAgreeWithOthers","whenWorkHasToBeDone" -> "workerAgreeSchedule","workerDecideWhere" -> "workerCannotChoose"))))
  val decisionRespone1c = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase1d = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),
    "financialRisk" -> Map("workerProvidedMaterials" -> "No","workerProvidedEquipment" -> "No","workerUsedVehicle" -> "No","workerHadOtherExpenses" -> "No","expensesAreNotRelevantForRole" -> "Yes","workerMainIncome" -> "incomeCalendarPeriods","paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"))))

  val decisionRespone1d = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase1e = Json.toJson(DecisionRequest("1.5.0-final","session-12345",
    Map("setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),
      "exit" -> Map ("officeHolder" -> "No"),
      "personalService" -> Map("workerSentActualSubstitute" -> "noSubstitutionHappened","possibleSubstituteRejection" -> "wouldReject","wouldWorkerPayHelper" -> "No"),
      "control" -> Map("engagerMovingWorker" -> "canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone" -> "workerAgreeWithOthers","whenWorkHasToBeDone" -> "workerAgreeSchedule","workerDecideWhere" -> "workerCannotChoose"),
      "financialRisk" -> Map("workerProvidedMaterials" -> "No","workerProvidedEquipment" -> "No","workerUsedVehicle" -> "No","workerHadOtherExpenses" -> "No","expensesAreNotRelevantForRole" -> "Yes","workerMainIncome" -> "incomeCalendarPeriods","paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"),
      "partAndParcel" -> Map("workerReceivesBenefits" -> "No","workerAsLineManager" -> "No","contactWithEngagerCustomer" -> "Yes","workerRepresentsEngagerBusiness" -> "workAsIndependent"))))

  val decisionRespone1e = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"LOW","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""



  val decisionCase2a = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "exit" -> Map("officeHolder" -> "No"),
    "personalService" -> Map(),
    "control"-> Map(),
    "financialRisk" -> Map("expensesAreNotRelevantForRole" -> "No"),
    "partAndParcel"-> Map())))

  val decisionRespone2 = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase2b = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "personalService" -> Map("workerSentActualSubstitute" -> "noSubstitutionHappened","possibleSubstituteRejection" -> "wouldReject","wouldWorkerPayHelper" -> "No"))))

  val decisionRespone2b = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase2c = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "control" -> Map("engagerMovingWorker" -> "canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone" -> "workerDecidesWithoutInput","whenWorkHasToBeDone" -> "workerAgreeSchedule","workerDecideWhere" -> "workerCannotChoose"))))

  val decisionRespone2c = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase2d = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "financialRisk" -> Map("workerProvidedMaterials" -> "No","workerProvidedEquipment" -> "No","workerUsedVehicle" -> "No","workerHadOtherExpenses" -> "No","expensesAreNotRelevantForRole" -> "Yes","workerMainIncome" -> "incomeCalendarPeriods","paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"))))

  val decisionRespone2d = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase2e = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "exit" -> Map ("officeHolder" -> "No"),
    "personalService" -> Map("workerSentActualSubstitute" -> "noSubstitutionHappened","possibleSubstituteRejection" -> "wouldReject","wouldWorkerPayHelper" -> "No"),
    "control" -> Map("engagerMovingWorker" -> "canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone" -> "workerDecidesWithoutInput","whenWorkHasToBeDone" -> "workerAgreeSchedule","workerDecideWhere" -> "workerCannotChoose"),
    "financialRisk" -> Map("workerProvidedMaterials" -> "No","workerProvidedEquipment" -> "No","workerUsedVehicle" -> "No","workerHadOtherExpenses" -> "No","expensesAreNotRelevantForRole" -> "Yes","workerMainIncome" -> "incomeCalendarPeriods","paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"),
    "partAndParcel" -> Map("workerReceivesBenefits" -> "No","workerAsLineManager" -> "No","contactWithEngagerCustomer" -> "Yes","workerRepresentsEngagerBusiness" -> "workAsIndependent"))))

  val decisionRespone2e = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"LOW","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Inside IR35"}"""




  val decisionCase3a = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),
    "exit" -> Map("officeHolder" -> "No"),
    "personalService" -> Map(),
    "control"-> Map(),
    "financialRisk" -> Map("expensesAreNotRelevantForRole" -> "No"),
    "partAndParcel"-> Map())))

  val decisionRespone3 = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase3b = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "personalService" -> Map("workerSentActualSubstitute" -> "noSubstitutionHappened","possibleSubstituteRejection" -> "wouldNotReject","possibleSubstituteWorkerPay" -> "No","wouldWorkerPayHelper" -> "No"))))

  val decisionRespone3b = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"MEDIUM","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase3c = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "control" -> Map("engagerMovingWorker" -> "cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone" -> "workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone" -> "workerDecideSchedule","workerDecideWhere" -> "noLocationRequired"))))

  val decisionRespone3c = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"exit":"NotValidUseCase","control":"OUTOFIR35","setup":"CONTINUE"},"result":"Outside IR35"}"""


  val decisionCase3d = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "soleTrader"),
    "financialRisk" -> Map("workerProvidedMaterials" -> "No","workerProvidedEquipment" -> "No","workerUsedVehicle" -> "No","workerHadOtherExpenses" -> "No","expensesAreNotRelevantForRole" -> "Yes","workerMainIncome" -> "incomeCalendarPeriods","paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"))))

  val decisionRespone3d = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase3e = Json.toJson(DecisionRequest("1.5.0-final","session-12345",Map(
    "setup" -> Map("endUserRole" -> "personDoingWork","hasContractStarted" -> "Yes","provideServices" -> "limitedCompany"),
    "exit" -> Map ("officeHolder" -> "No"),
    "personalService" -> Map("workerSentActualSubstitute" -> "noSubstitutionHappened","possibleSubstituteRejection" -> "wouldNotReject","possibleSubstituteWorkerPay" -> "No","wouldWorkerPayHelper" -> "Yes"),
    "control" -> Map("engagerMovingWorker" -> "cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone" -> "workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone" -> "workerDecideSchedule","workerDecideWhere" -> "noLocationRequired"),
    "financialRisk" -> Map("workerProvidedMaterials" -> "No","workerProvidedEquipment" -> "No","workerUsedVehicle" -> "No","workerHadOtherExpenses" -> "No","expensesAreNotRelevantForRole" -> "Yes","workerMainIncome" -> "incomeCalendarPeriods","paidForSubstandardWork" -> "asPartOfUsualRateInWorkingHours"),
    "partAndParcel" -> Map("workerReceivesBenefits" -> "No","workerAsLineManager" -> "No","contactWithEngagerCustomer" -> "Yes","workerRepresentsEngagerBusiness" -> "workAsIndependent"))))


  val decisionRespone3e = """{"version":"1.5.0-final","correlationID":"session-12345","score":{"exit":"CONTINUE","control":"OUTOFIR35","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase4a =  """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone4 = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase4b =  """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone4b = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase4c = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"workerAgreeWithOthers"}}}"""
  val decisionRespone4c = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase4d = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"}}}"""
  val decisionRespone4d = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"MEDIUM","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase4e =  """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"workerAgreeWithOthers"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone4e = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"LOW","financialRisk":"MEDIUM","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""



  val decisionCase5a = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone5 = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase5b = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone5b = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase5c = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"workerDecideSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone5c = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","score":{"exit":"NotValidUseCase","control":"OUTOFIR35","setup":"CONTINUE"},"result":"Outside IR35"}"""


  val decisionCase5d = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"}}}"""
  val decisionRespone5d = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","score":{"partAndParcel":"NotValidUseCase","financialRisk":"MEDIUM","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase5e = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"workerDecideSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone5e = """{"version":"1.5.0-final","correlationID":"session-4ab87a6b-2dea-49db-a519-650a12ae06b1","score":{"exit":"CONTINUE","control":"OUTOFIR35","setup":"CONTINUE"},"result":"Outside IR35"}"""



  val decisionCase6a = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone6 = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase6b = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone6b = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase6c = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"noScheduleRequiredOnlyDeadlines","workerDecideWhere":"workerAgreeWithOthers"}}}"""
  val decisionRespone6c = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase6d = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"Yes","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"}}}"""
  val decisionRespone6d = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase6e = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"noScheduleRequiredOnlyDeadlines","workerDecideWhere":"workerAgreeWithOthers"},"financialRisk":{"workerProvidedMaterials":"Yes","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone6e = """{"version":"1.5.0-final","correlationID":"session-425437df-24ce-4e97-8537-d521697277d5","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""


  val decisionCase7a = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone7 = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase7b = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone7b = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase7c = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone7c = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase7d = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"}}}"""
  val decisionRespone7d = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase7e = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone7e = """{"version":"1.5.0-final","correlationID":"session-3015fd77-c21b-4b49-b166-ff6170b834c8","score":{"partAndParcel":"LOW","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""


  val decisionCase8a = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone8 = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase8b = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone8b = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase8c = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone8c = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase8d = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"}}}"""
  val decisionRespone8d = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase8e = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"noObligationToCorrect"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"Yes","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone8e = """{"version":"1.5.0-final","correlationID":"session-8cbd115f-d486-46d8-ba89-1d7531c96479","score":{"partAndParcel":"HIGH","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Inside IR35"}"""



  val decisionCase9a = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone9 = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase9b = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone9b = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase9c = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"workerAgreeWithOthers"}}}"""
  val decisionRespone9c = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase9d = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCosts"}}}"""
  val decisionRespone9d = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase9e = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"workerAgreeWithOthers"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCosts"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone9e = """{"version":"1.5.0-final","correlationID":"session-a9aed912-33b1-49ad-b972-72b5d8c65be0","score":{"partAndParcel":"LOW","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Inside IR35"}"""


  val decisionCase10a = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone10 = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase10b = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"personalService":{"workerSentActualSubstitute":"yesClientAgreed","workerPayActualSubstitute":"No","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone10b = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"MEDIUM","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase10c = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"noScheduleRequiredOnlyDeadlines","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone10c = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase10d = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeFixed","paidForSubstandardWork":"outsideOfHoursNoCharge"}}}"""
  val decisionRespone10d = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase10e = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"yesClientAgreed","workerPayActualSubstitute":"No","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"noScheduleRequiredOnlyDeadlines","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeFixed","paidForSubstandardWork":"outsideOfHoursNoCharge"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone10e = """{"version":"1.5.0-final","correlationID":"session-30128ec4-15e1-4ff0-a487-3dc866f8d25d","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""


  val decisionCase11a = """"""
  val decisionRespone11 = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase11b = """"""
  val decisionRespone11b = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase11c = """"""
  val decisionRespone11c = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase11d = """"""
  val decisionRespone11d = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"NotValidUseCase","financialRisk":"MEDIUM","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase11e = """"""
  val decisionRespone11e = """{"version":"1.5.0-final","correlationID":"session-72dc03fc-c41e-49be-bee3-f207fb21e8ec","score":{"partAndParcel":"LOW","financialRisk":"MEDIUM","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""


  val decisionCase12a = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone12 = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase12b = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone12b = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"MEDIUM","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase12c = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"scheduleDecidedForWorker","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone12c = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase12d = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"}}}"""
  val decisionRespone12d = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase12e = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"scheduleDecidedForWorker","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone12e = """{"version":"1.5.0-final","correlationID":"session-8975db1b-80d7-4c76-85d6-03a25c558925","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""


  val decisionCase13a = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone13 = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase13b = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone13b = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"MEDIUM","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase13c = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone13c = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase13d = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCosts"}}}"""
  val decisionRespone13d = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase13e = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCosts"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workForEndClient"}}}"""
  val decisionRespone13e = """{"version":"1.5.0-final","correlationID":"session-f49e56a6-b690-4c06-a0d8-f82f836a58d7","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""



  val decisionCase14a = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone14 = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase14b = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone14b = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase14c = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerDecideSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone14c = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase14d = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"}}}"""
  val decisionRespone14d = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase14e = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerDecideSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone14e = """{"version":"1.5.0-final","correlationID":"session-7ff64104-e39b-4e75-8960-3bccbcb7df23","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""



  val decisionCase15a = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone15 = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase15b = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone15b = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase15c = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone15c = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase15d = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"}}}"""
  val decisionRespone15d = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase15e = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"Yes","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone15e = """{"version":"1.5.0-final","correlationID":"session-b2d2388f-b241-4957-8141-2d0c5c0836a2","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""



  val decisionCase16a = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone16 = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase16b = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone16b = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase16c = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerAgreeWithOthers","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone16c = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase16d = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"}}}"""
  val decisionRespone16d = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase16e = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerAgreeWithOthers","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone16e = """{"version":"1.5.0-final","correlationID":"session-f757b601-7eec-46db-8024-652e6d425957","score":{"partAndParcel":"LOW","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""




  val decisionCase17a = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone17 = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase17b = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone17b = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase17c = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"noScheduleRequiredOnlyDeadlines","workerDecideWhere":"workerCannotChoose"}}}"""
  val decisionRespone17c = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase17d = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"}}}"""
  val decisionRespone17d = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"MEDIUM","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase17e = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"noScheduleRequiredOnlyDeadlines","workerDecideWhere":"workerCannotChoose"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone17e = """{"version":"1.5.0-final","correlationID":"session-4d138f6f-3656-4044-ba7d-6a8540e094dc","score":{"partAndParcel":"LOW","financialRisk":"MEDIUM","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""




  val decisionCase18a = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone18 = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase18b = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone18b = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase18c =  """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"workerDecideSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone18c = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase18d =  """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"}}}"""
  val decisionRespone18d = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase18e = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerDecidesWithoutInput","whenWorkHasToBeDone":"workerDecideSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone18e = """{"version":"1.5.0-final","correlationID":"session-e7d07a17-3cfe-4ff6-bcca-cda7d0eb651e","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""



  val decisionCase19a = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone19 = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase19b = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone19b = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase19c = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone19c = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase19d = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeFixed","paidForSubstandardWork":"cannotBeCorrected"}}}"""
  val decisionRespone19d = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","score":{"financialRisk":"OUTOFIR35","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Outside IR35"}"""

  val decisionCase19e = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"Yes","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"No","workerMainIncome":"incomeFixed","paidForSubstandardWork":"cannotBeCorrected"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone19e = """{"version":"1.5.0-final","correlationID":"session-6dc80962-346a-4c25-b5a6-7d08cabee4c9","score":{"financialRisk":"OUTOFIR35","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Outside IR35"}"""


  val decisionCase20a = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone20 = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase20b = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone20b = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"MEDIUM","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase20c = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone20c = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase20d = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"}}}"""
  val decisionRespone20d = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","score":{"partAndParcel":"NotValidUseCase","financialRisk":"MEDIUM","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase20e = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"outsideOfHoursNoCharge"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workAsIndependent"}}}"""
  val decisionRespone20e = """{"version":"1.5.0-final","correlationID":"session-685d7f4f-92c3-49c2-9520-09836fa0390b","score":{"partAndParcel":"LOW","financialRisk":"MEDIUM","personalService":"MEDIUM","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Unknown"}"""


  val decisionCase21a = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone21 = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase21b = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone21b = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"HIGH","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase21c = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"}}}"""
  val decisionRespone21c = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"HIGH","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase21d = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"}}}"""
  val decisionRespone21d = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase21e = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"limitedCompany"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldReject","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"canMoveWorkerWithoutPermission","workerDecidingHowWorkIsDone":"workerFollowStrictEmployeeProcedures","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"noLocationRequired"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"asPartOfUsualRateInWorkingHours"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"No"}}}"""
  val decisionRespone21e = """{"version":"1.5.0-final","correlationID":"session-bb2b9dee-2599-4494-9c4d-324709e81adc","score":{"partAndParcel":"LOW","financialRisk":"LOW","personalService":"HIGH","exit":"CONTINUE","control":"HIGH","setup":"CONTINUE"},"result":"Inside IR35"}"""


  val decisionCase22a = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{},"control":{},"financialRisk":{"expensesAreNotRelevantForRole":"No"},"partAndParcel":{}}}"""
  val decisionRespone22 = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"CONTINUE","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase22b = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"}}}"""
  val decisionRespone22b = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"MEDIUM","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase22c = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"noWorkerInputAllowed","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"workerCannotChoose"}}}"""
  val decisionRespone22c = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","score":{"partAndParcel":"NotValidUseCase","financialRisk":"NotValidUseCase","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"MEDIUM","setup":"CONTINUE"},"result":"Not Matched"}"""


  val decisionCase22d = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"cannotBeCorrected"}}}"""
  val decisionRespone22d = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","score":{"partAndParcel":"NotValidUseCase","financialRisk":"LOW","personalService":"NotValidUseCase","exit":"NotValidUseCase","control":"NotValidUseCase","setup":"CONTINUE"},"result":"Not Matched"}"""

  val decisionCase22e =  """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","interview":{"setup":{"endUserRole":"personDoingWork","hasContractStarted":"Yes","provideServices":"soleTrader"},"exit":{"officeHolder":"No"},"personalService":{"workerSentActualSubstitute":"noSubstitutionHappened","possibleSubstituteRejection":"wouldNotReject","possibleSubstituteWorkerPay":"No","wouldWorkerPayHelper":"No"},"control":{"engagerMovingWorker":"cannotMoveWorkerWithoutNewAgreement","workerDecidingHowWorkIsDone":"noWorkerInputAllowed","whenWorkHasToBeDone":"workerAgreeSchedule","workerDecideWhere":"workerCannotChoose"},"financialRisk":{"workerProvidedMaterials":"No","workerProvidedEquipment":"No","workerUsedVehicle":"No","workerHadOtherExpenses":"No","expensesAreNotRelevantForRole":"Yes","workerMainIncome":"incomeCalendarPeriods","paidForSubstandardWork":"cannotBeCorrected"},"partAndParcel":{"workerReceivesBenefits":"No","workerAsLineManager":"No","contactWithEngagerCustomer":"Yes","workerRepresentsEngagerBusiness":"workForEndClient"}}}"""
  val decisionRespone22e = """{"version":"1.5.0-final","correlationID":"session-72f6b69a-018e-4ad7-8589-a04658801d32","score":{"partAndParcel":"MEDIUM","financialRisk":"LOW","personalService":"MEDIUM","exit":"CONTINUE","control":"MEDIUM","setup":"CONTINUE"},"result":"Inside IR35"}"""



  // scalastyle:on

}