package com.used.auto.loan;
import java.sql.*;
public class BankLoginDao 
//jdbc:mysql://localhost:3306/?user=root
{
	String sql = "select * from used_auto_loan.bank where Username=? and PasswordUser=? ;";
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
<<<<<<< HEAD
		catch (Exception e) 
		{
          e.printStackTrace();
      }
		
=======
		catch (Exception exc)
		{
			
		}
>>>>>>> branch 'master' of https://github.com/cjsatishvit/Team6.git
		return false;
	}	

}
