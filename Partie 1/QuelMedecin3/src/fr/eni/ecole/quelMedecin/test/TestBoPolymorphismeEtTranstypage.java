package fr.eni.ecole.quelMedecin.test;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.ecole.quelMedecin.bo.Adresse;
import fr.eni.ecole.quelMedecin.bo.Creneau;
import fr.eni.ecole.quelMedecin.bo.Medecin;
import fr.eni.ecole.quelMedecin.bo.MedecinGeneraliste;
import fr.eni.ecole.quelMedecin.bo.MedecinSpecialiste;
import fr.eni.ecole.quelMedecin.bo.Patient;
import fr.eni.ecole.quelMedecin.bo.Personne;
import fr.eni.ecole.quelMedecin.bo.RendezVous;

public class TestBoPolymorphismeEtTranstypage {

	private static Adresse sh = new Adresse("ZAC du Moulin Neuf", 2, "B", "rue Benjamin Franklin", 44800,
			"Saint Herblain");
	private static Adresse nio = new Adresse(19, null, "avenue LÃ©o Lagrange", 79000, "Niort");
	private static Patient adhemar = new Patient("Pamamobe", "AdhÃ©mar", "0753428619", 'M', 192112192020142l,
			LocalDate.of(1992, 11, 21), null, nio);

	public static void main(String[] args) {
		Personne[] tabPersonnes = new Personne[2];
		//transtypage ascendant d'un type MedecinGeneraliste vers un type Medecin
		tabPersonnes[0] = CreerMedecin();
		//transtypage ascendant d'un type MedecinSpecialiste vers un type Medecin
		tabPersonnes[1] = CreerSpecialistes();
		
		for(Personne m : tabPersonnes) {
			// polymorphisme : appel de la méthode afficher() la plus spécifique
			m.afficher();
			System.out.println("");
		}
		
		System.out.printf("Affichage de la spécialité de chaque médecin%n");
		for(Personne m : tabPersonnes) {
			// transtypage descendant
			// permettant de stocker l'instance dans une variable de son type d'origine
			if(m instanceof MedecinSpecialiste) {
				MedecinSpecialiste med = (MedecinSpecialiste) m;
				// sans le transtypage descendant, la méthode getSpecialite() est inaccessible
				System.out.printf("Spécialité : %s%n", med.getSpecialite());
			}
			if(m instanceof MedecinGeneraliste) {
				// sans le transtypage descendant, la méthode getSpecialite() est inaccessible
				System.out.printf("Spécialité : %s%n", "Sans spécialité");
			}
		}
		
	}

	private static MedecinGeneraliste CreerMedecin() {
		MedecinGeneraliste melanie = new MedecinGeneraliste("Malalaniche", "MÃ©lanie", "02.28.03.17.28", sh);
		System.out.println("__________________________ MÃ©decins ______________________________");
		Creneau c1 = new Creneau(LocalTime.of(9, 0), 15, melanie);
		new Creneau(LocalTime.of(9, 15), 15, melanie);
		new Creneau(LocalTime.of(9, 30), 15, melanie);
		new Creneau(LocalTime.of(9, 45), 15, melanie);
		new Creneau(LocalTime.of(10, 30), 15, melanie);
		new Creneau(LocalTime.of(10, 45), 15, melanie);
		new Creneau(LocalTime.of(11, 15), 15, melanie);
		new Creneau(LocalTime.of(11, 30), 15, melanie);
		new Creneau(LocalTime.of(11, 45), 15, melanie);
		new Creneau(LocalTime.of(14, 0), 30, melanie);
		new Creneau(LocalTime.of(14, 30), 30, melanie);
		new Creneau(LocalTime.of(15, 0), 30, melanie);
		new Creneau(LocalTime.of(15, 30), 30, melanie);
		new Creneau(LocalTime.of(16, 0), 30, melanie);
		new Creneau(LocalTime.of(16, 30), 30, melanie);
		return melanie;
	}

	private static MedecinSpecialiste CreerSpecialistes() {
		MedecinSpecialiste celine = new MedecinSpecialiste("OCENSEMAIME", "CÃ©line", "0748159263", sh, "ORL", 52);
		new Creneau(LocalTime.of(14, 0), 20, celine);
		new Creneau(LocalTime.of(14, 20), 20, celine);
		new Creneau(LocalTime.of(14, 40), 20, celine);
		new Creneau(LocalTime.of(15, 0), 20, celine);
		Creneau c = new Creneau(LocalTime.of(15, 20), 20, celine);
		new Creneau(LocalTime.of(15, 40), 20, celine);
		new Creneau(LocalTime.of(16, 0), 20, celine);
		new Creneau(LocalTime.of(16, 20), 20, celine);
		new Creneau(LocalTime.of(16, 40), 20, celine);
		new Creneau(LocalTime.of(17, 0), 20, celine);
		return celine;
	}
}
