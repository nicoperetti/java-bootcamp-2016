package practice3;

import java.util.*;

public interface UserService {

    String addUser(String username, String pass, String lastname, String nickname);

    String updateUser(String username, String lastname, String nickname);

    String deleteUser(String username);

    boolean isLogged(String username);

    boolean validUsername(String username);

    String login(String username, String password);

    String logout(String username);

    List<User> showUser();

    List<User> findUserByLastName(String lastname);

    List<User> findUserByNickName(String nickname);
}
