package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/gestionnaire")
public class GestionnaireController {
	
	// Corps de l'affichage de la page d'accueil
		@RequestMapping(value = "/accueil", method = RequestMethod.GET)
		public String welcomeGestionnaire() {
			return "accueilGestionnaire";
		}

	

	
	
}
