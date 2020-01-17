package fr.eni.ecole.quelMedecin.bo;

public class Adresse {
	private String mentionComplementaire;
	private int numVoie;
	private String complementNumero; 
	private String rue;
	private int codePostal;
	private String commune;
	
	public Adresse(String mentionComplementaire, int numVoie, String complementNumero, String rue, int codePostal,
			String commune) {
		super();
		this.mentionComplementaire = mentionComplementaire;
		this.numVoie = numVoie;
		this.complementNumero = complementNumero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.commune = commune;
	}
	public Adresse(int numVoie, String complementNumero, String rue, int codePostal, String commune) {
		this(null, numVoie, complementNumero, rue, codePostal, commune);
	}


	public void afficher() {
		if (this.mentionComplementaire != null) {
			System.out.println(mentionComplementaire);
		}
		System.out.printf(
				"%d%s %s\n%05d %s",
				numVoie, complementNumero!=null ? complementNumero : "", rue, codePostal, commune.toUpperCase());
	}
	
	
	
	

}
