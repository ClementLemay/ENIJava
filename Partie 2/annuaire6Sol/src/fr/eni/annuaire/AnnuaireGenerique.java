package fr.eni.annuaire;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnnuaireGenerique<T extends Numerotable> {
	
	private List<T> annuaire ;
	
	public AnnuaireGenerique()
	{
		annuaire = new ArrayList<T>();
	}
	
	public void trier()
	{
		Comparator<T> cE = new Comparator<T>() {
			@Override
			public int compare(T arg0, T arg1) {
				return arg0.getNo() - arg1.getNo();
			}
		};
		
		annuaire.sort(cE);
	}
	
	public void ajouter(T c)
	{
		annuaire.add(c);
	}
	
	public T getParNo(Integer no) throws AnnuaireException 
	{
		T aRetourner = null;
		
		for(T e : annuaire)
		{
			if(e.getNo() == no)
			{
				aRetourner = e;
				break;
			}
		}
		
		if(aRetourner==null){
			//Cas d'erreur
			throw new AnnuaireException("Numéro d'objet inconnu");				
		}
		
		return aRetourner;
	}

	public void afficher() {
		System.out.println(annuaire.toString());
	}
	


}
