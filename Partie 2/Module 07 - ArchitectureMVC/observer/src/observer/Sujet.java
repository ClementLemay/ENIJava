package observer;

import java.util.ArrayList;
import java.util.List;

public class Sujet {
	
	private List<Observateur> listeObservateurs;
	
	public Sujet() {
		listeObservateurs = new ArrayList<>();
	}
	
	/*
	 * Description : Cette méthode correspond à l'émission d'un événement  
	 */
	public void evenement(){
		System.out.println("Emission evenement...");
		notifier();
	}

	public void inscrireObservateur(Observateur obsA) {
		listeObservateurs.add(obsA);
	}
	
	private void notifier() {
		for(Observateur obs: listeObservateurs) {
			obs.traiterEvenement();
		}
	}

}
