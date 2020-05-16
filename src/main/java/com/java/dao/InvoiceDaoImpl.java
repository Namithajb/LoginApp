package com.java.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.java.model.Invoice;

@Component
public class InvoiceDaoImpl implements InvoiceDao {
	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addInvoice(Invoice invoice) {
		String sql = "insert into invoice(`p_price`,`vat`,`no_of_part`,`total_price`,`total_vat`,`total_amt`) values(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { invoice.getP_price(), invoice.getVat(), invoice.getNo_of_part(),
				invoice.getTotal_price(), invoice.getTotal_vat(), invoice.getTotal_amt() });
	}

	public Invoice getInvoiveById(int invoice_id) {
		return this.jdbcTemplate.queryForObject("select * from invoice where invoice_id=?", new Object[] { invoice_id },
				new ActorMapper());

	}

	public List<Invoice> getAllInvoice() {
		return this.jdbcTemplate.query(
				"select invoice_id, p_price,vat,no_of_part,total_price,total_vat," + "total_amt from invoice",
				new ActorMapper());
	}

	public int updateInvoice(Invoice invoice)
	{
		String sql = "update invoice set p_price=?,vat=?,no_of_part=?,total_price=?,total_vat=?,total_amt=? where invoice_id=?";
		return jdbcTemplate.update(sql, new Object[] { invoice.getP_price(), invoice.getVat(), invoice.getNo_of_part(),
				invoice.getTotal_price(), invoice.getTotal_vat(), invoice.getTotal_amt() ,invoice.getInvoice_id()});
	}
	
	public int deleteInvoice(int invoice_id)	
	{
		String sql="delete from invoice where invoice_id=?";
		return jdbcTemplate.update(sql,new Object[] {invoice_id});
	}



}

final class ActorMapper implements RowMapper<Invoice> {

	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invoice invoice = new Invoice();
		invoice.setInvoice_id(rs.getInt("invoice_id"));
		invoice.setP_price(rs.getFloat("p_price"));
		invoice.setVat(rs.getFloat("vat"));
		invoice.setNo_of_part(rs.getFloat("no_of_part"));
		invoice.setTotal_price(rs.getFloat("total_price"));
		invoice.setTotal_vat(rs.getFloat("total_vat"));
		invoice.setTotal_amt(rs.getFloat("total_amt"));
		return invoice;
		}
	}

	
