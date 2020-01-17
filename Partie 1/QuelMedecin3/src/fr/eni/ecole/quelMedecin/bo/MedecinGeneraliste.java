package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe modélisant un médecin généraliste
 */
public class MedecinGeneraliste extends Medecin {
	private static int tarif = 25;
	
	
	/**
	 * Constructeur : crée une instance de Medecin
	 * @param nom
	 *            nom du médecin
	 * @param prenom
	 *            prénom du médecin
	 * @param numeroDeTelephone
	 *            numéro de téléphone
	 * @param adresse
	 *            adresse postale du patient
	 */
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	public static int getTarif() {
		return tarif;
	}

	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}

	
	/**
	 * Affiche sur la console sous la forme : NOM Prénom Téléphone : XXXXXXXXXX
	 * Tarif : XX€ Adresse : Complément XXbis rue XXXXXXXXX 00000 XXXXXXXXXXXXX
	 */
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Tarif : " + tarif + "€");
		super.afficherAdresseEtCreneaux();
	}
	
	
	
	

}
