package proxy;

import java.util.Date;

public abstract class dbaccess {
	
	public void getdbaccess() {
		System.out.println(this.getClass().getSimpleName() + " at " + new Date());
	}
}
