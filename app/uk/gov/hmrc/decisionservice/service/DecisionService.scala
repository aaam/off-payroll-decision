package uk.gov.hmrc.decisionservice.service

import cats.data.Xor
import uk.gov.hmrc.decisionservice.model.{DecisionServiceError, FactError, RulesFileLoadError}
import uk.gov.hmrc.decisionservice.model.api.QuestionSet
import uk.gov.hmrc.decisionservice.model.rules._
import uk.gov.hmrc.decisionservice.ruleengine._


trait DecisionService {
  def evaluate(questionSet:QuestionSet, matrixRuleSet:MatrixRuleSet):Xor[DecisionServiceError,MatrixDecision]
}


object DecisionServiceInstance extends DecisionService {
  val csvSectionMetadata = List(
    (7, 2, "/business_structure.csv", "BusinessStructure"),
    (9, 2, "/personal_service.csv", "PersonalService")
  ).collect{case (q,r,f,n) => RulesFileMetaData(q,r,f,n)}
  val csvMatrixMetadata = RulesFileMetaData(2, 2, "matrix.csv", "matrix")

  def loadSectionRules():Xor[DecisionServiceError,List[SectionRuleSet]] = {
    val maybeRules = csvSectionMetadata.map(SectionRulesLoader.load(_))
    val rulesErrors = maybeRules.map(_.fold(e => Some(e),r => None)).flatten
    val rules = maybeRules.collect{case Xor.Right(x) => x}
    if (rulesErrors.isEmpty) Xor.right(rules) else Xor.left(rulesErrors.head) // TODO aggregate multiple errors here
  }

  def loadMatrixRules():Xor[DecisionServiceError,MatrixRuleSet] = {
    val maybeRules = MatrixRulesLoader.load(csvMatrixMetadata)
    maybeRules
  }

  def evaluate(questionSet:QuestionSet, matrixRuleSet:MatrixRuleSet):Xor[DecisionServiceError,MatrixDecision] = {
    val maybeDecision = for {
      sectionRules <- loadSectionRules()
      matrixRules <- loadMatrixRules()
      carryOvers <- applyToSectionRules(questionSet, sectionRules)
      decision <- applyToMatrixRules(carryOvers, matrixRules)
    }
    yield {
      decision
    }

    maybeDecision
  }

  def applyToSectionRules(questionSet:QuestionSet,sectionRules:List[SectionRuleSet]):Xor[DecisionServiceError,Map[String,CarryOver]] = {
    val pairs = for {
      sectionRuleSet <- sectionRules
      sectionFacts <- questionSet.sections.get(sectionRuleSet.section)
    } yield {
      (sectionRuleSet.section, SectionFactMatcher.matchFacts(sectionFacts, sectionRuleSet))
    }
    val rulesErrors = pairs.map(_._2.fold(e => Some(e),r => None)).flatten
    val entries = pairs.collect{case (sectionName,Xor.Right(x)) => (sectionName,x)}
    if (rulesErrors.isEmpty) Xor.right(Map(entries: _*)) else Xor.left(rulesErrors.head) // TODO aggregate multiple errors here
  }

  def applyToMatrixRules(carryOvers:Map[String,CarryOver], matrixRules:MatrixRuleSet):Xor[DecisionServiceError,MatrixDecision] =
    MatrixFactMatcher.matchFacts(carryOvers, matrixRules)

}
