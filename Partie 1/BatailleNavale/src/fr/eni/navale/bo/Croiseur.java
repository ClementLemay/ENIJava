/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Class de Croiseur
 *
 */
public class Croiseur extends Navire {
	private static final int LONGUEUR = 4;
	
	/**
	 * @param debut
	 * @param estVertical
	 */
	public Croiseur(Coordonnee debut, boolean estVertical) {
		super(debut, LONGUEUR, estVertical);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see fr.eni.navale.bo.Navire#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %s", this.getClass().getName(), super.toString());
	}
}
