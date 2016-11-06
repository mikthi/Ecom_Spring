package fr.adaming.beans;

import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

public interface IExportFichier {

		public String ExportFichierPDF(String path,Commande com, double montantTotal, List<Produit> listeProduit);
}
