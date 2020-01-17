package fr.eni.ecole.jeuDeDes;

public class TestDe {

	public static void main(String[] args) {
		try {
			De de20 = new De(1);
			// Affichage de la face tirée dans la console
			System.out.println(de20.getFaceTiree());
			do {
				de20.lancer();
				System.out.println(de20.getFaceTiree());
			}while(de20.getFaceTiree()!=6);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Fin du programme");

	}

}
