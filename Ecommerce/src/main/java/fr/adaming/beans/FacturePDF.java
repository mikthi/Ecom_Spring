package fr.adaming.beans;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;



public  class FacturePDF  extends AbstractPdfView implements IExportFichier {

	@Override
	protected void buildPdfDocument(Map<String, Object> arg0, Document arg1, PdfWriter arg2, HttpServletRequest arg3,
			HttpServletResponse arg4) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ExportFichierPDF() {
		// TODO Auto-generated method stub
		
	}





}
