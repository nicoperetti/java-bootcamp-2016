package practice3;

import java.util.*;

public interface UserService {

    String addUser(String username, String lastname, String nickname);

    String updateUser(String username, String lastname, String nickname);

    String deleteUser(String username);

    List<String> showUser();

    List<String> findUserByLastName(String lastname);

    List<String> findUserByNickName(String nickname);
}
