package uk.gov.hmrc.decisionservice.service

import cats.data.Xor
import uk.gov.hmrc.decisionservice.model.{DecisionServiceError, FactError, RulesFileLoadError}
import uk.gov.hmrc.decisionservice.model.api.QuestionSet
import uk.gov.hmrc.decisionservice.model.rules._
import uk.gov.hmrc.decisionservice.ruleengine._


//trait DecisionService {
//
//  type SectionRules = List[SectionRuleSet]
//  type CarryOverFacts = Map[String,CarryOver]
//
//  val maybeSectionRules:Xor[DecisionServiceError,SectionRules]
//
//  val maybeMatrixRules:Xor[DecisionServiceError,MatrixRuleSet]
//
//  val csvSectionMetadata:List[RulesFileMetaData]
//
//  val csvMatrixMetadata:RulesFileMetaData
//
//  def loadSectionRules():Xor[DecisionServiceError,SectionRules] = {
//    val maybeRules = csvSectionMetadata.map(SectionRulesLoader.load(_))
//    val rulesErrors = maybeRules.collect {case Xor.Left(x) => x}
//    val rules = maybeRules.collect{case Xor.Right(x) => x}
//    rulesErrors match {
//      case Nil => Xor.right(rules)
//      case _ => Xor.left(rulesErrors.foldLeft(RulesFileLoadError(""))(_ ++ _))
//    }
//  }
//
//  def loadMatrixRules():Xor[DecisionServiceError,MatrixRuleSet] =
//    MatrixRulesLoader.load(csvMatrixMetadata)
//
//  def >>>:(questionSet:QuestionSet):Xor[DecisionServiceError,MatrixDecision] = {
//    val maybeDecision = for {
//      sectionRules <- maybeSectionRules
//      matrixRules <- maybeMatrixRules
//      carryOvers <- applyToSectionRules(questionSet, sectionRules)
//      decision <- applyToMatrixRules(carryOvers, matrixRules)
//    }
//    yield {
//      decision
//    }
//    maybeDecision
//  }
//
//  private def applyToSectionRules(questionSet:QuestionSet,sectionRules:SectionRules):Xor[DecisionServiceError,CarryOverFacts] = {
//    val pairs = for {
//      sectionRuleSet <- sectionRules
//      sectionFacts <- questionSet.sections.get(sectionRuleSet.section)
//    } yield {
//      (sectionRuleSet.section, SectionFactMatcher.matchFacts(sectionFacts, sectionRuleSet))
//    }
//    val rulesErrors = pairs.collect {case (a,Xor.Left(x)) => x}
//    val entries = pairs.collect {case (sectionName,Xor.Right(x)) => (sectionName,x)}
//    rulesErrors match {
//      case Nil => Xor.right(Map(entries: _*))
//      case _ => Xor.left(rulesErrors.head)
//    }
//  }
//
//  def applyToMatrixRules(carryOvers:CarryOverFacts, matrixRules:MatrixRuleSet):Xor[DecisionServiceError,MatrixDecision] =
//    MatrixFactMatcher.matchFacts(carryOvers, matrixRules)
//}
//
//
//object DecisionServiceInstance extends DecisionService {
//  lazy val maybeSectionRules = loadSectionRules()
//  lazy val maybeMatrixRules = loadMatrixRules()
//
//  val csvSectionMetadata = List(
//    (7, 2, "/business_structure.csv", "BusinessStructure"),
//    (9, 2, "/personal_service.csv", "PersonalService")
//  ).collect{case (q,r,f,n) => RulesFileMetaData(q,r,f,n)}
//
//  val csvMatrixMetadata = RulesFileMetaData(2, 1, "/matrix.csv", "matrix")
//}
