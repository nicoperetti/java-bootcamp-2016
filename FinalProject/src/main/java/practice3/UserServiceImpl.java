package practice3;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Component("userService")
@Transactional
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String addUser(String username, String lastname, String nickname) {
        String result = "ok!";
        if (this.userRepository.exists(username)) {
            result = "You must change the username. Try again!";
        }
        else {
            User newuser = new User(username, lastname, nickname);
            this.userRepository.save(newuser);
        }
        return result;
    }

    @Override
    public String updateUser(String username, String lastname, String nickname) {
        String result = "Invalid username!";
        if (this.userRepository.exists(username)) {
            User user = this.userRepository.findOne(username);
            result = "update ";
            if (lastname != "") {
                result += "lastname ";
                user.setLastName(lastname);
            }
            if (nickname != "") {
                result += ", nickname";
                user.setNickName(nickname);
            }
            this.userRepository.save(user);
        }
        return result;
    }

    @Override
    public String deleteUser(String username) {
        String result = "This username does not exist!";
        if (this.userRepository.exists(username)) {
            result = "Deleting user";
            this.userRepository.delete(username);
        }
        return result;
    }

    @Override
    public List<String> showUser() {
        List<String> userlist = new ArrayList<String>();
        for (User user: userRepository.findAll()) {
            userlist.add(user.toString());
        }
        return userlist;
    }

    @Override
    public List<String> findUserByLastName(String lastname) {
        List<String> result = new ArrayList<String>();
        List<User> userlist = new ArrayList<User>();
        userlist = userRepository.findByLastName(lastname);
        for (int i = 0; i < userlist.size();i++) {
            result.add(userlist.get(i).toString());
        }
        return result;
    }

    @Override
    public List<String> findUserByNickName(String nickname) {
        List<String> result = new ArrayList<String>();
        List<User> userlist = new ArrayList<User>();
        userlist = userRepository.findByNickName(nickname);
        for (int i = 0; i < userlist.size();i++) {
            result.add(userlist.get(i).toString());
        }
        return result;
    }
}
