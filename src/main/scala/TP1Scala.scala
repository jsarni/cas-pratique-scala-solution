
object TP1Scala {

  /**
   * Exercice 1: Listes
   *
   * Insérer le chiffre 0 à la 5ème position
   */
  def exercice1(): List[Int] = {
    val input: List[Int] = List(1, 2, 3, 4, 5, 6, 7)

    val output: List[Int] =  (input.dropRight(input.length - 4) :+ 0) ++ input.drop(4)

    output
  }

  /**
   * Exercice 2: Listes
   *
   * Implémenter et utiliser la méthode reverse, pour inverser
   * les élements d'une liste.
   * Ne pas utiliser la méthode reverse des listes
   * Pense à la récursion
   *
   */
  def exercice2(): List[Any] = {
    val input: List[Any] = List(1, 2, "3", 4.0, 5)

    def reverse(list: List[Any]): List[Any] = {
      if (list.isEmpty) Nil
      else reverse(list.tail) :+ list.head
    }

    val output: List[Any] = reverse(input)

    output
  }

  /**
   * Exercice 3: Filter/Map
   *
   * Filtrer les élements de la liste pour ne retenir que les
   * mot commençant par la lettre A (case unsensitive), puis
   * renvoyer la longeur de chaque mot.
   *
   * Exemple: List("Char", "Arctique", "Mot", "allemagne") => List(8, 9)
   *
   */
  def exercice3(): List[Int] = {
    val input: List[String] = List("Argent", "Arbre", "bleu", "liste", "arbre")

    val output: List[Int] =
      input
        .filter(_.toLowerCase.startsWith("a"))
        .map(_.length)

    output
  }

  /**
   * Exercice 4: Pattern Matching et options
   *
   * Ecrire la methode qui extrait la valeur d'une option si elle existe,
   * Ou de renvoyer la valeur par défaut -1 si elle n'existe pas
   *
   */
  def exercice4(opt: Option[Int]): Int = {

    opt match {
      case Some(v) => v
      case None => -1
    }
  }

  /**
   * Exercice 5: Exercice Complet
   *
   * Le but de cet exercice est de renvoyer un certain nombre d'informations
   * sur les 4 services d'une entreprise (Compta, Achat, Vente, RH)
   *    - Le nom du service avec le plus d'employés
   *    - Le salaire moyen de l'entreprise
   *    - La masse salariale de chaque service
   *    - Les services classés par masse salariale (de la plus grosse à la plus faible)
   *    - Les services n'employant pas de femme
   *
   * Ces informations devront etre contenues dans une instance de la case class Solution5
   *
   * Il faut d'abord définir le type qui convient le mieux de chaque élément de la case class
   * (remplacer le Any par le bon type)
   *
   * Vous êtes libres de procéder comme vous voulez.
   */

  case class Solution5(
                        service_avec_le_plus_demployes: String,
                        salaire_moyen: Double,
                        masse_salariale_par_service: Map[String, Double],
                        services_ordonnes_par_masse_salariale: List[String],
                        services_integralement_masculins: Option[List[String]]
                      )

  def exercice5(): Solution5 = {

    case class Employe(id: Int, service: String, salaire: Double, masculin: Boolean)

    val liste_services: List[String] = List("Compta", "Achat", "Vente", "RH")

    val liste_des_employes: List[Employe] = List(
      Employe(id = 1, service = "Compta", salaire = 50000, masculin = false),
      Employe(id = 2, service = "Achat", salaire = 41000, masculin = false),
      Employe(id = 3, service = "Vente", salaire = 39000, masculin = false),
      Employe(id = 4, service = "RH", salaire = 50000, masculin = true),
      Employe(id = 5, service = "Vente", salaire = 120000, masculin = true),
      Employe(id = 6, service = "Vente", salaire = 10000, masculin = false),
      Employe(id = 7, service = "Vente", salaire = 45000, masculin = false),
      Employe(id = 8, service = "Achat", salaire = 110000, masculin = true),
      Employe(id = 9, service = "Vente", salaire = 27000, masculin = true),
      Employe(id = 10, service = "RH", salaire = 23000, masculin = false),
      Employe(id = 11, service = "RH", salaire = 13000, masculin = true)
    )

    val employes_par_service: Map[String, List[Employe]] =
      liste_services.map(
        service =>
          service -> liste_des_employes.filter(_.service == service)
      ).toMap

    /**
     *  Service avec le plus d'employés
     */
    val service_avec_le_plus_demployes: String = employes_par_service.map {
      keyValue => keyValue._1 -> keyValue._2.length
    }.maxBy(_._2)
      ._1

    /**
     * Salaire Moyen
     */
    val salaire_moyen: Double = liste_des_employes.map(_.salaire).sum / liste_des_employes.length

    /**
     * Masse salariale par service
     */
    val masse_salariale_par_service: Map[String, Double] = employes_par_service.map {
      case (service, employes) => (service, employes.map(_.salaire).sum)
    }

    /**
     * Services ordonnés par masse salariale
     */
    val services_ordonnes_par_masse_salariale: List[String] = masse_salariale_par_service.toList.sortBy(_._2).reverse.map(_._1)

    /**
     * Services integralement masculins
     */
    val services_integralement_masculins: Option[List[String]] = employes_par_service
      .map(elem => elem._1 -> elem._2.forall(_.masculin))
      .filter(_._2)
      .keys
      .toList match {
      case Nil => None
      case l => Some(l)
    }

    val solution: Solution5 =
      Solution5(
        service_avec_le_plus_demployes,
        salaire_moyen,
        masse_salariale_par_service,
        services_ordonnes_par_masse_salariale,
        services_integralement_masculins
      )

    solution
  }
}

