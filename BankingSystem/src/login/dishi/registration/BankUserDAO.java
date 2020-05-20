package login.dishi.registration;

public interface BankUserDAO {

	public int insertuser(Bankuser b);
	public Bankuser getuser(String username,String pass);
}
