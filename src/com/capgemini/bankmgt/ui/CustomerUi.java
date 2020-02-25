package com.capgemini.bankmgt.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.bankmgt.exception.InvalidCustomerException;
import com.capgemini.bankmgt.service.CustomerService;
import com.capgemini.bankmgt.service.CustomerServiceImpl;

public class CustomerUi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String ch = "yes";

		CustomerService service = null;

		try {
			service = new CustomerServiceImpl();
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println(e1.getMessage());
		}
		
		
		while(ch.equalsIgnoreCase("yes")) {
			System.out.println("-------Select Operation------");
			System.out.println("1.Create Account");
			System.out.println("2.Delete Account");
			System.out.println("3.Update Account Contact no.");

			int op = scanner.nextInt();

			switch (op) {
			case 1:
				try {
					service.insertCustomer();
				} catch (SQLException | InvalidCustomerException e1) {
					System.err.println(e1.getMessage());
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					service.deleteCustomer();
				} catch (SQLException |InvalidCustomerException e1) {
					System.err.println(e1.getMessage());
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					service.updateContact();
				} catch (SQLException | InvalidCustomerException e1) {
					System.err.println(e1.getMessage());
					e1.printStackTrace();
				}
				break;	
				

			default:
				break;
			}
		
		
				
			System.out.println("Continue yes\\no");
			ch = scanner.next();
		}
		System.out.println("-----------------------------Thank You-----------------------------");
		

	}
}
