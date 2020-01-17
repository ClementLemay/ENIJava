package fr.eni.ecole.location;

import java.time.LocalDate;

/**
 * Classe modélisant un vélo
 *
 */
public class Velo extends Cycle {

	private int nbVitesses;

	/**
	 * Constructeur de vélo
	 * @param dateAchat date d'achat du vélo
	 * @param marque marque du vélo
	 * @param modele modèle du vélo
	 * @param nbVitesses nombre de vitesses du vélo
	 */
	public Velo(LocalDate dateAchat, String marque, String modele, int nbVitesses) {
		super(dateAchat, marque, modele);
		this.nbVitesses = nbVitesses;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni.ecole.location.Cycle#getTarifLocationHeure()
	 */
	@Override
	public double getTarifLocationHeure() {
		return 4.9;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni.ecole.location.Cycle#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %d vitesse%s", super.toString(), this.nbVitesses, this.nbVitesses > 1?"s":"");
	}
}
