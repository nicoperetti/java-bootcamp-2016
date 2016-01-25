package JDBC.JDBCMySQL;

import org.junit.Test;

public class DBManagerTest {

	@Test
	public void testshowquery(){
		DBManager dbm = new DBManager();
		dbm.DBQuery_showCourse();
		dbm.DBManagerclose();
	}
	
	@Test
	public void testexcercisefive() {
		DBManager dbm = new DBManager();
		dbm.DBQuery_five();
		dbm.DBManagerclose();
	}
}
