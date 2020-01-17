package fr.eni.ecole.location;

import java.time.LocalDate;

/**
 * Classe modélisant des cycles avec un motorisation électrique
 */
public abstract class CycleElectrique extends Cycle {

	private int autonomieKm;

	/**
	 * Constructeur de CycleElectrique
	 * @param dateAchat date d'achat du cycle
	 * @param marque marque du cycle
	 * @param modele modèle du cycle
	 * @param autonomieKm autonomie du moteur en kilomètres
	 */
	public CycleElectrique(LocalDate dateAchat, String marque, String modele, int autonomieKm) {
		super(dateAchat, marque, modele);
		this.autonomieKm = autonomieKm;
	}

	/** 
	 * {@inheritDoc}
	 * @see fr.eni.ecole.location.Cycle#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s %d km d'autonomie", super.toString(), this.autonomieKm);
	}
}
