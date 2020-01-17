package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant un médecin spécialiste 
 *
 */
public class MedecinSpecialiste extends Medecin {
	
	private int tarif;
	private String specialite;

	/**
	 * Constructeur
	 * @param nom nom du médecin
	 * @param prenom prenom du médecin
	 * @param numeroDeTelephone numéro de téléphone du médecin
	 * @param adresse adresse postale du médecin
	 * @param specialite nom de la sépcialité du médecin
	 * @param tarif tarif pratiqué par ce médecin pour une consultationS
	 */
	public MedecinSpecialiste(String nom, String prenom, String numeroDeTelephone, Adresse adresse, String specialite, int tarif) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.tarif = tarif;
		this.specialite = specialite;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Spécialité : " + specialite);
		System.out.println("Tarif : " + tarif + "€");
		super.afficherAdresseEtCreneaux();
	}
	
	

}
