package fr.eni.ecole.jeuDeDes;

import java.util.Random;

/**
 * Cette classe mod�lise un d� � jouer
 * @author gmichaud
 *
 */
public class De {
	private int nbFaces;
	private int faceTiree;
	
	private static Random rand = new Random();
	
	
	/**
	 * constructeur qui cr�e une instance de d� 
	 * dont le nombre de faces est pass� en parametre
	 * @param nbFaces
	 * @throws Exception 
	 */
	public De(int nbFaces) throws Exception {
		super();
		// � remplacer this.nbFaces = nbFaces;
		this.setNbFaces(nbFaces);
		this.lancer();
	}
	

	/**
	 * constructeur qui cr�e une instance de d� � 6 faces
	 * @throws Exception 
	 */
	public De() throws Exception {
		this(6);
	}




	/**
	 * m�thode qui lance le d� et retourne la face qui a �t�
	 * tir�e al�atoirement
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
			throw new Exception("un d� doit avoir au minimum 2 faces");
		
	}


	public int getFaceTiree() {
		return faceTiree;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
