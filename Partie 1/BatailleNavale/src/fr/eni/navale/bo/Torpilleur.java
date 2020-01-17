/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Class de torpilleur
 *
 */
public class Torpilleur extends Navire {

	private static final int LONGUEUR = 2;
	
	/**
	 * @param debut
	 * @param estVertical
	 */
	public Torpilleur(Coordonnee debut, boolean estVertical) {
		super(debut, LONGUEUR, estVertical);
	}

	/* (non-Javadoc)
	 * @see fr.eni.navale.bo.Navire#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %s", this.getClass().getName(), super.toString());
	}
}
