/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Class de Navire
 *
 */
public abstract class Navire {
	private Coordonnee debut; //coordonnee haut et top
	private Coordonnee fin; //coordonnee right et bottom
	private Coordonnee[] impacts; //liste des impacts sur le navire
	private int nbImpacts; //nombre d'impacts sur le navire
	
	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;
		//calculer la coordonnée de fin du navire en fonction de son positionnement (horizontal ou vertical)
		if (estVertical) {
			this.fin = new Coordonnee(this.debut.getColonne(), this.debut.getLigne() + (longueur - 1));
		} else {
			this.fin = new Coordonnee(this.debut.getColonne() + (longueur - 1), this.debut.getLigne());
		}
		
		impacts = new Coordonnee[longueur]; 
		nbImpacts = 0;
	}
	
	/**
	 * @return the debut
	 */
	public final Coordonnee getDebut() {
		return debut;
	}

	/**
	 * @return the fin
	 */
	public final Coordonnee getFin() {
		return fin;
	}


	/**
	 * Détermine si la coordonnée passée est associée à un navire
	 * @param c
	 * @return
	 */
	private boolean contient(Coordonnee c) {
		return (c.getColonne() >= debut.getColonne() 
				&& c.getColonne() <= fin.getColonne()
				&& c.getLigne() >= debut.getLigne() 
				&& c.getLigne() <= fin.getLigne());
	}
	
	
	/**
	 * Affirme si un navire en chevauche un autre
	 * @param n
	 * @return
	 */
	public boolean chevauche(Navire n) {

		return (this.debut.getColonne() >= n.debut.getColonne() && this.debut.getColonne() <= n.fin.getColonne()
					&& n.debut.getLigne() >= this.debut.getLigne() && n.debut.getLigne() <= this.fin.getLigne())
				||
				(n.debut.getColonne() >= this.debut.getColonne() && n.debut.getColonne() <= this.fin.getColonne()
					&& this.debut.getLigne() >= n.debut.getLigne() && this.debut.getLigne() <= n.fin.getLigne());
	}

		
	/**
	 * Détermine si le tir de coordonnée c touche le navire. 
	 * Si c'est le cas mettre à jour le tableau des impacts.
	 * @param c
	 * @return
	 */
	public boolean recoitTir(Coordonnee c) {
		boolean touche = false;
		if (this.contient(c)) {
			impacts[nbImpacts] = c;
			nbImpacts++;
			touche = true;
		}
		return touche;
	}
	
	/**
	 * Indique si le navire a été touché au moins une fois
	 * @return
	 */
	public boolean estTouche() {
		return nbImpacts > 0;
	}
	
	public boolean estCoule() {
		return impacts.length == nbImpacts;
	}
	
	public boolean estVertical() {
		return this.debut.getColonne() == this.fin.getColonne();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Redéfinition de la méthode toString()
	 */
	@Override
	public String toString() {
		return String.format("[%s] [%s] \n", this.estTouche() ? "touché" : null, this.estCoule() ? "coulé" : null);
	}
	
	
	
}
