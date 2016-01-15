
public class oracleConnectionBuilder implements ConnectionBuilder{
	
	private Connection conn;

	public oracleConnectionBuilder() {
		conn = new Connection();
	}
	
	@Override
	public void buildConnection() {
		conn.setConnection("oracle");
	}
	
	@Override
	public Connection getConnection(){
		return conn;
	} 
}
