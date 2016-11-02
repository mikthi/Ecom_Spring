package fr.adaming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IEditerService;
import fr.adaming.validator.CategorieValidator;
import fr.adaming.validator.ProduitValidator;

@Controller
@RequestMapping(value = "/gestionnaire")
public class GestionnaireController {

	@Autowired(required = true)
	private IEditerService gestionnaireService;
	@Autowired
	private CategorieValidator categValidator;
	@Autowired
	private ProduitValidator prodValidator;

	/**
	 * Setter
	 */
	/**
	 * @param gestionnaireService
	 *            the gestionnaireService to set
	 */
	public void setGestionnaireService(IEditerService gestionnaireService) {
		this.gestionnaireService = gestionnaireService;
	}

	/**
	 * Corps de l'affichage de la page d'accueil
	 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String welcomeGestionnaire(ModelMap model) {

		List<Categorie> listeCategories = gestionnaireService.consulterToutesLesCategories();
		model.addAttribute("listeCateg", listeCategories);

		return "accueilGestionnaire";
	}

	/**
	 * Corps de l'affichage du formulaire pour l'ajout d'un produit
	 */
	@RequestMapping(value = "/formAjoutProd", method = RequestMethod.GET)
	public String afficherFormAjoutProd(ModelMap model) {
		List<Categorie> listCateg = gestionnaireService.consulterToutesLesCategories();
		model.addAttribute("prod", new Produit());
		model.addAttribute("listCateg", listCateg);
		return "formulaireAjoutProd";
	}

	/**
	 * Corps de la récupération du formulaire et de l'ajout du produit
	 */
	@RequestMapping(value = "/ajouterProduit", method = RequestMethod.POST)
	public String ajouterProduit(@ModelAttribute("prod") Produit produit, ModelMap model, BindingResult result) {

		prodValidator.validate(produit, result);
		if (result.hasErrors()) {
			// Echec du validator
			return "formulaireAjoutProd";
		} else {
			List<Categorie> listCateg = gestionnaireService.consulterToutesLesCategories();
			gestionnaireService.ajouterProduit(produit);
			model.addAttribute("prod", new Produit());
			model.addAttribute("listCateg", listCateg);
			return "formulaireAjoutProd";
		}
	}

	/**
	 * Corps de l'affichage du formulaire pour ajouter une catégorie
	 */
	@RequestMapping(value = "/formAjoutCateg", method = RequestMethod.GET)
	public String afficherFormAjoutCat(ModelMap model) {

		model.addAttribute("categ", new Categorie());
		return "formulaireAjoutCateg";
	}

	/**
	 * Corps de la récupération du formulaire et de l'ajout de la catégorie
	 */
	@RequestMapping(value = "/ajouterCategorie", method = RequestMethod.POST)
	public String ajouterCategorie(@ModelAttribute("categ") Categorie categorie, ModelMap model, BindingResult result) {

		categValidator.validate(categorie, result);
		if (result.hasErrors()) {
			// Echec du validator
			return "formulaireAjoutCateg";
		} else {
			gestionnaireService.ajouterCategorie(categorie);
			model.addAttribute("categ", new Categorie());
			return "formulaireAjoutCateg";
		}
	}

	/**
	 * Corps de l'affichage du formulaire pour modifier une catégorie
	 */
	@RequestMapping(value = "/formModifCateg", method = RequestMethod.POST)
	public String afficherFormModifCat(int IdCategorie, ModelMap model) {

		Categorie categ = this.gestionnaireService.consulterCategorieParId(IdCategorie);
		model.addAttribute("categ", categ);
		return "formulaireModifCateg";

	}

