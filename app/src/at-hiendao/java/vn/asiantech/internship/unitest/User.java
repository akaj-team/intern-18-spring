package vn.asiantech.internship.unitest;

public class User {
    private String userName;
    private String password;

    User(String userName, String password) {
        this.password = userName;
        this.userName = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
