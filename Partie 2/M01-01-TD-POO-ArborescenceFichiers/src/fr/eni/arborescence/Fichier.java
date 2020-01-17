package fr.eni.arborescence;

public class Fichier extends Element{

	public Fichier(String nom){
		super(nom);
	}
	

	@Override
	public void recherche(String nomRecherche) {
		if( this.nom.equals(nomRecherche)){
			System.out.println( " trouvé : " + chemin +  nomRecherche);
		}
		
	}



}
