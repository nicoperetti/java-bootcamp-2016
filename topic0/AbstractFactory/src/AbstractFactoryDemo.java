
public class AbstractFactoryDemo {
	public static void main(String[] args) {
		AbstractFactory absf = new AbstractFactory();
		ConnectionFactory cf = absf.getConnectionFactory("Connection");
		Connection conn1 = cf.getConnection("sql");
		conn1.state();
		Connection conn2 = cf.getConnection("oracle");
		conn2.state();
		Connection conn3 = cf.getConnection("mongodb");
		conn3.state();
	}
}
