package com.capgemini.bankmgt.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.bankmgt.dao.CustomerDao;
import com.capgemini.bankmgt.dao.CustomerDaoImpl;
import com.capgemini.bankmgt.dto.Customer;
import com.capgemini.bankmgt.exception.InvalidCustomerException;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao CustomerDao;
	HashMap<String, Customer> hashMap=new HashMap<>();
	Customer customer = null;
	Scanner scanner = new Scanner(System.in);

	String customerId;
	String customerName;
	String customerAddress;
	String customerAadhar;
	String customerPan;
	String customerContact;
	String customerGender;

	public CustomerServiceImpl() throws SQLException {
		CustomerDao = new CustomerDaoImpl();
	}

	@Override
	public void insertCustomer() throws SQLException, InvalidCustomerException {

		System.out.println("Enter customer data");
		System.out.println("Enter id");
		customer = null;
		customer = new Customer();
		customerId = scanner.next();
		if (customerId.length() <= 0)
			throw new InvalidCustomerException("invalid customer id<0");
		else
			customer.setCustomerId(customerId);

		System.out.println("Enter Name Of 5 or more chars");
		scanner.nextLine();
		customerName = scanner.nextLine();
		if (customerName.isEmpty())
			throw new InvalidCustomerException("customer name is empty");
		else if (customerName.length() < 5)
			throw new InvalidCustomerException("cutomer name length cannot be <5 chars");
		else
			customer.setCustomerName(customerName);

		System.out.println("Enter Address");
		customerAddress = scanner.nextLine();
		if (customerAddress.isEmpty())
			throw new InvalidCustomerException("invalid address");
		else
			customer.setCustomerAddress(customerAddress);

		System.out.println("Enter Aadhar number");
        
		customerAadhar = scanner.next();
		if (customerAadhar.isEmpty())
			throw new InvalidCustomerException("aadhar is empty");

		else
			customer.setCustomerAadhar(customerAadhar);
		System.out.println("Enter pan");

		customerPan = scanner.next();
		if (customerPan.isEmpty())
			throw new InvalidCustomerException("pan is empty");

		else if (!customerPan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			throw new InvalidCustomerException("pan fomat is incorrect");
		}

		else
			customer.setCustomerPan(customerPan);
		System.out.println("Enter Contact");

		customerContact = scanner.next();
		if (customerContact.isEmpty())
			throw new InvalidCustomerException("Contact is empty");

		else
			customer.setCustomerContact(customerContact);
		System.out.println("Enter Gender");

		customerGender = scanner.next();
		if (customerGender.isEmpty())
			throw new InvalidCustomerException("Gender is empty");

		else
			customer.setCustomerGender(customerGender);

		if (CustomerDao.createAccount(customer))
			System.out.println("customer Added");
		else if(!CustomerDao.createAccount(customer))
			System.out.println("same aadhar no. customer exist");
		else
			System.out.println("Customer do not want to add data");
	}
	

	@Override
	public void deleteCustomer() throws SQLException,InvalidCustomerException {
		System.out.println("Enter customer id ");
		customerId=scanner.next();
		if (CustomerDao.deleteAccount(customerId))
			System.out.println("customer deleted");
		else 
			System.out.println("customer do not exist or id is wrong");

		
	}

	@Override
	public void updateContact() throws SQLException,InvalidCustomerException {
	    System.out.println("Enter customer Updated Contact Number ");
	    customer=null;
		customer=new Customer();
		customerContact=scanner.next();
		System.out.println("Enter customer id ");
		customerId=scanner.next();
		if (CustomerDao.updateAccount(customerId,customerContact))
			System.out.println("customer contact updated");
		else if(!CustomerDao.updateAccount(customerId,customerContact))
			System.out.println("customer do not exist");
		else
			System.out.println("Customer do not want to update number");
	
		
		
	}
	
	
}
