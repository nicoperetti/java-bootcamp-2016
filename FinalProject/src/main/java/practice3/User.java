package practice3;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String userName;
    private String pass;
    private boolean login;
    private String lastName;
    private String nickName;

    protected User() {}

    public User(String username, String password, String name, String nickname) {
        this.userName = username;
        this.pass = password;
        this.lastName = name;
        this.nickName = nickname;
        this.login = false;
    }

    @Override
    public String toString() {
        return String.format(
                "User[username=%s, pass=%s, name='%s', nickname='%s']",
                userName, pass, lastName, nickName);
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setNickName(String nickname) {
        this.nickName = nickname;
    }

    public boolean correctpass(String password) {
        boolean result = false;
        if (this.pass.equals(password)) {
            result = true;
        }
        return result;
    }

    public void setlogin() {
        this.login = true;
    }

    public boolean getlogin() {
        return this.login;
    }

    public void logout() {
        this.login = false;
    }

}
