package fr.eni.ecole.quelMedecin.bo;

/**
 * Classe mod�lisant un m�decin g�n�raliste
 */
public class MedecinGeneraliste extends Medecin {
	private static int tarif = 25;
	
	
	/**
	 * Constructeur : cr�e une instance de Medecin
	 * @param nom
	 *            nom du m�decin
	 * @param prenom
	 *            pr�nom du m�decin
	 * @param numeroDeTelephone
	 *            num�ro de t�l�phone
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
	 * Affiche sur la console sous la forme : NOM Pr�nom T�l�phone : XXXXXXXXXX
	 * Tarif : XX� Adresse : Compl�ment XXbis rue XXXXXXXXX 00000 XXXXXXXXXXXXX
	 */
	@Override
	public void afficher() {
		super.afficher();
		System.out.println("Tarif : " + tarif + "�");
		super.afficherAdresseEtCreneaux();
	}
	
	
	
	

}
