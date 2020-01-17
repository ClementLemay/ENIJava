/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Class de Coordonnee
 *
 */
public class Coordonnee {
	private int ligne;
	private int colonne;
	
	private static final char caractereDepart = 'A'; //valeur numérique associée = 65
	
	/**
	 * Constructeur
	 * @param coordonnees : A1, B6
	 */
	public Coordonnee(String coordonnees) {
		//récupérer la première coordonnée  au format A1, B6, ...
		
		//on convertit le caractère en valeur numérique (par exemple B - A = 1)
		colonne = coordonnees.charAt(0) - caractereDepart;
		//on recupère le second caractère au format numérique
		ligne = Integer.parseInt(coordonnees.substring(1, 2));
	}
	
	public Coordonnee(int colonne, int ligne) {
		this.colonne = colonne;
		this.ligne = ligne;
	}

	/**
	 * @return the ligne
	 */
	public final int getLigne() {
		return ligne;
	}

	/**
	 * @return the colonne
	 */
	public final int getColonne() {
		return colonne;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Retourne les coordonnées au format A1, B6
	 */
	@Override
	public String toString() {	
		return (char)(caractereDepart + colonne) + String.valueOf(ligne);
	}


	/**
	 * Comparer l'egalité entre 2 coordonnées
	 * @param obj
	 * @return
	 */
	public boolean equals(Coordonnee obj) {
		return (obj.colonne == this.colonne && obj.ligne == this.ligne);
	}
}
