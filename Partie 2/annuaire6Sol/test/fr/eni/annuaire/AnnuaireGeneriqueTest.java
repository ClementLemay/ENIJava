package fr.eni.annuaire;

import fr.eni.annuaire.AnnuaireException;
import fr.eni.annuaire.Employe;

public class AnnuaireGeneriqueTest
{

	public static void main(String[] args) 
	{
		//Test avec des employés
		//Annuaire annuaire = new Annuaire();
		//AnnuaireMapImpl annuaire = new AnnuaireMapImpl();
		//ModeleAnnuaire annuaire = new AnnuaireMapImpl();
		AnnuaireGenerique<Employe> annuaire = new AnnuaireGenerique<>();
		
		Employe e1 = new Employe(1, "Pierre",  "robert@free.fr");
		Employe e2 = new Employe(2, "b", "b@free.fr");
		Employe e3 = new Employe(3, "c",  "c@free.fr");
		annuaire.ajouter(e1);
		annuaire.ajouter(e2);
		annuaire.ajouter(e3);
		
		Employe employe = null;
		try {
			System.out.println("Test de recherche d'un employe existant");
			employe = annuaire.getParNo(1);
			
			System.out.println("Employé trouvé : " + employe.toString());


		
		} catch (AnnuaireException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur : " + e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		//Test avec des matériels
		AnnuaireGenerique<Materiel> annuaireMateriel = new AnnuaireGenerique<>();
		Materiel m1 = new Materiel(1, "Ordinateur");
		Materiel m2 = new Materiel(2, "Smartphone");
		Materiel m3 = new Materiel(3, "Bureau");		
		annuaireMateriel.ajouter(m1);
		annuaireMateriel.ajouter(m2);
		annuaireMateriel.ajouter(m3);
		Materiel materiel = null;
		try {
			System.out.println("Test de recherche d'un materiel existant");
			materiel = annuaireMateriel.getParNo(2);
			
			System.out.println("Materiel trouvé : " + materiel.toString());


		
		} catch (AnnuaireException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur : " + e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
