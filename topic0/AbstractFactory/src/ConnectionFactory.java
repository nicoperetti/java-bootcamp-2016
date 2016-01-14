
public class ConnectionFactory {

	public Connection getConnection(String conn){
		if ("sql".equals(conn)) {
			return new sql();
		}
		else if ("oracle".equals(conn)){
			return new oracle();
		}
		else {
			return new mongodb();
		}
	} 
}
