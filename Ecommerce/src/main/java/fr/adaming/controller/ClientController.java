package fr.adaming.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String afficherAccueil(ModelMap model)
	{
		return "home";
	}

}
