package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe mod�lisant un patient
 * 
 */
public class Patient extends Personne {
	
	private char sexe;
	private Long numeroSecuriteSociale;
	private LocalDate dateDeNaissance;
	private String commentaires;

	
	
	/**
	 * Constructeur
	 * 
	 * @param nom
	 *            nom du patient
	 * @param prenom
	 *            pr�nom du patient
	 * @param numeroDeTelephone
	 *            num�ro de t�l�phone du patient
	 * @param sexe
	 *            sexe du patient : 'F' pour F�minin ou 'M' pour Masculin
	 * @param numeroSecuriteSociale
	 *            num�ro de s�curit� sociale du patient
	 * @param dateDeNaissance
	 *            date de naissance du patient
	 * @param commentaires
	 *            commentaires associ� � ce patient (allergie, ant�c�dents
	 *            m�dicaux�)
	 * @param adresse
	 *            adresse postale du patient
	 */
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, Long numeroSecuriteSociale,
			LocalDate dateDeNaissance, String commentaires, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.sexe = sexe;
		this.numeroSecuriteSociale = numeroSecuriteSociale;
		this.dateDeNaissance = dateDeNaissance;
		this.commentaires = commentaires;
	}

	/**
	 * Affiche sur la console sous la forme :
	 * NOM Pr�nom
	 * T�l�phone : XXXXXXXXXX
	 * Sexe : F�minin ou Masculin
	 * Num�ro de S�curit� sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	public void afficher() {
		super.afficher();
		System.out.println(String.format(
				"Sexe : %s\nNum�ro de S�curit� Sociale : %s\nDate de naissance : %s\nCommentaires : %s",
				sexe=='F' ? "F�minin" : "Masculin", numeroSecuriteSociale, dateDeNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), commentaires==null ? "[aucun commentaire]" : commentaires));
		if(this.adresse!=null) {
			System.out.println("Adresse : ");
			this.adresse.afficher();
			System.out.println("");
		}
	}
	

}
