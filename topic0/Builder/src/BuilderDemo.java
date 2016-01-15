
public class BuilderDemo {
	
	public static void main(String[] args) {
	
		ConnectionBuilder cb = new sqlConnectionBuilder();
		ConnectionDirector cd = new ConnectionDirector(cb);
		cd.constructConnection();
		Connection conn = cd.getConnection();
		conn.getConnection();
		
		cb = new oracleConnectionBuilder();
		cd = new ConnectionDirector(cb);
		cd.constructConnection();
		conn = cd.getConnection();
		conn.getConnection();

		cb = new mongodbConnectionBuilder();
		cd = new ConnectionDirector(cb);
		cd.constructConnection();
		conn = cd.getConnection();
		conn.getConnection();

	}
}
