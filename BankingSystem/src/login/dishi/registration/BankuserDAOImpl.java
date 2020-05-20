package login.dishi.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankuserDAOImpl implements BankUserDAO {

	static Connection con;
	static PreparedStatement ps;
	@Override
	public int insertuser(Bankuser b) {
		int status=0;
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("insert into bankuser values(?,?)");
			ps.setString(1, b.getUsername());
			ps.setString(2, b.getPassword());
			ps.setString(3, b.getName());
			status=ps.executeUpdate();
			con.close();
			}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Bankuser getuser(String userid, String pass) {
		Bankuser b = new Bankuser();
		
		try {
			con=ConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from bankuser where userid=? and password=?");
			ps.setString(1, userid);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b.setUsername(rs.getString(1));
				b.setPassword(rs.getString(2));
				b.setName(rs.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
