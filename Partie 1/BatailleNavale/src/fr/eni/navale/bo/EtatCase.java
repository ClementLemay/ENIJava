/**
 * 
 */
package fr.eni.navale.bo;

/**
 * Enumération représentant les états des cases du plateau de jeu
 *
 */
public enum EtatCase {
	EAU,
	PLOUF,
	TOUCHE;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		String symbol;
		switch(this) {
			case EAU: 	symbol = "~";
					  	break;
			case PLOUF: symbol = "x";
						break;
			case TOUCHE: symbol = "�";
						break;
			default: symbol = "~";
		}
		return symbol;
	}
	
	
}
