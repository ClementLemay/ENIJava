package fr.eni.annuaire;

//Design Pattern : Factory = Usine à instance
public class AnnuaireFactory {

	public static ModeleAnnuaire creerAnnuaire(){
		 
		
		return new Annuaire();
		
	}
	
	
}
