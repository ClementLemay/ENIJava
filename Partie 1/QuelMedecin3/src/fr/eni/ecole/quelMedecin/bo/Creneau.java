package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Creneau {

	private LocalTime dateDebut;
	private int duree;
	private Medecin medecin;
	
	
	public Creneau(LocalTime dateDebut, int duree, Medecin medecin) {
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.medecin = medecin;
		this.medecin.ajouterCreneau(this);
	}
	
	public LocalTime getDateDebut() {
		return dateDebut;
	}

	public int getDuree() {
		return duree;
	}
	
	public Medecin getMedecin() {
		return medecin;
	}

	public void afficher() {
		LocalTime dateFin = dateDebut.plusMinutes(duree);
		System.out.printf("%s - %s (%02d minutes)%n", dateDebut.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)), dateFin.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)), duree);
	}
	
	
}
