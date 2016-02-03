package practice3;

import java.util.*;

public interface UserService {

    String addUser(String username, String pass, String lastname, String nickname);

    String updateUser(String username, String lastname, String nickname);

    String deleteUser(String username);

    String login(String username, String password);

    String logout(String username);

    List<String> showUser();

    List<String> findUserByLastName(String lastname);

    List<String> findUserByNickName(String nickname);
}
