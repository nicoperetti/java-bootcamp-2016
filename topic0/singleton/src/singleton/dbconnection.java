package singleton;

public class dbconnection {
	private static dbconnection con;

	private dbconnection(){
	}
	
	public static dbconnection getIntance(){
		if (con == null) {
			con = new dbconnection();
			System.out.println("new db connection...");
		}
		return con;
	}
	
	public void sayHello() {
		System.out.println("Hello");
	}
}
