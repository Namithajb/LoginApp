package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.Invoice;
import com.java.model.User;
import com.java.service.InvoiceService;
import com.java.service.UserService;

@Controller
public class InvoiceController {

	@Autowired
	public InvoiceService invoiceService;

	@RequestMapping("/invoice")
	public String showInvoicePage(ModelMap model) {
		model.addAttribute(new Invoice());
		return "invoice";
	}

	@RequestMapping(value = "/invoiceProcess")
	public String addInvoice(@ModelAttribute("invoice") Invoice invoice, ModelMap model) {
		if (invoice.getNo_of_part() == 0 && invoice.getP_price() == 0 && invoice.getVat() == 0) {
			model.addAttribute("message","");
		} else {
			invoiceService.addInvoice(invoice);
			model.addAttribute("invoice_id", invoice.getInvoice_id());
			model.addAttribute("message","Successfully Processed Invoice");
		}
		return "invoice";
	}

	@RequestMapping("/getInvoice")
	public String listInvoicePage(ModelMap model) {
//model.addAttribute(new Invoice());

		List<Invoice> invoiceList = invoiceService.getAllInvoice();
		model.addAttribute("invoiceList", invoiceList);
		return "invoicelist";

	}

}