/**
 * 
 */
package fr.eni.navale.test;

import fr.eni.navale.bo.ContreTorpilleur;
import fr.eni.navale.bo.Coordonnee;
import fr.eni.navale.bo.Etat;
import fr.eni.navale.bo.Navire;
import fr.eni.navale.bo.PorteAvion;
import fr.eni.navale.bo.SousMarin;
import fr.eni.navale.bo.Torpilleur;

/**
 * Class de test
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Etat EAU = new Etat("~");
		Etat PLOUF = new Etat("x");
		Etat TOUCHE = new Etat("�");
		
		
		Etat INUTIL = new Etat("?");
		
		
		Coordonnee c1 = new Coordonnee("C5");
		System.out.println("coordonnée c1 : " + c1);
		System.out.println("coordonnée c1 = c2 " + c1.equals(new  Coordonnee("C5")));
		//Navire navire1 = new Navire(new Coordonnee("B1"),3,false);
		Navire navire1 = new SousMarin(new Coordonnee("B1"),false);
		System.out.println("Navire 1 début : " + navire1.getDebut());
		System.out.println("Navire 1 fin : " + navire1.getFin());
		System.out.println("Navire 1 vertical : " + navire1.estVertical());
		//Navire navire2 = new Navire(new Coordonnee("D6"),5,false);
		Navire navire2 = new PorteAvion(new Coordonnee("D6"),false);
		System.out.println("Navire 2 début : " + navire2.getDebut());
		System.out.println("Navire 2 fin : " + navire2.getFin());
		System.out.println("Navire 2 vertical : " + navire2.estVertical());
		//Navire navire3 = new Navire(new Coordonnee("E3"),5,true);
		Navire navire3 = new PorteAvion(new Coordonnee("E3"),true);
		System.out.println("Navire 3 début : " + navire3.getDebut());
		System.out.println("Navire 3 fin : " + navire3.getFin());
		System.out.println("Navire 3 vertical : " + navire3.estVertical());
		//Navire navire4 = new Navire(new Coordonnee("C9"),3,false);
		Navire navire4 = new ContreTorpilleur(new Coordonnee("C9"),false);
		System.out.println("Navire 4 début : " + navire4.getDebut());
		System.out.println("Navire 4 fin : " + navire4.getFin());
		System.out.println("Navire 4 vertical : " + navire4.estVertical());
		//Navire navire5 = new Navire(new Coordonnee("E9"),2,false);
		Navire navire5 = new Torpilleur(new Coordonnee("E9"),false);
		System.out.println("Navire 5 début : " + navire5.getDebut());
		System.out.println("Navire 5 fin : " + navire5.getFin());
		System.out.println("Navire 5 vertical : " + navire5.estVertical());
		//Navire navire6 = new Navire(new Coordonnee("I0"),3,true);
		Navire navire6 = new SousMarin(new Coordonnee("I0"),true);
		System.out.println("Navire 6 début : " + navire6.getDebut());
		System.out.println("Navire 6 fin : " + navire6.getFin());
		System.out.println("Navire 6 vertical : " + navire6.estVertical());
		//Navire navire7 = new Navire(new Coordonnee("I2"),2,true);
		Navire navire7 = new Torpilleur(new Coordonnee("I2"),true);
		System.out.println("Navire 7 début : " + navire7.getDebut());
		System.out.println("Navire 7 fin : " + navire7.getFin());
		System.out.println("Navire 7 vertical : " + navire7.estVertical());
		
		boolean n1Chevauchen2 = navire1.chevauche(navire2);
		boolean n2Chevauchen1 = navire2.chevauche(navire1);
		//test du chevauchement croisé
		boolean n2Chevauchen3 = navire2.chevauche(navire3);
		boolean n3Chevauchen2 = navire3.chevauche(navire2);
		//test du chevauchement horizontal
		boolean n4Chevauchen5 = navire4.chevauche(navire5);
		boolean n5Chevauchen4 = navire5.chevauche(navire4);
		//test du chevauchement vertical
		boolean n6Chevauchen7 = navire6.chevauche(navire7);
		boolean n7Chevauchen6 = navire7.chevauche(navire6);
		System.out.println("Pas de chevauchement");
		System.out.println("Navires 1 et 2 se chevauchent ?" + n1Chevauchen2);
		System.out.println("Navires 2 et 1 se chevauchent ?" + n2Chevauchen1);
		System.out.println("chevauchement croisé");
		System.out.println("Navires 2 et 3 se chevauchent ?" + n2Chevauchen3);
		System.out.println("Navires 3 et 2 se chevauchent ?" + n3Chevauchen2);
		System.out.println("chevauchement horizontal");
		System.out.println("Navires 4 et 5 se chevauchent ?" + n4Chevauchen5);
		System.out.println("Navires 5 et 4 se chevauchent ?" + n5Chevauchen4);
		System.out.println("chevauchement vertical");
		System.out.println("Navires 6 et 7 se chevauchent ?" + n6Chevauchen7);
		System.out.println("Navires 7 et 6 se chevauchent ?" + n7Chevauchen6);
	}

}
