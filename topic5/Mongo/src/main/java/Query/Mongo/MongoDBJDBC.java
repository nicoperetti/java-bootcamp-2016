package Query.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.*;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

public class MongoDBJDBC {
 
	private MongoClient mongoClient;
	private DB db;
	
	public MongoDBJDBC() {
		try{
			// To connect to mongodb server
	         mongoClient = new MongoClient( "localhost" , 27017 );
				
	         // Now connect to your databases
	         db = mongoClient.getDB( "highschool" );
	         System.out.println("Connect to database successfully");
	      }catch(Exception e){
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	}
	
	public void Practice2() {
		BasicDBObject note;
		BasicDBObject course_id;
		List<BasicDBObject> obj;
		List<Double> courselist = new ArrayList<Double>();
		DBCollection dBCollection = db.getCollection("course");
		BasicDBObject query = new BasicDBObject("name", "math");
		BasicDBObject fields = new BasicDBObject("_id",1);
		DBCursor cursor = dBCollection.find(query,fields);
		try {
		    while (cursor.hasNext()) {
		        courselist.add((Double) cursor.next().get("_id"));
		    }
		} finally {
		    cursor.close();
		}
		dBCollection = db.getCollection("student");
		note = new BasicDBObject("final",new BasicDBObject("$gt", 4));
		for(int i = 0; i < courselist.size(); i++) {
			obj = new ArrayList<BasicDBObject>();
			obj.add(note);
			course_id = new BasicDBObject("course_id", courselist.get(i));
			obj.add(course_id);
			query = new BasicDBObject("$and", obj);
			fields = new BasicDBObject("last_name",1);
			cursor = dBCollection.find(query,fields);
			try {
			    while (cursor.hasNext()) {
			    	System.out.println(cursor.next().get("last_name"));
			    }
			} finally {
			    cursor.close();
			}
		}
	}
	
	public void Practice3() {
		List<String> courselist = new ArrayList<String>();
		double id = 0;
		DBCollection dBCollection = db.getCollection("teacher");
		BasicDBObject query = new BasicDBObject("last_name", "rodriguez");
		BasicDBObject fields = new BasicDBObject("_id",1);
		DBCursor cursor = dBCollection.find(query,fields);
		try {
		    if (cursor.hasNext()) {
		    	id = (Double) cursor.next().get("_id");
		    }
		} finally {
		    cursor.close();
		}		
		dBCollection = db.getCollection("course");
		query = new BasicDBObject("teacher", id);
		fields = new BasicDBObject("name",1);
		cursor = dBCollection.find(query,fields);
		try {
			while(cursor.hasNext()) {
				courselist.add((String) cursor.next().get("name"));
			}
		} finally {
			cursor.close();
		}
		Collections.sort(courselist);
		for (int i = 0; i < courselist.size(); i++) {
			System.out.println(courselist.get(i));
		}
	}
}
