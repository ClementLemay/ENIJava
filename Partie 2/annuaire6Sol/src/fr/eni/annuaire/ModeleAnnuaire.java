package fr.eni.annuaire;

public interface ModeleAnnuaire {

	void ajouterEmploye(Employe c);
	
	Employe getEmployeParNo(Integer no) throws AnnuaireException;
	
	
	void afficher();
}
