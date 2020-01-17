package fr.eni.ecole.jeuDeDes;

import java.util.Random;

/**
 * Cette classe modélise un dé à jouer
 * @author gmichaud
 *
 */
public class De {
	private int nbFaces;
	private int faceTiree;
	
	private static Random rand = new Random();
	
	
	/**
	 * constructeur qui crée une instance de dé 
	 * dont le nombre de faces est passé en parametre
	 * @param nbFaces
	 * @throws Exception 
	 */
	public De(int nbFaces) throws Exception {
		super();
		// à remplacer this.nbFaces = nbFaces;
		this.setNbFaces(nbFaces);
		this.lancer();
	}
	

	/**
	 * constructeur qui crée une instance de dé à 6 faces
	 * @throws Exception 
	 */
	public De() throws Exception {
		this(6);
	}




	/**
	 * méthode qui lance le dé et retourne la face qui a été
	 * tirée aléatoirement
	 * @return faceTiree
	 */
	public int lancer() {
		this.faceTiree = De.rand.nextInt(this.nbFaces) + 1;
		return this.faceTiree;
	}


	public int getNbFaces() {
		return nbFaces;
	}


	public void setNbFaces(int nbFaces) throws Exception {
		De.verifNbFaces(nbFaces);
		this.nbFaces = nbFaces;
	}


	private static void verifNbFaces(int nbFaces) throws Exception {
		if(nbFaces<=1)
			throw new Exception("un dé doit avoir au minimum 2 faces");
		
	}


	public int getFaceTiree() {
		return faceTiree;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
