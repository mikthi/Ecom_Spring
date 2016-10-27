package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IEditerService;

@Controller
@RequestMapping(value = "/gestionnaire")
public class GestionnaireController {

	@Autowired(required = true)
	private IEditerService gestionnaireService;

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
	public String welcomeGestionnaire() {
		return "accueilGestionnaire";
	}

	/**
	 * Corps de l'affichage du formulaire pour l'ajout d'un produit
	 */
	@RequestMapping(value = "/formAjoutProd", method = RequestMethod.GET)
	public String afficherFormAjoutProd(ModelMap model) {

		model.addAttribute("prod", new Produit());
		return "formulaireAjoutProd";
	}

	/**
	 * Corps de l'affichage de la récupération du formulaire et de l'ajout du
	 * produit
	 */
	@RequestMapping(value = "/ajouterProduit", method = RequestMethod.POST)
	public String ajouterProduit(@ModelAttribute("prod") Produit produit, ModelMap model) {

		gestionnaireService.ajouterProduit(produit);

		return "formulaireAjoutProd";
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
	 * Corps de l'affichage de la récupération du formulaire et de l'ajout de la
	 * catégorie
	 */
	@RequestMapping(value = "/ajouterCategorie", method = RequestMethod.POST)
	public String ajouterCategorie(@ModelAttribute("categ") Categorie categorie, ModelMap model) {

		gestionnaireService.ajouterCategorie(categorie);

		return "formulaireAjoutCateg";
	}

}
