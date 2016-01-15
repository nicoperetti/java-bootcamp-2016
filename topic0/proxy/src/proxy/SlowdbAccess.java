package proxy;

public class SlowdbAccess extends dbaccess{
	
	public SlowdbAccess(){
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
