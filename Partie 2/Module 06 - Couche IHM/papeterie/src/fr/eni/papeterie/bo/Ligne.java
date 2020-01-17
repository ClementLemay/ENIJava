package fr.eni.papeterie.bo;

public class Ligne
{
	//Attributs
	private int qte;
	private Article article;
	
	//Constructeurs
	public Ligne(Article article, int qte) 
	{
			setArticle(article);
			setQte(qte);
	}
	
	//Getters et Setters
	public int getQte()
	{
		return qte;
	}

	public void setQte(int qte)
	{
		this.qte = qte;
	}
	
	
	
	public Article getArticle()
	{
		return this.article;
	}

	private void setArticle(Article article) 
	{
		this.article = article;		
		
	}
	
	public float getPrix()
	{
		return article.getPrixUnitaire() * qte;
	}
	
	
	//Méthodes
	public String toString()
	{
		StringBuffer buf = new StringBuffer();
		buf.append("Ligne [");
		buf.append(" qte=");
		buf.append(getQte());
		buf.append(", prix=");
		buf.append(getPrix());
		buf.append(", ");
		if (article != null) {
			buf.append("article=");
			buf.append(getArticle().toString());
		}
		buf.append("]");
		return buf.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
}
