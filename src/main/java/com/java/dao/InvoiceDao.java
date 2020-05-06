package com.java.dao;

import java.util.List;

import com.java.model.Invoice;

public interface InvoiceDao {
	int addInvoice(Invoice invoice);
	List<Invoice> getAllInvoice();
	Invoice getInvoiveById(int Invoice_id);
	
	
	
}
