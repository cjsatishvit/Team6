package com.bankloan.web.jdbc;

public class userinfo {
	
	private String fname,lname,gender;
	private String pass;
	private String email,phone;
	private String dob;
	private String customerID;//account
	private String address ;
	
	public userinfo(String customerID) {
		super();
		this.customerID = customerID;
	}
	
	public userinfo(String customerID,String pass) {
		super();
		this.customerID = customerID;
		this.pass = pass;
	}
	
	
	public userinfo(String fname, String lname,String gender ,String pass,String phone,String email,String customerID,String dob,String address)
	{
		super();
		this.fname = fname ;
		this.lname = lname;
		this.pass = pass;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.customerID = customerID;
		this.address = address;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	public String getPass() {
		return pass;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getDOB() {
		return dob;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDOB(String dob) {
		this.dob = dob;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
