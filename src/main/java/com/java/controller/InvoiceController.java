package com.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.Invoice;
import com.java.model.Login;
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
	public String addInvoice(@Valid @ModelAttribute("invoice") Invoice invoice, ModelMap model,BindingResult br) {
		/*
		 * if (invoice.getNo_of_part() == 0 && invoice.getP_price() == 0 &&
		 * invoice.getVat() == 0) { model.addAttribute("message","cannot process");
		 */
		if(br.hasErrors())
		{return "invoice";
		} else {
			invoiceService.addInvoice(invoice);
			model.addAttribute("invoice_id", invoice.getInvoice_id());
			model.addAttribute("message","Successfully Processed Invoice");
	
		return "invoice";
	}}

	@RequestMapping("/getInvoice")
	public String listInvoicePage(ModelMap model) {
//model.addAttribute(new Invoice());

		List<Invoice> invoiceList = invoiceService.getAllInvoice();
		model.addAttribute("invoiceList", invoiceList);
		return "invoicelist";

	}
	
	@RequestMapping(value = "/Edit/{invoice_id}", method = RequestMethod.GET)
	public String showEditPage(ModelMap model,@PathVariable int invoice_id)
	{
		
		Invoice editInvoice=invoiceService.getInvoiveById(invoice_id);
		model.addAttribute("invoice",editInvoice);
		return "invoice";
	}
	@RequestMapping(value = "/save")
	public String showEditPage(@ModelAttribute("invoice") Invoice invoice,ModelMap model)
	{
		if (invoice.getInvoice_id()==0)
		{invoiceService.addInvoice(invoice);}
		else
		{	invoiceService.updateInvoice(invoice);}
		model.addAttribute("invoice_id", invoice.getInvoice_id());
		model.addAttribute("message","Successfully Updated Invoice");
		return "invoice";
	}
	@RequestMapping(value = "/Delete/{invoice_id}", method = RequestMethod.GET)
	public String deletePage(ModelMap model,@PathVariable int invoice_id)
	{
		
		invoiceService.deleteInvoice(invoice_id);
		List<Invoice> invoiceList = invoiceService.getAllInvoice();
		model.addAttribute("invoiceList", invoiceList);
	
		return "invoicelist";
	}
	
	
	
	
	
}
