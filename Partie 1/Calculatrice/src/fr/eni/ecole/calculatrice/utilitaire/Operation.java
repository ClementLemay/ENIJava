package fr.eni.ecole.calculatrice.utilitaire;

import fr.eni.ecole.calculatrice.exception.DepassementCapaciteException;

/**
 * Classe utilitaire proposant les opérations d'ajout, de soustraction et de
 * multiplication en vérifiant qu'il n'y ait pas de dépassement de capacité
 */
public class Operation {
	
	/**
	 * Calcul la somme des valeurs passées en paramètre
	 * 
	 * @param a la première valeur à ajouter
	 * @param b la seconde valeur à ajouter
	 * @return la somme des valeurs passées en paramètre
	 * @throws DepassementCapaciteException
	 *             si le résultat du calcul dépasse la capacité du type int
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
	 * Calcul la différnce des valeurs passées en paramètre
	 * @param a la première valeur
	 * @param b la valeur à soustraire
	 * @return la différnce des valeurs passées en paramètre
	 * @throws DepassementCapaciteException
	 *             si le résultat du calcul dépasse la capacité du type int
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
	 * Calcul le produit des valeurs passées en paramètre
	 * @param a la première valeur
	 * @param b la seconde valeur
	 * @return le produit des valeurs passées en paramètre
	 * @throws DepassementCapaciteException
	 *             si le résultat du calcul dépasse la capacité du type int
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
