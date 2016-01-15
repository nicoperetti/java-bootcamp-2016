package proxy;

import java.util.Date;

public class SlowdbProxy {
	
	SlowdbAccess slowdba;
	
	public SlowdbProxy() {
		System.out.println("Creating SlowProxy at " + new Date());
	}
	
	public void getdbaccess() {
		if (slowdba == null) {
			slowdba = new SlowdbAccess();
		}
		slowdba.getdbaccess();
	}
}
