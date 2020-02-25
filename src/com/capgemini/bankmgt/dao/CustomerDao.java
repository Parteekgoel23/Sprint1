package com.capgemini.bankmgt.dao;

import java.sql.SQLException;

import com.capgemini.bankmgt.dto.Customer;
import com.capgemini.bankmgt.exception.InvalidCustomerException;

public interface CustomerDao {
	
	public boolean createAccount(Customer customer1) throws SQLException;
	public Customer SearchCustomer(String customerAadhar) throws SQLException;
	public boolean updateAccount(String customerId, String customerContact) throws SQLException;
	public boolean deleteAccount(String customerId) throws SQLException; 
	public Customer SearchCustomer2(String customerId) throws SQLException;
	public Customer SearchCustomer3(String customerId) throws SQLException;
	

}
