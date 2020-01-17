/**
 * 
 */
package fr.eni.navale.jeu;

import java.util.Scanner;

import fr.eni.navale.bo.Coordonnee;
import fr.eni.navale.bo.Navire;
import fr.eni.navale.bo.Plateau;

/**
 * Class d'exécution du jeu de la bataille navale
 *
 */
public class Jeu {

	static Scanner sc;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Version Console
		jouerEnModeConsole();
	}

	private static void jouerEnModeConsole() {
		sc = new Scanner(System.in);
		String tir;
		Plateau plateau = new Plateau();
		plateau.setModeTricheur(true);
		do {
			System.out.println(plateau.toString());
			System.out.println(plateau.voirEtatFlotte());
			System.out.print("Saisissez votre coordonnée de tir (A1 par exemple) ou EXIT pour sortir: ");
			tir = sc.nextLine();
			if (!"EXIT".equals(tir.toUpperCase()))
				System.out.println(plateau.tirer(new Coordonnee(tir)));
		} while (!plateau.gagner() && !"EXIT".equals(tir.toUpperCase()));
		if (plateau.gagner())
			System.out.println("Gagné, tous les bateaux sont coulés !");
		System.out.println("Fin de partie !");
		
		
		
	}

	
}
