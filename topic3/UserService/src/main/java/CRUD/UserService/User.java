package CRUD.UserService;

public class User {

	private String name;
	private String dob;
	private String email;
	private int id;
	
	public User(int id) {
		this.id = id;
	}
	
	public void setname(String n){
		name = n;
	}
	
	public void setdob(String date_of_birth) {
		dob = date_of_birth;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "name: " +name+", email: "+email+", date of birth: "+dob;
		
	}

	public int getid() {
		return id;
	}
}