	/**
	 * Corps de la récupération du formulaire et de la modification de la
	 * catégorie
	 */
	@RequestMapping(value = "/modifierCategorie", method = RequestMethod.POST)
	public String modifierCategorie(@ModelAttribute("categ") Categorie categorie, ModelMap model,
			BindingResult result) {

		categValidator.validate(categorie, result);
		if (result.hasErrors()) {
			// Echec du validator
			return "formulaireAjoutCateg";
		} else {
			gestionnaireService.modifierCategorie(categorie);
			Categorie categ = gestionnaireService.consulterCategorieParId(categorie.getId_categorie());
			model.addAttribute("categ", categ);
			return "affichageCategorieParId";
		}
	}

	/**
	 * Corps de l'affichage de la liste des catégories
	 */
	@RequestMapping(value = "/listeCategories", method = RequestMethod.GET)
	public String listeCateg(ModelMap model) {

		List<Categorie> listeCategories = gestionnaireService.consulterToutesLesCategories();
		model.addAttribute("listeCateg", listeCategories);
		return "listeCategories";
	}

	/**
	 * Corps de l'affichage de la liste des produits
	 */
	@RequestMapping(value = "/listeProduits", method = RequestMethod.GET)
	public String listeProd(ModelMap model) {

		List<Produit> listeProduits = gestionnaireService.consulterTousLesProduits();
		model.addAttribute("listeProd", listeProduits);
		return "listeProduits";
	}

	/**
	 * Corps de l'affichage du formulaire pour modifier un produit
	 */
	@RequestMapping(value = "/formModifProd", method = RequestMethod.POST)
	public String afficherFormModifProd(int IdProduit, ModelMap model) {

		List<Categorie> listCateg = gestionnaireService.consulterToutesLesCategories();
		Produit prod = this.gestionnaireService.consulterProduitParId(IdProduit);
		model.addAttribute("prod", prod);
		model.addAttribute("listCateg", listCateg);
		return "formulaireModifProd";

	}

	/**
	 * Corps de la récupération du formulaire et de la modification du produit
	 */
	@RequestMapping(value = "/modifierProduit", method = RequestMethod.POST)
	public String modifierProduit(@ModelAttribute("prod") Produit produit, ModelMap model,
			BindingResult result) {

		prodValidator.validate(produit, result);
		if (result.hasErrors()) {
			// Echec du validator
			return "formulaireAjoutProd";
		} else {
		gestionnaireService.modifierProduit(produit);
		Produit prod = gestionnaireService.consulterProduitParId(produit.getId_produit());
		model.addAttribute("prod", prod);
		return "affichageProduitParId";
		}
	}

	/**
	 * Corps de la suppression du produit
	 */
	@RequestMapping(value = "/supprimerProduit", method = RequestMethod.POST)
	public String supprimerProduit(int IdProduit, ModelMap model) {

		gestionnaireService.supprimerProduit(IdProduit);
		List<Produit> listeProduits = gestionnaireService.consulterTousLesProduits();
		model.addAttribute("listeProd", listeProduits);
		return "listeProduits";
	}

	/**
	 * Corps de la suppression d'une catégorie
	 */
	@RequestMapping(value = "/supprimerCategorie", method = RequestMethod.POST)
	public String supprimerCategorie(int IdCategorie, ModelMap model) {

		gestionnaireService.supprimerCategorie(IdCategorie);
		List<Categorie> listeCategories = gestionnaireService.consulterToutesLesCategories();
		model.addAttribute("listeCateg", listeCategories);
		return "listeCategories";
	}

	/**
	 * Corps de la recherche d'un produit par mot-clef
	 */
	@RequestMapping(value = "/chercherProduit", method = RequestMethod.POST)
	public String chercherProduit(String motCle, HttpServletRequest request, ModelMap model) {
		request.getParameter(motCle);
		List<Produit> listeProduitsCherches = gestionnaireService.chercherProduitsParMotCle(motCle);

		if (listeProduitsCherches.size() == 0) {
			return "noProduct";
		} else {
			model.addAttribute("listeProd", listeProduitsCherches);
			return "listeProduits";
		}
	}

}
