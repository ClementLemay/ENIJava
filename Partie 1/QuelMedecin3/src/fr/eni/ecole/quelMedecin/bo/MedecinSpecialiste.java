package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe mod�lisant un m�decin sp�cialiste 
 *
 */
public class MedecinSpecialiste extends Medecin {
	
	private int tarif;
	private String specialite;

	/**
	 * Constructeur
	 * @param nom nom du m�decin
	 * @param prenom prenom du m�decin
	 * @param numeroDeTelephone num�ro de t�l�phone du m�decin
	 * @param adresse adresse postale du m�decin
	 * @param specialite nom de la s�pcialit� du m�decin
	 * @param tarif tarif pratiqu� par ce m�decin pour une consultationS
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
		System.out.println("Sp�cialit� : " + specialite);
		System.out.println("Tarif : " + tarif + "�");
		super.afficherAdresseEtCreneaux();
	}
	
	

}
