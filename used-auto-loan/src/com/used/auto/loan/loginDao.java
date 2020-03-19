package com.used.auto.loan;
import java.sql.*;
public class loginDao 
//jdbc:mysql://localhost:3306/?user=root
{
	String sql = "select * from used_auto_loan.customer where Username=? and PasswordUser=? ;";
	String url = "jdbc:mysql://localhost:3306/?user=root";
	String username = "root";
	String password = "sou19999";
	public boolean check(String uname, String pass)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		}
		catch (Exception exc)
		{
			
		}
		return false;
	}	

}
