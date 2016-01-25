package JDBC.JDBCMySQL;

import java.sql.*;

public class DBManager {
	// JDBC driver name and database URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/highschool";
	
	//  Database credentials
   private static final String USER = "nico";
   private static final String PASS = "nicope";
   
   private Connection conn = null;
   private Statement stmt = null;
   
   public DBManager(){
	   try {
		   //Register JDBC driver
		   Class.forName(JDBC_DRIVER);
		   
		   //Open a connection
		   System.out.println("Connecting to database...");
		   conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   
		   System.out.println("Creating statement...");
		   stmt = conn.createStatement();
		   
	   } catch (Exception e){
		   System.out.println("error...");
	   }
   }
   
   public void DBQuery_showCourse() {
	   try {
		   int id_course = 0, assigned_teacher = 0, hours_by_week = 0;
		   String name = null;
		   // Execute a query
		   String query = "select * from course";
		   ResultSet rs = stmt.executeQuery(query);
		   //Extract data from result set
		   while(rs.next()){
			   id_course  = rs.getInt("id_course");
			   name = rs.getString("name");
			   assigned_teacher = rs.getInt("assigned_teacher");
			   hours_by_week = rs.getInt("hours_by_week");
			   System.out.print("id_course: " + id_course);
			   System.out.print(", name: " + name);
			   System.out.print(", assigned_teacher: " + assigned_teacher);
			   System.out.println(", hours_by_week: " + hours_by_week);
		   }
		   // close rs
		   rs.close();

	   } catch (Exception e){
		   System.out.println("error...");
	   }
   }
   public void DBQuery_five() {
	   try {
		   int hour_end = 0, hour_begin = 0, i = 0;
		   String last_name = null,first_name = null, course_name = null, day = null;
		   // Execute a query
		   String select = "select last_name, first_name, day, hour_begin, hour_end, name "; 
		   String from = "from teacher join course on teacher.id_teacher=course.assigned_teacher join schedule_time on schedule_time.id_course=course.id_course ";
		   String where =  "where teacher.last_name='Gonzales' and teacher.first_name='Roberto'";
		   String query = select + from + where;
		   ResultSet rs = stmt.executeQuery(query);
		   //Extract data from result set
		   while(rs.next()){
			   hour_begin  = rs.getInt("hour_begin");
			   hour_end = rs.getInt("hour_end");
			   day = rs.getString("day");
			   course_name = rs.getString("name");
			   if (i == 0) {
				   i += 1;
				   last_name = rs.getString("last_name");
				   first_name = rs.getString("first_name");
				   System.out.print("Teacher: " + last_name +", " +first_name+"\n");
				   System.out.print("Schedule: \n");
			   }
			   System.out.print("     "+day+" " + hour_begin+" - "+ hour_end+": "+course_name+"\n");
		   }
		   // close rs
		   rs.close();

	   } catch (Exception e){
		   System.out.println("error...");
	   }
	   
   }
   
   public void DBManagerclose() {
	   try{
		   System.out.println("closing statement...");
		   stmt.close();
		   System.out.println("closing connection...");
		   conn.close();
	   } catch (Exception e) {
		   System.out.println("error...");
	   }
   }

}
