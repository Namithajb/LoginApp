package com.java.controller;

import java.util.Date;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java.model.Invoice;
import com.java.service.InvoiceService;
@Controller
public class PdfController {
	
	@Autowired
public InvoiceService invoiceService;

 
	@RequestMapping(value = "/generatepdf/{invoice_id}", method = RequestMethod.GET)
	public void generatePdf(HttpServletRequest request, HttpServletResponse response,@PathVariable int invoice_id) throws Exception {
		System.out.println("Calling generatePdf()...");

		Invoice invoice = invoiceService.getInvoiveById(invoice_id);
		
		/*
		 * invoice.setInvoice_id(4545); invoice.setTotal_price(1000);
		 * invoice.setP_price(10); invoice.setNo_of_part(10); invoice.setTotal_amt(100);
		 * invoice.setVat(5);
		 */
		Document document = new Document();
		try {
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			
			/*
			 * Paragraph header = new Paragraph(new
			 * Chunk("eKapital Invoice",FontFactory.getFont(FontFactory.HELVETICA, 30)));
			 * 
			 * document.add(header);
			 */
			Font headFont = FontFactory.getFont(FontFactory.COURIER_BOLD);
			//document.add(new Paragraph(new Date().toString()));
			
			Paragraph chapterTitle = new Paragraph("eKapital", headFont);
		    Chapter chapter1 = new Chapter(chapterTitle, 1);
		    chapter1.setNumberDepth(0);

		    Paragraph sectionTitle = new Paragraph("Invoice to", headFont);
		    Section section1 = chapter1.addSection(sectionTitle);
		 
		    Paragraph sectionContent = new Paragraph("Nic Behra\r\n" + 
		    		"HB Creative\r\n" + 
		    		"1a, Augusta Place , Leamington Spa\r\n" + 
		    		"Warwickshire CV32 5EL", headFont);
		    section1.add(sectionContent);
		 
		    document.add(chapter1);
		 
			document.add(createInvoiceTable(invoice));
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();

	}
	

	private PdfPTable createInvoiceTable(Invoice invoice) {
		PdfPTable table = new PdfPTable(7);
		
	try {

		table.setWidthPercentage(100);

	table.setWidths(new int[] { 3, 3, 3,3,3,3,3});
	table.setSpacingBefore(10f); 
		Font headFont = FontFactory.getFont(FontFactory.COURIER_BOLD);
		
		
        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("Invoice id", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Purchase price", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Vat", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
   
        hcell = new PdfPCell(new Phrase("No of Part", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Total price", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("Total vat", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        
        hcell = new PdfPCell(new Phrase("Total amt", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);


		PdfPCell cell1 = new PdfPCell(new Paragraph(""+ invoice.getInvoice_id()));
        cell1.setBorderColor(BaseColor.BLUE);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell2 = new PdfPCell(new Paragraph(""+ invoice.getP_price()));
        cell2.setBorderColor(BaseColor.GREEN);
        cell2.setPaddingLeft(10);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell3 = new PdfPCell(new Paragraph(""+ invoice.getVat()));
        cell3.setBorderColor(BaseColor.RED);
        cell3.setPaddingLeft(10);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
       
			PdfPCell cell4 = new PdfPCell(new Paragraph(""+ invoice.getNo_of_part()));
	        cell4.setBorderColor(BaseColor.BLUE);
	        cell4.setPaddingLeft(10);
	        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell5 = new PdfPCell(new Paragraph(""+ invoice.getP_price()));
        cell5.setBorderColor(BaseColor.GREEN);
        cell5.setPaddingLeft(10);
        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
 
        PdfPCell cell6 = new PdfPCell(new Paragraph(""+invoice.getTotal_vat()));
        cell6.setBorderColor(BaseColor.RED);
        cell6.setPaddingLeft(10);
        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPCell cell7 = new PdfPCell(new Paragraph(""+invoice.getTotal_amt()));
        cell7.setBorderColor(BaseColor.RED);
        cell7.setPaddingLeft(10);
        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
 
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}

}
