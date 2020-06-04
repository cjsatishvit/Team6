package com.bankloan.web.jdbc;

public class loanofficer {
	String ID;
	String password;
	String post;
	public loanofficer(String iD, String password, String post) {
		super();
		this.ID = iD;
		this.password = password;
		this.post = post;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

}