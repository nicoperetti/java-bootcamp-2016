package singleton;

public class dbconnectionDemo {
	public static void main(String[] args) {
		dbconnection dbc = dbconnection.getIntance();
		dbc.sayHello();
		dbconnection dbc2 = dbconnection.getIntance();
		dbc2.sayHello();
	}
}
