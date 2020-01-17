package fr.eni.ecole.calculatrice.exception;

/**
 * Classe mod�lisant une exception contr�l�e pour le d�passement de capacit�
 *
 */
public class DepassementCapaciteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 663246924871534044L;

	/**
	 * Constructeur
	 */
	public DepassementCapaciteException() {
		super("Le r�sultat d�passe la capacit� de la calculatrice");
	}
	
	
	
}
