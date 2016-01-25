package CRUD.UserService;

import java.util.*;

public class UserService implements UserServiceI{

	private HashMap<Integer,User> usermap;
	private int id;
	
	public UserService(){
		usermap = new HashMap<Integer,User>();
		id = 0;
	}
	
	@Override
	public User createUser(String name, String dob, String email) {
		User user = new User(id);
		user.setname(name);
		user.setdob(dob);
		user.setemail(email);
		// Store in memory data
		usermap.put(id, user);
		id += 1;
		// Store in mock database
		MockDB.storeuser(user);
		return user;
	}

	@Override
	public String readUser(User user) {
		return user.toString();
	}

	@Override
	public void updateUser(int id, String field, String newdata) {
		User user = usermap.get(id);
		if (field.equals("name")){
			user.setname(newdata);
		}
		else if (field.equals("email")){
			user.setemail(newdata);
		}
		else if (field.equals("dob")){
			user.setdob(newdata);
		}
		else {
			System.out.println("incorrect field");
		}
		MockDB.updateuser();
	}

	@Override
	public void deleteUser(User user) {
		int key = user.getid();
		if (usermap.containsKey(key)){
			usermap.remove(key);
			MockDB.deleteuser(user);
		}
	}

	@Override
	public int AmountofUser() {
		return usermap.size();
	}

	@Override
	public User getUserFromid(int id) {
		return usermap.get(id);
	}
}
