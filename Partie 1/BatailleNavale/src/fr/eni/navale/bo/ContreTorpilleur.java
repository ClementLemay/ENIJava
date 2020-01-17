/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Class de ContreTorpilleur
 *
 */
public class ContreTorpilleur extends Navire {
	private static final int LONGUEUR = 3;
	
	/**
	 * @param debut
	 * @param estVertical
	 */
	public ContreTorpilleur(Coordonnee debut, boolean estVertical) {
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
