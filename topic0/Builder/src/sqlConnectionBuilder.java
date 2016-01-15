
public class sqlConnectionBuilder implements ConnectionBuilder{
	
	private Connection conn;
	
	public sqlConnectionBuilder() {
		conn = new Connection();
	}
	
	@Override
	public void buildConnection() {
		conn.setConnection("sql");
	}
	
	@Override
	public Connection getConnection(){
		return conn;
	} 
}
