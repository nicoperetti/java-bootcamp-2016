package CRUD.UserService;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserServiceTest {
  
	@Test
	public void testcreateuser(){
		UserServiceI us = new UserService();
		User user = us.createUser("Nico", "1994","nicoperetti.16@gmail.com");
		assertEquals(us.AmountofUser(), 1);
	}
	
	@Test
	public void testreaduser() {
		UserServiceI us = new UserService();
		User user = us.createUser("Nico", "1994","nicoperetti.16@gmail.com");
		assertEquals(us.AmountofUser(), 1);
		System.out.println(us.readUser(user));
	}
	
	@Test
	public void testdeleteuser() {
		UserServiceI us = new UserService();
		User user = us.createUser("Nico", "1994","nicoperetti.16@gmail.com");
		assertEquals(us.AmountofUser(), 1);
		System.out.println(us.readUser(user));
		us.deleteUser(user);
		assertEquals(us.AmountofUser(), 0);
	}
	
	@Test
	public void testupdatedateofbirth() {
		UserServiceI us = new UserService();
		User user = us.createUser("Nico", "1993","nicoperetti.16@gmail.com");
		assertEquals(us.AmountofUser(), 1);
		System.out.println(us.readUser(user));
		us.updateUser(0, "dob", "1994");
		System.out.println(us.readUser(user));
		assertEquals(us.AmountofUser(), 1);
	}
}
