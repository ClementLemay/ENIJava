package fr.eni.annuaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Annuaire implements ModeleAnnuaire{

	private List<Employe> employes;
	
	//Constructeurs
	public Annuaire(){
		employes = new ArrayList<Employe>();
	}
	
	
	/**
	 * Description : Ajoute un employe à l'annuaire
	 * @param c
	 */
	public void ajouterEmploye(Employe employe){
		employes.add(employe);

	}
	
	/**
	 * Description : Rechere un employe dans l'annuaire par son numéro d'employé
	 *               et le retourne en résultat.
	 * @param no
	 * @return
	 * @throws AnnuaireException 
	 */
	public Employe getEmployeParNo(Integer no) throws AnnuaireException {
		
		Employe employeRecherche = null;
		for(Employe e: employes) {
			if(e.getNoEmploye()==no) {
				employeRecherche = e;
				break;
			}
		}
		
		if(employeRecherche == null) {
			throw new AnnuaireException("Employé inconnu.");
		}
		
		return employeRecherche;
	}
	
	/**
	 * Description : Affiche la liste des employés de l'annuaire sur la console
	 */
	public void afficher(){
		System.out.println(employes.toString());
	}

	public void trier(){
		Comparator<Employe> cE = new Comparator<Employe>() {
			@Override
			public int compare(Employe arg0, Employe arg1) {
				return arg0.getNoEmploye() - arg1.getNoEmploye();
			}
		};
		
		employes.sort(cE);
	}


	
}






