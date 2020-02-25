package com.capgemini.bankmgt.service;

import java.sql.SQLException;

import com.capgemini.bankmgt.exception.InvalidCustomerException;


public interface CustomerService {
	public	void  insertCustomer() throws SQLException, InvalidCustomerException;
	public void deleteCustomer() throws SQLException, InvalidCustomerException;
	public void updateContact() throws SQLException,InvalidCustomerException ;

}
