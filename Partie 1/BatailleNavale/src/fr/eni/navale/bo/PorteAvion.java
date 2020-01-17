/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Class de porte avion
 *
 */
public class PorteAvion extends Navire {
	private static final int LONGUEUR = 5;

	/**
	 * @param debut
	 * @param estVertical
	 */
	public PorteAvion(Coordonnee debut, boolean estVertical) {
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
