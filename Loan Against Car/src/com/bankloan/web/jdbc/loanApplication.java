package com.bankloan.web.jdbc;

public class loanApplication {
	/*This is the class which contains the fields entered by the registered user in the loan application form along with the getters and setters*/
	String loan_id;
	String loan_account;
	String loan_time;
	String loan_amount;
	String loan_type;
	String loan_status;
	String loan_car;
	String loan_manufacturer;
	String loan_insurance;
	String loan_salary;
	String loan_dom;
	String fname,lname,email,phone,address;
	public loanApplication(String loan_id, String loan_account, String loan_time, String loan_amount, String loan_type, String loan_status,
			String loan_car, String loan_manufacturer,String loan_insurance,String loan_salary,String loan_dom,String fname,String lname,String email,String phone,String address) {
		super();
		this.loan_id = loan_id;
		this.loan_account = loan_account;
		this.loan_time = loan_time;
		this.loan_amount = loan_amount;
		this.loan_type = loan_type;
		this.loan_status = loan_status;
		this.loan_car = loan_car;
		this.loan_manufacturer = loan_manufacturer;
		this.loan_insurance = loan_insurance;
		this.loan_salary = loan_salary;
		this.loan_dom = loan_dom;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public loanApplication(String loan_id) {
		super();
		this.loan_id = loan_id;
	}

	public String getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
	
	public String getLoanAccount() {
		return loan_account;
	}
	public void setLoanAccount(String loan_account) {
		this.loan_account = loan_account;
	}
	
	
	public String getTime() {
		return loan_time;
	}
	public void setTime(String loan_time) {
		this.loan_time = loan_time;
	}
	public String getAmount() {
		return loan_amount;
	}
	public void setAmount(String loan_amount) {
		this.loan_amount = loan_amount;
	}
	public String getType() {
		return loan_type;
	}
	public void setType(String loan_type) {
		this.loan_type = loan_type;
	}
	public String getStatus() {
		return loan_status;
	}
	public void setStatus(String loan_status) {
		this.loan_status = loan_status;
	}
	public String getCar() {
		return loan_car;
	}
	public void setCar(String loan_car) {
		this.loan_car = loan_car;
	}
	public String getManufacturer() {
		return loan_manufacturer;
	}
	public void setManufacturer(String loan_manufacturer) {
		this.loan_manufacturer = loan_manufacturer;
	}
	public String getInsurance() {
		return loan_insurance;
	}
	public void setInsurance(String loan_insurance) {
		this.loan_insurance = loan_insurance;
	}
	public String getSalary() {
		return loan_salary;
	}
	public void setSalary(String loan_salary) {
		this.loan_salary = loan_salary;
	}	
	public String getDOM() {
		return loan_dom;
	}
	public void setDOM(String loan_dom) {
		this.loan_dom = loan_dom;
	}	

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}
	public void setAdress(String address) {
		this.address = address;
	}
}
