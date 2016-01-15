package proxy;

public class dbAccessProxyDemo {
	
	public static void main(String[] args) {
		
		SlowdbProxy slowdbp = new SlowdbProxy();
		FastdbAccess fastdba = new FastdbAccess();
		fastdba.getdbaccess();
		slowdbp.getdbaccess();
	}
}
