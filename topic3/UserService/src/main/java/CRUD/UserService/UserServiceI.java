package CRUD.UserService;


public interface UserServiceI{
	/* Create a new user and store it in a mock db 
	 * name  -- user name
	 * dob   -- user date of birth
	 * email -- user email
	 * return the user.
	 * */
	public User createUser(String name, String dob, String email);
	
	/* Get information about the user, read from the mock database
	 * user -- the user
	 * return a string with the information
	 *  */
	public String readUser(User user);
	
	/* Update a User and store it in the mock db
	 * user    -- the user id that will be updating
	 * field   -- the field that I want to update
	 * newdata -- the new data
	 * */
	public void updateUser(int userid, String field, String newdata);
	
	/* Remove the user from the mock db
	 * user -- the user that I want to delete.
	 * */
	public void deleteUser(User user);
	
	/* Return amount of user
	 * */
	public int AmountofUser();
	
	/*id -- user id
	 * return user that contain the id given*/
	public User getUserFromid(int id);
}
