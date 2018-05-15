package vn.asiantech.internship.unitest;

public class User {
    private String mUserName;
    private String mPassword;

    User(String mUserName, String mPassword) {
        this.mPassword = mPassword;
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getUserName() {
        return mUserName;
    }
}
