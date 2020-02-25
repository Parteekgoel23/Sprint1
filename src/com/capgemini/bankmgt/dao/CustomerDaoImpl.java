package com.capgemini.bankmgt.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.capgemini.bankmgt.dto.*;
import com.capgemini.bankmgt.exception.InvalidCustomerException;
import com.capgemini.bankmgt.util.DatabaseUtil;
public class CustomerDaoImpl  implements CustomerDao {
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	Customer customer;
	
   
   Customer c=null;
   
   String ch;
   Scanner sc=new Scanner(System.in);
   
   public CustomerDaoImpl() throws SQLException {

   connection=DatabaseUtil.myconnection();
   connection.setAutoCommit(false);
   }

@Override
public boolean createAccount(Customer customer1) throws SQLException {
	customer = SearchCustomer(customer1.getCustomerAadhar());
	if (customer == null) {
		pst = null;
		System.out.println("customer not present can be added");
		pst = connection.prepareStatement("insert into customer values(?,?,?,?,?,?,?) ");
		pst.setString(1, customer1.getCustomerId());
		pst.setString(2, customer1.getCustomerName());
		pst.setString(3, customer1.getCustomerAddress());
		pst.setString(4, customer1.getCustomerAadhar());
		pst.setString(5, customer1.getCustomerPan());
		pst.setString(6, customer1.getCustomerContact());
		pst.setString(7, customer1.getCustomerGender());
		
		int res = pst.executeUpdate();
		if (res == 1) {
			System.out.println("Add it to database y\\n");
			ch = sc.next();
			if (ch.equalsIgnoreCase("y")) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		}
	}
	return false;
}


	

@Override
public Customer SearchCustomer(String customerAadhar) throws SQLException {
	customer = null;

	pst = connection.prepareStatement("select * from customer where Aadhar=?");
	pst.setString(1, customerAadhar);
	rs = null;
	rs = pst.executeQuery();

	if (rs.next()) {
		System.out.println("  search found ....");
		customer = null;
		customer = new Customer();

		customer.setCustomerId(rs.getString(1));
		customer.setCustomerName(rs.getString(2));
		customer.setCustomerAddress(rs.getString(3));
		customer.setCustomerAadhar(rs.getString(4));
		customer.setCustomerPan(rs.getString(5));
		customer.setCustomerContact(rs.getString(6));
		customer.setCustomerGender(rs.getString(7));
		
	 
	}  
	return customer;
}

@Override
public boolean deleteAccount(String customerId ) throws SQLException {
	customer=null;
	
	customer = SearchCustomer2(customerId);


	if (customer!=null) {
		pst = null;
		pst = connection.prepareStatement("DELETE FROM customer WHERE Id=? ");
		pst.setString(1, customer.getCustomerId());
		int res = pst.executeUpdate();
		if (res == 1) {
			System.out.println("delete it from database y\\n");
			ch = sc.next();
			if (ch.equalsIgnoreCase("y")) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		}
	}


	return false;
	
}
public Customer SearchCustomer2(String customerId) throws SQLException {
	
	pst = connection.prepareStatement("select * from customer where Id=?");
	pst.setString(1, customerId);
	rs = null;
	rs = pst.executeQuery();
	if (rs.next()) {
		
		customer = null;
		customer = new Customer();

		customer.setCustomerId(rs.getString(1));

	
	 
	}  
	return customer;
}

@Override
public boolean updateAccount(String customerId, String customerContact) throws SQLException {
	//System.out.println("update acc called .......1");

	customer = SearchCustomer3(customerId);
	if(customer!=null) {
		//System.out.println("update acc called .......2");
		pst=null;
		pst = connection.prepareStatement("UPDATE customer  SET Contact= ?  Where Id = ? ");
		pst.setString(2, customerId);
		pst.setString(1, customerContact);
		int res = pst.executeUpdate();
		if (res == 1) {
			System.out.println("update it into database y\\n");
			ch = sc.next();
			if (ch.equalsIgnoreCase("y")) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
				return false;
			}
		}
	}
	return false;
}
public Customer SearchCustomer3(String customerId) throws SQLException {
	
	pst = connection.prepareStatement("select * from customer where Id=?");
	pst.setString(1, customerId);
	rs = null;
	rs = pst.executeQuery();

	if (rs.next()) {
		
		customer = null;
		customer = new Customer();
		customer.setCustomerId(rs.getString(1));
		customer.setCustomerContact(rs.getString(2));
	}  
	return customer;
}


}


