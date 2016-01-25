package CRUD.UserService;


public interface UserServiceI{

	public User createUser(String name, String dob, String email);
	
	public String readUser(User user);
	
	public void updateUser(User user, String field, String newdata);
	
	public void deleteUser(User user);
}
