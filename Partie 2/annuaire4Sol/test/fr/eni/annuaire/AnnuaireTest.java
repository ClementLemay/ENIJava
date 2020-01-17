package fr.eni.annuaire;

public class AnnuaireTest {

	public static void main(String[] args) {
		
		System.out.println("Partie 1 - Instanciation de 4 employés.");
		Employe e1 = new Employe(1, "Bob",  "bob@campus-eni.fr");
		Employe e2 = new Employe(2, "Charles",  "charles@campus-eni.fr");
		Employe e3 = new Employe(3, "Geraldine",  "geraldine@campus-eni.fr");
		Employe e4 = new Employe(4, "Anne",  "anne@campus-eni.fr");

		System.out.println("e1 : " + e1);
		System.out.println("e2 : " + e2);
		System.out.println("e3 : " + e3);
		System.out.println("e4 : " + e4);
		
		System.out.println("\nPartie 2 - Test de l'annuaire de type List");
		//Annuaire annuaire = new Annuaire();
		AnnuaireMapImpl annuaire = new AnnuaireMapImpl();
		
		//Ajout des employés
		annuaire.ajouterEmploye(e1);
		annuaire.ajouterEmploye(e2);
		annuaire.ajouterEmploye(e3);
		annuaire.ajouterEmploye(e4);
		
		//Affichage de l'annuaire
		annuaire.afficher();
		
		Employe emp;
		try {
			System.out.println("Recherche d'un employé existant : ");
			emp = annuaire.getEmployeParNo(2);
			System.out.println("Employé trouvé : " + emp.toString());
			
			System.out.println("Recherche d'un employé non connu : ");
			emp = annuaire.getEmployeParNo(12);

			System.out.println("Cette ligne ne doit pas s'afficher " + emp.toString());

		} catch (AnnuaireException e) {
			// TODO Auto-generated catch block
			System.out.println("Une erreur est survenue : " + e.getMessage());
		}
		
		
	}
	
}
