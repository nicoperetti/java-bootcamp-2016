package TDD.Blog;

import java.util.Date;

public class Entry {

	private String name;
	private Date date;
	private String opinion;
	
	public Entry(String name, String opinion){
		this.name = name;
		this.opinion = opinion;
		date = new Date();
	}
	
	public String toString() {
		return name +" told "+ opinion +" at " + date;
	}
}
