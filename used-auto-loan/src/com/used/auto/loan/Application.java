package com.used.auto.loan;

import java.io.File;

import com.mysql.cj.jdbc.Blob;

public class Application 
{
	String fname, lname, at, da, sl; 
	int id,ra;
	Blob f;
    
	


	public Application(String fname, String lname, String at, String da, String sl, int id, int ra) {
		
		this.fname = fname;
		this.lname = lname;
		this.at = at;
		this.da = da;
		this.sl = sl;
		this.id = id;
		this.ra = ra;
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


	public String getAt() {
		return at;
	}


	public void setAt(String at) {
		this.at = at;
	}


	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
	}


	public String getDa() {
		return da;
	}


	public void setDa(String da) {
		this.da = da;
	}


	public String getSl() {
		return sl;
	}


	public void setSl(String sl) {
		this.sl = sl;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	@Override
	public String toString() {
		return "Application [id="+id+", firstname="+fname+", lastname="+lname+",at="+at+", ra="+ra+", da="+da+", sl="+sl+", file= "+f+"]";
	}
	
	

}
