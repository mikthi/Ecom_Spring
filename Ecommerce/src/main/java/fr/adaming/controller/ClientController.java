package fr.adaming.controller;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.pdf.PdfWriter;

import fr.adaming.beans.FacturePDF;
import fr.adaming.beans.IExportFichier;
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
	public String ajouterProduitPanier(Integer QuantiteSelect , ModelMap model,  HttpSession session)
	{
		double prixLigneCommande;	
		System.out.println("Id" +QuantiteSelect);
		Panier panierSession =(Panier) session.getAttribute("panier");
		int IdProduitSelectionne= (int) session.getAttribute("IdProduitSelectionne");
		if(panierSession.getProduitCommande().containsKey(IdProduitSelectionne))
		{
			//produit deja en panier
			int produitEnPanier=panierSession.getProduitCommande().get(IdProduitSelectionne);
			System.out.println("ancienne quantité : "+ produitEnPanier+"\nnouvel quantité : "+ QuantiteSelect);
			Produit prodCommande=commanderService.consulterProduitParId(IdProduitSelectionne);
			prixLigneCommande=prodCommande.getPrix()*(QuantiteSelect-produitEnPanier);
			panierSession.setMontantTotalPanier(panierSession.getMontantTotalPanier()+prixLigneCommande);
		}
		else 
		{
			// produit non présent en panier
			Produit prodCommande=commanderService.consulterProduitParId(IdProduitSelectionne);
			prixLigneCommande=prodCommande.getPrix()*QuantiteSelect;
			panierSession.setMontantTotalPanier(panierSession.getMontantTotalPanier()+prixLigneCommande);
		}
		panierSession.getProduitCommande().put(IdProduitSelectionne,QuantiteSelect);
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
		session.setAttribute("IdCommande", com.getId_commande());
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

	@RequestMapping(value="/getFacturePdf", method=RequestMethod.GET)
	public void getFacturePDF(HttpServletRequest request , HttpServletResponse response,  HttpSession session) throws IOException
	{

     
           int BUFFER_SIZE = 4096;
        
        /**
         * Path of the file to be downloaded, relative to application's directory
         */
         String filePath = "/download/test.pdf";
        

     
            // get absolute path of the application
            ServletContext context = request.getServletContext();
            Commande com = commanderService.consulterCommande((int)session.getAttribute("IdCommande"));
            
            String appPath = context.getRealPath("");
            System.out.println("appPath = " + appPath);
            // construct the complete absolute path of the file
            String fullPath = appPath + filePath;      
            IExportFichier factPdf =new FacturePDF();
            
            
    		List<Produit> listeProduit = new ArrayList<>();
    		Set<Integer> listeClePanier = com.getProduitCommande().keySet();
    		Iterator<Integer> iterator = listeClePanier.iterator();
    		double montantTotal=0;
    		while(iterator.hasNext()){
    			Produit prod=commanderService.consulterProduitParId(iterator.next());
    			listeProduit.add(prod);
    			montantTotal=montantTotal+prod.getPrix()* (double) com.getProduitCommande().get(prod.getId_produit());
    		}
    		
    		
            
            
            File downloadFile = new File(factPdf.ExportFichierPDF(appPath, com,montantTotal,listeProduit));
            FileInputStream inputStream = new FileInputStream(downloadFile);
             
            // get MIME type of the file
            String mimeType = context.getMimeType(fullPath);
            if (mimeType == null) {
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
            System.out.println("MIME type: " + mimeType);
     
            // set content attributes for the response
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
     
            // set headers for the response
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"",
                    downloadFile.getName());
            response.setHeader(headerKey, headerValue);
     
            // get output stream of the response
            OutputStream outStream = response.getOutputStream();
     
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
     
            // write bytes read from the input stream into the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
     
            inputStream.close();
            outStream.close();
		
		
	}
}
