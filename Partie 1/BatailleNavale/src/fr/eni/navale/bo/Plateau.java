/**
 * 
 */
package fr.eni.navale.bo;

import java.util.Random;

/**
 * Classe représentant le plateau de jeu de la bataille navale
 *
 */

public class Plateau {
	private static final int TAILLE_PLATEAU = 10;
	private static final int NOMBRE_NAVIRE = 5;
	private EtatCase [][] grilleVisuelle;
	private Navire [] grilleBateaux; //liste des Navires placés sur la grille
	private int cptNavire; //comptabilise le nombre de bateaux placés
	private int cptCoule; //comptabilise le nombre de bateaux coulés
	
	private boolean modeTricheur = false;
	
	
	/**
	 * @param modeTricheur the modeTricheur to set
	 */
	public final void setModeTricheur(boolean modeTricheur) {
		this.modeTricheur = modeTricheur;
	}

	public Plateau() {
		grilleVisuelle = new EtatCase[TAILLE_PLATEAU][TAILLE_PLATEAU];
		grilleBateaux = new Navire[NOMBRE_NAVIRE];
		cptNavire = 0;
		
		cptCoule = 0;
		
		//initialiser le plateau de jeu avec de l'eau dans toutes les cases
		initialiser();
		
		//placer les 5 bateaux aléatoirement sur le plateau
		do {
			placer();
		}while (cptNavire < NOMBRE_NAVIRE);

		
	}
	
	/**
	 * Mettre toutes les cases du plateau à la valeur EAU
	 */
	private void initialiser() {
		for (int i=0; i < TAILLE_PLATEAU; i++) {
			 for (int j=0; j < TAILLE_PLATEAU; j++) {
				 grilleVisuelle[i][j] = EtatCase.EAU;
			 }
		}
	}
	
	/**
	 * Placer aléatoirement un bateau sur la grille
	 * @param longueur
	 */
	private void placer() {
		int x,y;
		boolean vertical;
		boolean ok = false;
		Random alea = new Random();
		do {			
			x = alea.nextInt(10); //valeur aléatoire de colonne entre 0 et 9 (inclus)
			y = alea.nextInt(10); //valeur aléatoire de ligne entre 0 et 9 (inclus)
			vertical = alea.nextInt(2) > 0 ? true : false; //valeur aléatoire entre 0 et 1 (inclus). 0 = false, 1 = true
			Coordonnee coord = new Coordonnee(x,y);
			//construire le bateau et lui associer ses coordonnées
			Navire navire=null;
			switch (cptNavire) {
			case 0 :
				navire = new PorteAvion(coord, vertical);
				break;
			case 1 :
				navire = new Croiseur(coord, vertical);
				break;
			case 2 : 
				navire = new ContreTorpilleur(coord, vertical);
				break;
			case 3 :
				navire = new SousMarin(coord, vertical);
				break;
			case 4 :
				navire = new Torpilleur(coord,vertical);
				break;
			}
			//le bateau est placé sur la grille s'il y a la place et qu'il n'en chevauche pas un autre
			if (navire != null && estLibre(navire)) {
				grilleBateaux[cptNavire] = navire;
				ok = true;
			}
		} while(!ok);
		this.cptNavire++;	
	}
	
	
	/**
	 * Vérifier que le nouveau bateau n'en chevauche pas un autre et qu'il y ait suffisamment
	 * de place horizontalement ou verticalement pour un bateau de cette longueur
	 * @param newNavire
	 * @return
	 */
	private boolean estLibre(Navire newNavire) {
		boolean possible = true;
		//Le nouveau navire va t il chevaucher un navire déjà placé ?
		for (Navire navire: grilleBateaux) {
			if (navire !=null && newNavire.chevauche(navire)) {
				possible = false;
			}
		}
		//y a t il la place verticalement pour cette longueur ?
		if (possible && newNavire.estVertical()) {
			if (newNavire.getFin().getLigne() < TAILLE_PLATEAU) {
				possible = true;
			} else possible = false;
		} else {
			//y a t il la place horizontalement pour cette longueur ?
			if (possible && !newNavire.estVertical()) {
				if (newNavire.getFin().getColonne() < TAILLE_PLATEAU) {
					possible = true;
				} else possible = false;
			}
		}
		return possible;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Afficher la grille à présenter au joueur en mode console
	 */ 
	@Override
	public String toString() {
		StringBuilder matrice = new StringBuilder(" x  A  B  C  D  E  F  G  H  I  J \n");
		for (int ligne=0; ligne < TAILLE_PLATEAU; ligne++) {
			matrice.append(String.format(" %d ", ligne));
			for (int col=0; col < TAILLE_PLATEAU; col++) {
				matrice.append(String.format(" %s ", grilleVisuelle[col][ligne].toString()));
				if (col == TAILLE_PLATEAU - 1) {
					matrice.append("\n");
				}
			}
		}
		return matrice.toString();
	}
	
	/**
	 * Afficher l'état de la flotte.
	 * @return
	 */
	public String voirEtatFlotte() {
		StringBuffer matrice = new StringBuffer();
		for (Navire navire: grilleBateaux) {
			if (modeTricheur) {
				matrice.append(String.format("[%s][%s] ", navire.getDebut().toString(),navire.getFin().toString()));
			}
			matrice.append(navire.toString());
		}
		return matrice.toString();
	}
	
	/**
	 * Chaque bateau placé sur la grille vérifie si cette coordonnée lui appartient.
	 * En fonction du résultat, mise à jour de la grille visuelle
	 * @param c
	 * @return
	 */
	public String tirer(Coordonnee c) {
		String message;
		Navire navireTouche = null;
		for(Navire navire: grilleBateaux) {
			if (navire.recoitTir(c)) {
				navireTouche = navire;
				break;
			}
		}
		if (navireTouche != null) {
			message = "Navire touché !";
			grilleVisuelle[c.getColonne()][c.getLigne()] = EtatCase.TOUCHE;
			if (navireTouche.estCoule()) {
				message = String.format("Navire coulé ! ([%s][%s])", navireTouche.getDebut().toString(), navireTouche.getFin().toString());
				cptCoule++;
			}
		} else {
				message = "Tir à l'eau !";
				grilleVisuelle[c.getColonne()][c.getLigne()] = EtatCase.PLOUF;
		}
		
		return message;
	}
	
	/**
	 * déterminer si le joueur à gagner
	 * @return
	 */
	public boolean gagner() {
		return cptCoule == cptNavire;
	}
	
	
	
}

	
