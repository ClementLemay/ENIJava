package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

/**
 * Classe modélisant un médecin 
 */
public class Medecin extends Personne {

	public static final int MAX_CRENEAUX = 15;
	protected Creneau[] creneaux = new Creneau[MAX_CRENEAUX];
	private int index = 0;
	
	/**
	 * Constructeur : crée une instance de Medecin
	 * 
	 * @param nom
	 *            nom du médecin
	 * @param prenom
	 *            prénom du médecin
	 * @param numeroDeTelephone
	 *            numéro de téléphone
	 * @param adresse
	 *            adresse postale du patient
	 */
	public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}

	

	void ajouterCreneau(Creneau c) {
		if(this!=c.getMedecin()) {
			System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre");
		}else {
			if(index < MAX_CRENEAUX) {
				this.creneaux[index] = c;
				index++;
			}else {
				System.err.println("Trop de créneaux sont affectés à ce médecin");
			}
		}
	}
	
	/**
	 * Affiche sur la console sous la forme : NOM Prénom Téléphone : XXXXXXXXXX
	 * Adresse :
	 * Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 * Créneaux :
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
		System.out.println("Créneaux : ");
		for(Creneau c : creneaux) {
			if(c != null) {
				LocalTime dateFin = c.getDateDebut().plusMinutes(c.getDuree());
				System.out.printf("%02d:%02d - %02d:%02d (%02d minutes)\n", c.getDateDebut().getHour(), c.getDateDebut().getMinute(), dateFin.getHour(), dateFin.getMinute(), c.getDuree());
			}
			
		}
	}
}
