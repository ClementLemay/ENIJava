package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

/**
 * Classe mod�lisant un m�decin 
 */
public class Medecin extends Personne {

	public static final int MAX_CRENEAUX = 15;
	protected Creneau[] creneaux = new Creneau[MAX_CRENEAUX];
	private int index = 0;
	
	/**
	 * Constructeur : cr�e une instance de Medecin
	 * 
	 * @param nom
	 *            nom du m�decin
	 * @param prenom
	 *            pr�nom du m�decin
	 * @param numeroDeTelephone
	 *            num�ro de t�l�phone
	 * @param adresse
	 *            adresse postale du patient
	 */
	public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	

	void ajouterCreneau(Creneau c) {
		if(this!=c.getMedecin()) {
			System.err.println("Ce cr�neau ne peut �tre associ� � ce m�decin car il est d�j� associ� � un autre");
		}else {
			if(index < MAX_CRENEAUX) {
				this.creneaux[index] = c;
				index++;
			}else {
				System.err.println("Trop de cr�neaux sont affect�s � ce m�decin");
			}
		}
	}
	
	/**
	 * Affiche sur la console sous la forme : NOM Pr�nom T�l�phone : XXXXXXXXXX
	 * Adresse :
	 * Compl�ment
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 * Cr�neaux :
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 */
	public void afficherAdresseEtCreneaux() {
		if(this.adresse!=null) {
			System.out.println("Adresse : ");
			this.adresse.afficher();
			System.out.println("");
		}
		System.out.println("Cr�neaux : ");
		for(Creneau c : creneaux) {
			if(c != null) {
				LocalTime dateFin = c.getDateDebut().plusMinutes(c.getDuree());
				System.out.printf("%02d:%02d - %02d:%02d (%02d minutes)\n", c.getDateDebut().getHour(), c.getDateDebut().getMinute(), dateFin.getHour(), dateFin.getMinute(), c.getDuree());
			}
			
		}
	}
}
