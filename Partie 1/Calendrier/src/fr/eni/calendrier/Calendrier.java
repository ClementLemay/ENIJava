package fr.eni.calendrier;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Calendrier {

	private static Scanner s = new Scanner(System.in);

	/**
	 * Permet de parcourir un calendrier
	 * 
	 * @param args non nécessaire
	 */
	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		String saisie;
		do {
			afficherMois(date.get(GregorianCalendar.YEAR),
					date.get(GregorianCalendar.MONTH));
			System.out.println("(q) quitter   (-) mois précédent   " +
					"(+) mois suivant   (d) date personnalisée");
			saisie = s.nextLine();
			switch (saisie) {
			case "-":
				date.add(GregorianCalendar.MONTH, -1);
				break;
			case "+":
				date.add(GregorianCalendar.MONTH, 1);
				break;
			case "d":
				System.out.println("année ?");
				int annee = s.nextInt();
				s.nextLine();
				System.out.println("mois ?");
				int mois = s.nextInt();
				s.nextLine();
				date.set(annee, mois-1, 1);
				break;
			case "q": // rien du tout
				break;
			default:
				System.err.println("Saisie incorrecte");
				break;
			}
		} while(!saisie.equals("q"));
	}

	
	
	
	/**
	 * Affichage du calendrier d'un mois<br>
	 * Exemple :
	<pre>
	 * novembre 2018 *
	L  Ma Me J  V  S  D
	         01 02 03 04 
	05 06 07 08 09 10 11 
	12 13 14 15 16 17 18 
	19 20 21 22 23 24 25 
	26 27 28 29 30
	</pre>
	 * 
	 * @param annee
	 *            année du calendrier à afficher
	 * @param mois
	 *            mois du calendrier à afficher
	 */
	private static void afficherMois(int annee, int mois) {
		GregorianCalendar jour = new GregorianCalendar(annee, mois, 1);
		//affichage du mois en francais et de l'année 
		System.out.format(" * %s %d *%n",
				jour.getDisplayName(GregorianCalendar.MONTH,
						GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
						jour.get(GregorianCalendar.YEAR));
		System.out.println("L  Ma Me J  V  S  D");
		// recherche du premier jour du mois
		// dans le cas du lundi aucun décalage n'est à faire
		int decalage = 0;
		switch (jour.get(GregorianCalendar.DAY_OF_WEEK)) {
		case GregorianCalendar.TUESDAY:
			decalage = 1;
			break;
		case GregorianCalendar.WEDNESDAY:
			decalage = 2;
			break;
		case GregorianCalendar.THURSDAY:
			decalage = 3;
			break;
		case GregorianCalendar.FRIDAY:
			decalage = 4;
			break;
		case GregorianCalendar.SATURDAY:
			decalage = 5;
			break;
		case GregorianCalendar.SUNDAY:
			decalage = 6;
			break;
		}
		// réalise un décalage permettant d'afficher le jour 1 sous le bon nom de jour
		for (int i = 0; i < decalage; i++) {
			System.out.print("   ");
		}
		// récupération du nombre de jour dans le mois
		int nbJoursDansLeMois = jour.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		// boucle permettant le parcours de tous les jours du mois
		for (int i = 1; i <= nbJoursDansLeMois; i++) {
			System.out.format("%02d ", jour.get(GregorianCalendar.DAY_OF_MONTH));
			jour.add(GregorianCalendar.DAY_OF_MONTH, 1);
			// si on est en début de semaine alors on fait un saut à la ligne
			if (jour.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY)
				System.out.println();
		}
		System.out.println();
	}


}
