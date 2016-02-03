package practice3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/adduser", method = RequestMethod.POST)
    public String adduser(@RequestParam(value="userName") String userName,
                        @RequestParam(value="password") String pass,
                        @RequestParam(value="lastName", defaultValue="Peretti") String lastName,
                        @RequestParam(value="nickName", defaultValue="Nico") String nickName) {
        return userService.addUser(userName, pass, lastName, nickName);
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
    public String updateuser(@PathVariable String username,
                        @RequestParam(value="lastName", defaultValue="") String lastName,
                        @RequestParam(value="nickName", defaultValue="") String nickName) {
        return userService.updateUser(username, lastName, nickName);
    }

    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
    public String deleteuser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value="username", defaultValue="") String username,
                        @RequestParam(value="password", defaultValue="") String password) {
        return userService.login(username, password);
    }

    @RequestMapping(value = "/{username}/logout", method = RequestMethod.GET)
    public String login(@PathVariable String username) {
        return userService.logout(username);
    }

    @RequestMapping("/showuser")
    public List<String> showuser() {
        return userService.showUser();
    }

    @RequestMapping("/finduserbyname")
    public List<String> finduserbyname(@RequestParam(value="lastName", defaultValue="Peretti") String lastName) {
        return userService.findUserByLastName(lastName);
    }

    @RequestMapping("/finduserbynickname")
    public List<String> finduserbynickname(@RequestParam(value="nickName", defaultValue="Peretti") String nickName) {
        return userService.findUserByNickName(nickName);
    }
}
