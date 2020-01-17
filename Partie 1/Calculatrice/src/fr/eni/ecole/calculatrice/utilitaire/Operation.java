package fr.eni.ecole.calculatrice.utilitaire;

import fr.eni.ecole.calculatrice.exception.DepassementCapaciteException;

/**
 * Classe utilitaire proposant les op�rations d'ajout, de soustraction et de
 * multiplication en v�rifiant qu'il n'y ait pas de d�passement de capacit�
 */
public class Operation {
	
	/**
	 * Calcul la somme des valeurs pass�es en param�tre
	 * 
	 * @param a la premi�re valeur � ajouter
	 * @param b la seconde valeur � ajouter
	 * @return la somme des valeurs pass�es en param�tre
	 * @throws DepassementCapaciteException
	 *             si le r�sultat du calcul d�passe la capacit� du type int
	 */
	public static int ajouter(int val1, int val2) throws DepassementCapaciteException {
		long resultatLong = (long) val1 + val2;
		int resultatInt = val1 + val2;
		if(resultatLong != resultatInt) {
			throw new DepassementCapaciteException();
		}
		
		return resultatInt;
	}
	
	/**
	 * Calcul la diff�rnce des valeurs pass�es en param�tre
	 * @param a la premi�re valeur
	 * @param b la valeur � soustraire
	 * @return la diff�rnce des valeurs pass�es en param�tre
	 * @throws DepassementCapaciteException
	 *             si le r�sultat du calcul d�passe la capacit� du type int
	 */
	public static int soustraire(int val1, int val2) throws DepassementCapaciteException {
		long resultatLong = (long) val1 - val2;
		int resultatInt = val1 - val2;
		if(resultatLong != resultatInt) {
			throw new DepassementCapaciteException();
		}
		
		return resultatInt;
	}
	
	/**
	 * Calcul le produit des valeurs pass�es en param�tre
	 * @param a la premi�re valeur
	 * @param b la seconde valeur
	 * @return le produit des valeurs pass�es en param�tre
	 * @throws DepassementCapaciteException
	 *             si le r�sultat du calcul d�passe la capacit� du type int
	 */
	public static int multiplier(int val1, int val2) throws DepassementCapaciteException {
		long resultatLong = (long) val1 * val2;
		int resultatInt = val1 * val2;
		if(resultatLong != resultatInt) {
			throw new DepassementCapaciteException();
		}
		
		return resultatInt;
	}
	
}
