package fr.adaming.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEvent;
import com.lowagie.text.pdf.PdfWriter;

import fr.adaming.model.Commande;
import fr.adaming.model.Produit;

@Component
public class FacturePDF implements IExportFichier {
	private static String FILE = "c:/temp/FirstPdf.pdf";

	public void creerFacturePdf() {

	}

	@Override
	public String ExportFichierPDF(String path, Commande com, double montantTotal, List<Produit> listeProduit) {
		Document document = new Document(PageSize.A4);

		PdfWriter pdfWriter;
		String fullPath = path + "/download/facture" + com.getId_commande();
		try {

			String appPath = path;
			System.out.println("appPath = " + appPath);
			// construct the complete absolute path of the file

			File downloadFile = new File(fullPath);
			pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fullPath));

			document.open();
			document.add(new Paragraph("Nom : " + com.getClient().getNom()));
			document.add(new Paragraph("Prenom : " + com.getClient().getPrenom()));
			document.add(new Paragraph("Mail : " + com.getClient().getMail()));
			document.add(new Paragraph("Téléphone : " + com.getClient().getTelephone()));
			document.add(new Paragraph(""));
			document.add(new Paragraph("Commandé le  : " + com.getDateCommande().toString()));
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));

			final PdfPTable table = new PdfPTable(3);

			// Creation d'une PdfPCell avec un paragraphe
			final PdfPCell cell = new PdfPCell(new Paragraph("Produits commandés"));

			// Changement du colspan de la PdfCell
			cell.setColspan(3);

			// Ajout de la PdfCell custom à la PdfPTable
			table.addCell(cell);
			PdfPCell cellCenter = new PdfPCell();
			  Paragraph CellText = new Paragraph("Produit");
			cellCenter.addElement(CellText);
			// Ajout d'objets String à la PdfPTable
			table.addCell(cellCenter);
			table.addCell("Prix");
			table.addCell("Quantité");
			for (int i = 0; i < listeProduit.size(); i++) {
				table.addCell(listeProduit.get(i).getNom());
				table.addCell(Double.toString(listeProduit.get(i).getPrix())+" €");
				table.addCell(Integer.toString(com.getProduitCommande().get(listeProduit.get(i).getId_produit())));
			}
			table.addCell("Votre facture s'éléve à  ");
			table.addCell(Double.toString(montantTotal)+" €");
			table.addCell("");
			table.setSpacingBefore(50f);
			document.add(table);
			document.addTitle("Facture");
			document.addSubject("Utilisant iText");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("Ecom mikthi");
			document.addCreator("Ecom mikthi");
			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fullPath;

	}

}
