package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Classe modélisant un patient
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
	 *            prénom du patient
	 * @param numeroDeTelephone
	 *            numéro de téléphone du patient
	 * @param sexe
	 *            sexe du patient : 'F' pour Féminin ou 'M' pour Masculin
	 * @param numeroSecuriteSociale
	 *            numéro de sécurité sociale du patient
	 * @param dateDeNaissance
	 *            date de naissance du patient
	 * @param commentaires
	 *            commentaires associé à ce patient (allergie, antécédents
	 *            médicaux…)
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
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Sexe : Féminin ou Masculin
	 * Numéro de Sécurité sociale XXXXXXXXXXXXXXX
	 * Date de naissance : XX mois XXXX
	 * Commentaires : XXXXXXXXXXXXXXX ou [aucun commentaire]
	 */
	public void afficher() {
		super.afficher();
		System.out.println(String.format(
				"Sexe : %s\nNuméro de Sécurité Sociale : %s\nDate de naissance : %s\nCommentaires : %s",
				sexe=='F' ? "Féminin" : "Masculin", numeroSecuriteSociale, dateDeNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)), commentaires==null ? "[aucun commentaire]" : commentaires));
		if(this.adresse!=null) {
			System.out.println("Adresse : ");
			this.adresse.afficher();
			System.out.println("");
		}
	}
	

}
