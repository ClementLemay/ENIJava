package fr.eni.maximot;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Maximot {
	
	public static final String FICHIER_MOTS = "./dictionnaire.txt";
	public static final int NB_MOTS = 22506;
	public static Random r = new Random();


	public static void main(String[] args) {
		try {
			char[] mot = tirerMotAleatoirement();
			char[] tirage = melanger(mot);
			System.out.println("Voici le tirage :");
			afficher(tirage);
			Scanner console = new Scanner(System.in);
			System.out.println("Quel est le mot cach� dans ce tirage ?");
			String proposition = console.nextLine().toUpperCase();
			char[] prop = proposition.toCharArray();
			if (!bonnesLettres(tirage, prop)) {
				System.out.println("Lettre incorrecte !");
			} else {
				if (!dansLeDico(prop)) {// equivalent � if (dansLeDico(prop) == false) {
					System.out.println("Mot non pr�sent dans le dico");
				} else {
					System.out.println("Bravo vous marquez " + 
prop.length + " points");
				}
			}
			afficher(mot);
			console.close();
		} catch (IOException e) {
			System.err.println("Probl�me de lecture du dictionnaire");
		}


	}
	
	private static char[] tirerMotAleatoirement() throws IOException {
		String mot = "";
		int numMot = r.nextInt(NB_MOTS);
		try(FileInputStream fichier = new FileInputStream(FICHIER_MOTS);
				Scanner s = new Scanner(fichier, "UTF-8");) {
		    for(int i = 0 ; i<numMot ; i++) {
		    	mot = s.nextLine().toUpperCase();
		    }
		    System.out.println("Fichier lu int�gralement avec succ�s");
		}
		System.out.println("mot : " + mot);
		return mot.toCharArray();
			

	}
	
	
	/*
	 * Fonction permettant le m�lange des lettres
	 * pour le mot tir� du dictionnaire 
	 */
	private static char[] melanger(char[] tabLettre) {
		int nbLettre = tabLettre.length;
		// creation d'un nouveau tableau ayant la m�me taille
		// que le tableau pass� en param�tre de la fonction
		char[] tabLettreMelange = new char[tabLettre.length];
		// parcours du tableau de lettre afin de r�aliser une copie
		// dans un autre tableau
		for(int i = 0 ; i < nbLettre ; i++) {
			tabLettreMelange[i] = tabLettre[i];
		}
		
		// tant que le m�lange n'est pas bon alors j'execute de nouveau le m�lange
		while(!verifierMelangeOk(tabLettre, tabLettreMelange)) {
			// boucle for r�alisant le m�lange des lettres
			for(int i = 0 ; i < nbLettre * 4 ; i++) {
				int numLettre1 = r.nextInt(nbLettre);
				int numLettre2 = r.nextInt(nbLettre);
				// copie dans une variable temporaire la lettre � d�placer
				char lettre = tabLettreMelange[numLettre1];
				// d�placement d'une lettre du tableau
				tabLettreMelange[numLettre1] = tabLettreMelange[numLettre2];
				// affectation de la lettre sock�e temporairement 
				// dans une case du tableau
				tabLettreMelange[numLettre2] = lettre;
			}
		}
		
		
		return tabLettreMelange;
	}

	/*
	 * fonction permettant de v�rifier que le m�lange a bien �t� effectu�
	 */
	private static boolean verifierMelangeOk(char[] tabLettre, char[] tabLettreMelange) {
		int nbLettre = tabLettre.length;
		// test que le tableau d'oigine est diff�rent du tableau m�lang�
		boolean melangeOk = false;
		for(int i = 0 ; i<nbLettre ; i++) {
			if(tabLettre[i] != tabLettreMelange[i]) {
				melangeOk = true;
				break;
			}
		}
		return melangeOk;
	}
	
	private static void afficher(char[] tabLettre) {
		for(int i = 0 ; i<tabLettre.length ; i++) {
			System.out.println(tabLettre[i]);
		}
		System.out.println();
	}
	
	/**
	 * Fonction permettant de tester que deux tableaux contiennent les m�mes lettres
	 * @param tabLettreMelange
	 * @param tabLettreSaisie
	 * @return
	 */
	private static boolean bonnesLettres(char[] tabLettreMelange, char[] tabLettreSaisie) {
		boolean isBonnesLettres = true;
		// verifier que le tableau contenant 
		// les lettres du tirage a la m�me taille que le tableau contenant 
		// les lettre saisie par l'utilisateur
		if(tabLettreMelange.length != tabLettreSaisie.length) {
			isBonnesLettres = false;
		}else {
			// cr�ation d'un tableau qui contiendra 
			// les index du tableau dont les lettres ont �t� trouv�es
			Integer[] tabIndex = new Integer[tabLettreMelange.length];
			int index = 0;
			// parcours du tableau contenant les lettres saisies par l'utilisateur
			for(int i = 0 ; i<tabLettreSaisie.length ; i++) {
				// parcours du tableau contenant les lettres du tirage
				for(int j = 0 ; j<tabLettreMelange.length ; j++) {
					// test que les lettres des deux tableaux sont identiques 
					// et que la lettre pr�sente dans l'index j du tableau n'a pas d�j� �t� utilis�e
					if(!isIndexExiste(tabIndex, j) && tabLettreSaisie[i] == tabLettreMelange[j]) {
						tabIndex[index] = j;
						index++;
						break;
					}
				}
			}
			// parcours du tableau d'index
			for(int i = 0 ; i < tabIndex.length ; i++) {
				// si le tableau d'index contient une case vide
				// cela signifie que toutes les lettres n'ont pas �t� trouv�es
				if(tabIndex[i]==null) {
					isBonnesLettres = false;
				}
			}
		}
		
		return isBonnesLettres;
	}
	
	/**
	 * Fonction qui permet de v�rifier que l'index pass� en param�tre ne fait pas partie des index d�j� trouv�s
	 * @param tabIndex
	 * @param index
	 * @return
	 */
	private static boolean isIndexExiste(Integer[]tabIndex, int index) {
		boolean existe = false;
		for(int i = 0 ; i < tabIndex.length ; i ++) {
			if(tabIndex[i]!=null && index == tabIndex[i]) {
				existe = true;
				break;
			}
		}
		return existe;
	}
	
	/**
	 * fonction de recherche d'un mot dans le dictionnaire
	 * @param tabLettreSaisie
	 * @return
	 * @throws IOException
	 */
	private static boolean dansLeDico(char[] tabLettreSaisie) throws IOException {
		boolean isDansLeDico = false;
		try(FileInputStream fichier = new FileInputStream(FICHIER_MOTS);
				Scanner s = new Scanner(fichier, "UTF-8");) {
		    while(s.hasNext() && !isDansLeDico) {
		    	char[] motDico = s.nextLine().toUpperCase().toCharArray();
		    	isDansLeDico = sontIdentiques(tabLettreSaisie, motDico);
		    }
		}
		return isDansLeDico;
	}
	
	/**
	 * fonction permettant de tester que deux tableaux contiennent les m�mes valeurs
	 * @param tabLettreSaisie
	 * @param motDico
	 * @return
	 */
	private static boolean sontIdentiques(char[] tabLettreSaisie, char[] motDico) {
		boolean ok = true;
		if(tabLettreSaisie.length != motDico.length) {
			ok = false;
		}else {
			for(int i = 0 ; i<tabLettreSaisie.length ; i++) {
				if(tabLettreSaisie[i] != motDico[i]) {
					ok = false;
					break;
				}
			}
		}
		
		return ok;
	}
	

}
