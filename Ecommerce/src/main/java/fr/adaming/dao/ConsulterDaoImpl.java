package fr.adaming.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fr.adaming.model.Categorie;
import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

@Repository
public class ConsulterDaoImpl implements IConsulterDao {
	@Autowired
	private SessionFactory sf;


	@Override
	public Commande consulterCommande(int id_commande) {
		Session s = sf.getCurrentSession();
		String req = "FROM Commande c WHERE id_commande=:id_commande";
		Query query = s.createQuery(req);
		query.setParameter("id_commande", id_commande);
		return  (Commande) query.uniqueResult();
	}

	@Override
	public List<Produit> consulterTousLesProduits() {
		Session s = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Produit> listeProduits = query.list();
		return listeProduits;
	}

	@Override
	public List<Categorie> consulterToutesLesCategories() {
		Session s = sf.getCurrentSession();

		String req = "FROM Categorie";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Categorie> listeCategories = query.list();

		return listeCategories;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> consulterLesProduitsParCategorie(int id_categ) {
		Session s = sf.getCurrentSession();

		String req = "FROM Produit p WHERE p.categorie.id_categorie=:id_categ";
		Query query = s.createQuery(req);
		query.setParameter("id_categ", id_categ);
		return (List<Produit>) query.list();

	
	}

	@Override
	public Produit consulterProduitSelectionne(int id_produit) {
		Session s = sf.getCurrentSession();

		String req = "FROM Produit p WHERE id_produit=:id_produit";
		Query query = s.createQuery(req);
		query.setParameter("id_produit", id_produit);
		return  (Produit) query.uniqueResult();
	
	}

	@Override
	public List<Produit> chercherProduitsParMotCle(String motCle) {
		Session s = sf.getCurrentSession();

		String req = "SELECT p FROM Produit p WHERE p.nom like:kw or p.description like:kw";
		Query query = s.createQuery(req);
		query.setParameter("kw", "%" + motCle + "%");
		@SuppressWarnings("unchecked")
		List<Produit> listeProduits = query.list();

		return listeProduits;
	}
	
	@Override
	public Categorie consulterCategorieParId(int id_categorie) {
		Session s = sf.getCurrentSession();

		String req = "FROM Categorie c WHERE c.id_categorie=:categ_id";
		Query query = s.createQuery(req);

		query.setParameter("categ_id", id_categorie);

		Categorie c = (Categorie) query.uniqueResult();

		return c;
	}
	
	@Override
	public Produit consulterProduitParId(int id_produit) {
		Session s = sf.getCurrentSession();

		String req = "FROM Produit p WHERE p.id_produit=:prod_id";
		Query query = s.createQuery(req);

		query.setParameter("prod_id", id_produit);

		Produit p = (Produit) query.uniqueResult();

		return p;
	}
	
	/** getters et setters */
	
	/**
	 * @param sf the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

}
