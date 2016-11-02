package fr.adaming.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.ICommanderService;

@Controller
@RequestMapping(value="/client")
public class ClientController {

	@Autowired
	ICommanderService commanderService;


/*
 * Chargement de la page de consultation des produits à destination du client
 */

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String initAccueil(ModelMap model, HttpSession session)
	{

		Panier panier= new Panier();
		// préparation de la vue 
		model.addAttribute("listeCateg", commanderService.consulterToutesLesCategories());	
		model.addAttribute("listeProd", commanderService.consulterTousLesProduits());
		model.addAttribute("produitSelectionne", new Produit());
		// Mise en session du panier et de la dernière catégorie afficher par l'utilisateurs
		session.setAttribute("idChoixCateg",0);
		session.setAttribute("panier", panier);
		return "home";
	}
	
	@RequestMapping(value="/accueil",method=RequestMethod.GET)
	public String retourAccueil(ModelMap model, HttpSession session)
	{

		
		// préparation de la vue 
		model.addAttribute("listeCateg", commanderService.consulterToutesLesCategories());	
		model.addAttribute("listeProd", commanderService.consulterTousLesProduits());
		model.addAttribute("produitSelectionne", new Produit());
		// Mise en session du panier et de la dernière catégorie afficher par l'utilisateurs
		session.setAttribute("idChoixCateg",0);
		return "home";
	}
	
	
	/*
	 * actualisation de la liste des produits après selection du menu
	 */
	@RequestMapping(value="/selectCategorie",method=RequestMethod.GET)
	public String changementAffichageProduit(int IdCateg, ModelMap model,  HttpSession session)
	{
		session.setAttribute("idChoixCateg", IdCateg);
		if(IdCateg!=0)
			model.addAttribute("listeProd",  commanderService.consulterLesProduitsParCategorie(IdCateg));
		else
			model.addAttribute("listeProd",  commanderService.consulterTousLesProduits());
		model.addAttribute("listeCateg", commanderService.consulterToutesLesCategories());

		return "home";
	}
	
