package com.capgemini.bankmgt.dto;

public class Customer {
   private String customerId;
   private String customerName;
   private String customerAddress;
   private String customerAadhar;
   private String customerPan;
   private String customerContact;
   private String customerGender;
  
public Customer(String customerId, String customerName, String customerAddress, String customerAadhar,
		String customerPan, String customerContact, String customerGender) {
	super();
	this.customerId = customerId;
	this.customerName = customerName;
	this.customerAddress = customerAddress;
	this.customerAadhar = customerAadhar;
	this.customerPan = customerPan;
	this.customerContact = customerContact;
	this.customerGender = customerGender;
	
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
			+ customerAddress + ", customerAadhar=" + customerAadhar + ", customerPan=" + customerPan
			+ ", customerContact=" + customerContact + ", customerGender=" + customerGender + "]";
}

public Customer() {
	// TODO Auto-generated constructor stub
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getCustomerAadhar() {
	return customerAadhar;
}


public void setCustomerAadhar(String customerAadhar) {
	this.customerAadhar = customerAadhar;
}
public String getCustomerPan() {
	return customerPan;
}
public void setCustomerPan(String customerPan) {
	this.customerPan = customerPan;
}
public String getCustomerContact() {
	return customerContact;
}
public void setCustomerContact(String customerContact) {
	this.customerContact = customerContact;
}
public String getCustomerGender() {
	return customerGender;
}
public void setCustomerGender(String customerGender) {
	this.customerGender = customerGender;
}

}
