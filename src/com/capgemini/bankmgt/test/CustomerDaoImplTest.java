package com.capgemini.bankmgt.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.bankmgt.dao.CustomerDao;
import com.capgemini.bankmgt.dao.CustomerDaoImpl;
import com.capgemini.bankmgt.dto.Customer;

public class CustomerDaoImplTest {
CustomerDao dao;
	@Before
	public void setUp() throws Exception {
	dao=new CustomerDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	dao=null;
	}
	
	@Test
	public void testSearchCustomer2() throws SQLException {
		assertNotNull(dao.SearchCustomer2("150"));
	}
	@Test
	public void testDeleteAccount() throws SQLException {
		assertTrue(dao.deleteAccount("150"));
		
	}
	
	
	




}
