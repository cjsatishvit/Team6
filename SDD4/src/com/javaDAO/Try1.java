package com.javaDAO;

import java.sql.*;
import java.util.ArrayList;

import com.java.dao.SiteEvaluator;

public class Try1
{
	
    public ArrayList<SiteEvaluator> share() throws Exception
    {
    	ArrayList<SiteEvaluator> empRecSet = new ArrayList<SiteEvaluator>();
        
        String url = "jdbc:mysql://localhost:3306/sdd";
        String uname = "root";
        String pass = "rik12345";
        String query = "select * from SiteEval";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
            SiteEvaluator se = new SiteEvaluator();
            
            se.setEmpId(rs.getInt(1));
            se.setEmpName(rs.getString(2));
            se.setEmpPass(rs.getString(3));
            
            empRecSet.add(se);
        }
        
        st.close();
        con.close();
        
        return empRecSet;
    }
}
