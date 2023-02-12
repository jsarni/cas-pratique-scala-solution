import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.{GivenWhenThen, OptionValues, TryValues}

class TP1ScalaTest extends AnyFlatSpec
  with GivenWhenThen
  with Matchers
  with OptionValues
  with TryValues {

  import TP1Scala.Solution5

  "exercice1" should "pass" in {
    TP1Scala.exercice1() should contain theSameElementsInOrderAs List(1, 2, 3, 4, 0, 5, 6, 7)
  }

  "exercice2" should "pass" in {
    TP1Scala.exercice2() should contain theSameElementsInOrderAs List(1, 2, "3", 4.0, 5).reverse
  }

  "exercice3" should "pass" in {
    TP1Scala.exercice3() should contain theSameElementsInOrderAs List(6, 5, 5)
  }

  "exercice4" should "pass" in {
    TP1Scala.exercice4(Some(10)) shouldBe 10
    TP1Scala.exercice4(None) shouldBe -1
  }

  "exercice5" should "pass" in {
    TP1Scala.exercice5() shouldBe Solution5(
      service_avec_le_plus_demployes = "Vente",
      salaire_moyen = 48000.0,
      masse_salariale_par_service = Map("Compta" -> 50000.0, "Achat" -> 151000.0, "Vente" -> 241000.0, "RH" -> 86000.0),
      services_ordonnes_par_masse_salariale = List("Vente", "Achat", "RH", "Compta"),
      services_integralement_masculins = None)
  }
}

