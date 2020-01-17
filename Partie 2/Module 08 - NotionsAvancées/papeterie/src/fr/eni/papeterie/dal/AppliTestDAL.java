package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;

public class AppliTestDAL {

	public static void main(String[] args) {

		//Déclaration et instanciation de la DAO
		//ArticleDAOJdbcImpl articleDAO = new ArticleDAOJdbcImpl();
		//ArticleDAO articleDAO = new ArticleDAOJdbcImpl();
		//A décommenter pour tester la classe DAOFactory
		ArticleDAO articleDAO = DAOFactory.getArticleDAO();

		//Instanciation du jeu d'essai 
		Article a1 = new Stylo( "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");
		Article a2 = new Ramette(  "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		Article a3 = new Stylo( "Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune");


		System.out.println("Ajout des articles... ");
		//TODO...
		try {
			articleDAO.insert(a1);
			System.out.println("Article ajouté  : " + a1.toString() );
			articleDAO.insert(a2);
			System.out.println("Article ajouté  : " + a2.toString() );
			articleDAO.insert(a3);
			System.out.println("Article ajouté  : " + a3.toString() );


			//Sélection de l'article par id
			//TODO...
			Article a = articleDAO.selectById(a2);
			System.out.println("Sélection de l'article par id  : " + a.toString() );

			//Sélection de tous les articles
			//TODO...
			List<Article> articles = articleDAO.selectAll();
			System.out.println("Sélection de tous les articles  : " + articles.toString() );

			//Modification d'un article
			//TODO...
			System.out.println("Modification d'un article  : " );
			System.out.println("Article avant modification : "  + a1.toString());
			((Stylo) a1).setCouleur("noir");
			((Stylo) a1).setDesignation("Bic bille noir");
			((Stylo) a1).setReference("BBNoir");
			articleDAO.update(a1);
			System.out.println("Article après modification  : " + a1.toString() );
			
			System.out.println("Liste des articles par marque : "  );
			articles = articleDAO.selectByMarque("Bic");
			StringBuffer sb = new StringBuffer();
			for(Article art: articles){
				if(art instanceof Stylo){
					sb.append("Stylo   [id=");
				}else{
					sb.append("Ramette [id=");
				}
				sb.append(art.getIdArticle());
				sb.append(", ref=");
				sb.append(art.getReference()).append("]\n");
			}
			System.out.println(sb.toString());
			System.out.println("---------------------------------------------------------------");
			
			System.out.println("Liste des articles par mot cl� : "  );
			articles = articleDAO.selectByMotCle("Plume");
			for(Article art: articles){
				System.out.println(art);
			}
			
			System.out.println("---------------------------------------------------------------");
			
			//Suppression d'un article
			//TODO...
			System.out.println("Suppression de l'article  : " + a1.toString());
			articleDAO.delete(a1);
			articles = articleDAO.selectAll();
			//System.out.println("Liste des articles après suppression : " + articles.toString() );
			System.out.println("Liste des articles après suppression : "  );
			sb = new StringBuffer();
			for(Article art: articles){
				if(art instanceof Stylo){
					sb.append("Stylo   [id=");
				}else{
					sb.append("Ramette [id=");
				}
				sb.append(art.getIdArticle());
				sb.append(", ref=");
				sb.append(art.getReference()).append("]\n");
			}
			System.out.println(sb.toString());
			System.out.println("---------------------------------------------------------------");
			
			
			
			
			

			
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

}
