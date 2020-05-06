package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.InvoiceDao;
import com.java.dao.UserDAO;
import com.java.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	public InvoiceDao invoiceDao;
	
	@Override
	public int addInvoice(Invoice invoice)
	{
		return invoiceDao.addInvoice(invoice);
	}
	
	@Override
	public List<Invoice> getAllInvoice()
	{
		return invoiceDao.getAllInvoice();
	}
    @Override
	public Invoice getInvoiveById(int Invoice_id)
	{
		return invoiceDao.getInvoiveById(Invoice_id);
	}

	
	
	
}
