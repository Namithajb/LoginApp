package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.model.Invoice;

@Service
public interface InvoiceService {

	int addInvoice(Invoice invoice);

	List<Invoice> getAllInvoice();

	Invoice getInvoiveById(int Invoice_id);
	
	int updateInvoice(Invoice invoice);
	
	int deleteInvoice(int invoice_id);
	
}
