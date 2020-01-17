package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe mod�lisant une personne Cette classe regroupe les �l�ments communs �
 * toutes les personnes qu'elles soient m�decin ou patient
 * 
 */
public class Personne {

	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	protected Adresse adresse;
	
	/**
	 * Constructeur
	 * @param nom
	 *            nom de la personne
	 * @param prenom
	 *            pr�nom de la personne
	 * @param numeroDeTelephone
	 *            num�ro de t�l�phone de la personne
	 * @param adresse
	 *            adresse de la personne
	 */
	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.adresse = adresse;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}
	
	public void afficher() {
		System.out.println(nom.toUpperCase() + " " + prenom);
		System.out.println("Telephone : " + numeroDeTelephone.replaceAll("-", "."));
		
	}
	
}