	/*
	 * De la page accueil à la selection d'un article dans le but de le commander
	 */
	@RequestMapping(value="/consulterProduit",method=RequestMethod.POST)
	public String consulterProduit( int IdProduit, ModelMap model,  HttpSession session)
	{
		session.setAttribute("IdProduitSelectionne", IdProduit);
		model.addAttribute("produitSelectionne", commanderService.consulterProduitSelectionne(IdProduit));
		model.addAttribute("panier", new Panier());
		return "consulterproduit";
	}
	
	
	/**
	 * Corps de la recherche d'un produit par mot-clef
	 */
	@RequestMapping(value = "/chercherProduit", method = RequestMethod.POST)
	public String chercherProduit(String motCle, HttpServletRequest request, ModelMap model) {
		request.getParameter(motCle);
		List<Produit> listeProduitsCherches = commanderService.chercherProduitsParMotCle(motCle);
		model.addAttribute("listeCateg", commanderService.consulterToutesLesCategories());
		if (listeProduitsCherches.size() == 0) {
			model.addAttribute("listeProd", commanderService.consulterTousLesProduits());
			
		} else {
			model.addAttribute("listeProd", listeProduitsCherches);
		
		}
		return "home";
	}
	
	
	/***
	 * ajout du produit dans un objet panier mis en session
	 * @param panier
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/ajouterProduitPanier", method=RequestMethod.POST)
	public String ajouterProduitPanier(Panier panier, ModelMap model,  HttpSession session)
	{
		
		Panier panierSession =(Panier) session.getAttribute("panier");
		int idProduitCommande= (int) session.getAttribute("IdProduitSelectionne");
		panierSession.getProduitCommande().put(idProduitCommande, panier.getQuantiteProdSelectionneACommander());
		double prixLigneCommande;
		Produit prodCommande=commanderService.consulterProduitParId(idProduitCommande);
		
		prixLigneCommande=prodCommande.getPrix()*panier.getQuantiteProdSelectionneACommander();
		panierSession.setMontantTotalPanier(panierSession.getMontantTotalPanier()+prixLigneCommande);
		session.setAttribute("panier", panierSession);	
		model.addAttribute("listeCateg", commanderService.consulterToutesLesCategories());	
		int idChoixCateg=(int) session.getAttribute("idChoixCateg");
		if(idChoixCateg==0)
			model.addAttribute("listeProd", commanderService.consulterTousLesProduits());
		else
		model.addAttribute("listeProd", commanderService.consulterLesProduitsParCategorie(idChoixCateg ));
		return "home";
	}
	@RequestMapping(value="/supprimerProduitPanier")
	public String supprimerProduitPanier(int IdProduitASup, ModelMap model,  HttpSession session)
	{
		Panier panierSession = (Panier) session.getAttribute("panier");
		
		
		double prixLigneCommande;
		Produit prodCommande=commanderService.consulterProduitParId(IdProduitASup);
		
		prixLigneCommande=prodCommande.getPrix()*panierSession.getProduitCommande().get(IdProduitASup);
		panierSession.setMontantTotalPanier(panierSession.getMontantTotalPanier()-prixLigneCommande);

		panierSession.getProduitCommande().remove(IdProduitASup);
		
		
		
		List<Produit> produitPanier = new ArrayList<Produit>();
		Set<Integer> listeClePanier = panierSession.getProduitCommande().keySet();
		Iterator<Integer> iterator = listeClePanier.iterator();
		while(iterator.hasNext()){
			produitPanier.add(commanderService.consulterProduitParId( iterator.next()));
		}
		session.setAttribute("panier", panierSession);
		model.addAttribute("listePanier", produitPanier);
		return "panier";
	}
	@RequestMapping(value="/consulterPanier",method=RequestMethod.GET)
	public String consulterPanier( ModelMap model,  HttpSession session)
	{
		Panier pan = (Panier) session.getAttribute("panier");
		List<Produit> produitPanier = new ArrayList<Produit>();
		Set<Integer> listeClePanier = pan.getProduitCommande().keySet();
		Iterator<Integer> iterator = listeClePanier.iterator();
		while(iterator.hasNext()){
			produitPanier.add(commanderService.consulterProduitParId( iterator.next()));
		}
		
		model.addAttribute("listePanier", produitPanier);
		return "panier";
	}
	
	@RequestMapping(value="/consulterFacture",method=RequestMethod.POST)
	public String consulterFacture(Commande com, ModelMap model,  HttpSession session)
	{
		double montantTotal=0;
		com =commanderService.consulterCommande(com.getId_commande());
		System.out.println(com.getClient().toString());
		List<Produit> listeProduit = new ArrayList<>();
		Set<Integer> listeClePanier = com.getProduitCommande().keySet();
		Iterator<Integer> iterator = listeClePanier.iterator();
		while(iterator.hasNext()){
			Produit prod=commanderService.consulterProduitParId(iterator.next());
			listeProduit.add(prod);
			montantTotal=montantTotal+prod.getPrix()* (double) com.getProduitCommande().get(prod.getId_produit());
		}
		
		model.addAttribute("montantTotal",montantTotal);
		model.addAttribute("com",com);
		model.addAttribute("listeProduit", listeProduit);
		return "facture";
	}
	/***
	 * orienter l'utilisateur vers le formulaire pour consulter la facture
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/formInterrogFacture",method=RequestMethod.GET)
	public String interrogationFacture( ModelMap model,  HttpSession session)
	{
		model.addAttribute("com", new Commande());
		return "formulaireinterrogationfacture";
	}
	
	
	@RequestMapping(value="/passerCommande",method=RequestMethod.GET)
	public String passerCommande( ModelMap model,  HttpSession session)
	{
		model.addAttribute("client", new Client());
		
		return "enregistrerclient";
	}
	
	
	
	@RequestMapping(value="/enregClient",method=RequestMethod.POST)
	public String enregistrerCommande(@ModelAttribute("client") Client client, ModelMap model,  HttpSession session)
	{
		
		commanderService.enregistrerClient(client);
		session.setAttribute("client", client);
		Calendar c = Calendar.getInstance();
		Commande com= new Commande(c.getTime(), client);
		Panier panierSession = (Panier) session.getAttribute("panier");
		com.setProduitCommande(panierSession.getProduitCommande());
		commanderService.passerCommande(com);
		model.addAttribute("listeCateg", commanderService.consulterToutesLesCategories());	
		model.addAttribute("listeProd", commanderService.consulterTousLesProduits());
		session.setAttribute("panier", new Panier());
		model.addAttribute("accesFacture", "Veuillez conserver ce numéro, il permettra d'acceder à votre facture : "+ com.getId_commande());
		
		return "home";
	}
	
	
}
