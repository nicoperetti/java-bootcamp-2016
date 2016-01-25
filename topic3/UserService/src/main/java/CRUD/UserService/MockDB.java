package CRUD.UserService;

public class MockDB {

	public static void storeuser(User user) {
		System.out.println("Store new user in database mock");
	}

	public static void deleteuser(User user) {
		System.out.println("Delete user from mock database");
	}

	public static void updateuser() {
		System.out.println("Update user from mock database");
	}

}
