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
    public String addUser(String username, String pass, String lastname, String nickname) {
        String result = "ok!";
        if (this.userRepository.exists(username)) {
            result = "You must change the username. Try again!";
        }
        else {
            User newuser = new User(username, pass, lastname, nickname);
            this.userRepository.save(newuser);
        }
        return result;
    }

    public boolean validUsername(String username) {
        boolean result = false;
        if (this.userRepository.exists(username)) {
            result = true;
        }
        return result;
    }

    public boolean isLogged(String username) {
        return this.userRepository.findOne(username).getlogin();
    }

    @Override
    public String updateUser(String username, String lastname, String nickname) {
        User user = this.userRepository.findOne(username);
        String result = "update ";
        if (!lastname.equals("")) {
            result += "lastname ";
            user.setLastName(lastname);
        }
        if (!nickname.equals("")) {
            result += ", nickname";
            user.setNickName(nickname);
        }
        this.userRepository.save(user);
        return result;
    }

    @Override
    public String deleteUser(String username) {
        this.userRepository.delete(username);
        return "Deleting user";
    }

    public String login(String username, String password) {
        String result = "Incorrect password for the given username";
        User user = this.userRepository.findOne(username);
        if(user.correctpass(password)) {
            result = "Ok!";
            user.setlogin();
            this.userRepository.save(user);
        }
        return result;
    }

    public String logout(String username) {
        String result = "Logout";
        User user = this.userRepository.findOne(username);
        user.logout();
        this.userRepository.save(user);
        return result;
    }

    @Override
    public List<User> showUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUserByLastName(String lastname) {
        return userRepository.findByLastName(lastname);
    }

    @Override
    public List<User> findUserByNickName(String nickname) {
        return userRepository.findByNickName(nickname);
    }
}
