package fr.eni.ecole.calculatrice.test;

import java.util.Scanner;

import fr.eni.ecole.calculatrice.exception.DepassementCapaciteException;
import fr.eni.ecole.calculatrice.utilitaire.Operation;

public class Calculatrice {

	private static Scanner s = new Scanner(System.in);

	/**
	 * Classe permettant d'utiliser une petite calculatrice basique 
	 *
	 */
	public static void main(String[] args) {
		int valeur = saisirEntier();
		String message = "" + valeur;
		char operateur;
		do {
			System.out.println(message);
			System.out.println("opérateur ? (+ - * / % ou q pour quitter)");
			operateur = s.nextLine().charAt(0);
			if (operateur != 'q') {
				int v = saisirEntier();
				try {
					switch (operateur) {
					case '+':
						message = valeur + " + " + v + " = ";
						valeur = Operation.ajouter(valeur, v);
						message += valeur;
						break;
					case '-':
						message = valeur + " - " + v + " = ";
						valeur = Operation.soustraire(valeur, v);
						message += valeur;
						break;
					case '*':
						message = valeur + " * " + v + " = ";
						valeur = Operation.multiplier(valeur, v);
						message += valeur;
						break;
					case '/':
						message = valeur + " / " + v + " = ";
						valeur = valeur / v;
						message += valeur;
						break;
					case '%':
						message = valeur + " % " + v + " = ";
						valeur = valeur % v;
						message += valeur;
						break;
					case 'c':
					case 'C':
						valeur = v;
						message = "" + v;
						break;
					}
				} catch (ArithmeticException e) {
					System.err.println(
"La division par zéro n'est pas définie !");
					message = "" + valeur;
				} catch (DepassementCapaciteException e) {
					System.err.println(e.getMessage());
					message = "" + valeur;
				}
			}
		} while (operateur != 'q');
		s.close();
	}

	private static int saisirEntier() {
		boolean saisieOk = false;
		int i = 0;
		String val = null;
		while (!saisieOk) {
			try {
				System.out.println("Saisir un nombre entier : ");
				val = s.nextLine();
				i = Integer.parseInt(val);
				saisieOk = true;
			} catch (NumberFormatException e) {
				try {
					Long.parseLong(val);
					System.err.println("La valeur saisie dépasse les " +
"capacités de cette calculatrice. Réessayez...");
				} catch(NumberFormatException f) {
					System.err.println("Saisie incorrecte. Réessayez...");
				}
			}
			
			 

		}
		return i;
	}



}
