package practice3;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String userName;
    private String lastName;
    private String nickName;

    protected User() {}

    public User(String username, String name, String nickname) {
        this.userName = username;
        this.lastName = name;
        this.nickName = nickname;
    }

    @Override
    public String toString() {
        return String.format(
                "User[username=%s, name='%s', nickname='%s']",
                userName, lastName, nickName);
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setNickName(String nickname) {
        this.nickName = nickname;
    }
}
