package com.java.model;

import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Invoice {
	
private int invoice_id;


private	float p_price;




@Range(min=0, max=90,message="required")
private	float vat;

@NotNull(message="required")
private	float no_of_part;

private	float total_price;
private	float total_vat;
private	float total_amt;
	
	
	
	
	
    public Invoice() {

}
	public Invoice(int invoice_id,float p_price, float vat, float no_of_part, float total_price, float total_vat, float total_amt) {
		this.invoice_id = invoice_id;
	this.p_price = p_price;
	this.vat = vat;
	this.no_of_part = no_of_part;
	this.total_price = total_price;
	this.total_vat = total_vat;
	this.total_amt = total_amt;
}
	
	
	
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public float getP_price() {
		return p_price;
	}
	public void setP_price(float p_price) {
		this.p_price = p_price;
	}
	public float getVat() {
		return vat;
	}
	public void setVat(float vat) {
		this.vat = vat;
	}
	public float getNo_of_part() {
		return no_of_part;
	}
	public void setNo_of_part(float no_of_part) {
		this.no_of_part = no_of_part;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public float getTotal_vat() {
		return total_vat;
	}
	public void setTotal_vat(float total_vat) {
		this.total_vat = total_vat;
	}
	public float getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(float total_amt) {
		this.total_amt = total_amt;
	}

	
	
	
	
	
	
	
	
}
