
public class mongodbConnectionBuilder implements ConnectionBuilder{
	
	private Connection conn;
	
	public mongodbConnectionBuilder() {
		conn = new Connection();
	}
	
	@Override
	public void buildConnection() {
		conn.setConnection("mongoDB");
	}
	
	@Override
	public Connection getConnection(){
		return conn;
	} 

}
