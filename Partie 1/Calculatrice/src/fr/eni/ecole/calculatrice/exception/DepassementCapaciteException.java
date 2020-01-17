package fr.eni.ecole.calculatrice.exception;

/**
 * Classe modélisant une exception contrôlée pour le dépassement de capacité
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
		super("Le résultat dépasse la capacité de la calculatrice");
	}
	
	
	
}
