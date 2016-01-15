
public class ConnectionDirector {

		ConnectionBuilder cb;
		
		public ConnectionDirector(ConnectionBuilder connb) {
			this.cb = connb;
		}
		
		public void constructConnection() {
			cb.buildConnection();
		}
		
		public Connection getConnection() {
			return cb.getConnection();	
		}
}
