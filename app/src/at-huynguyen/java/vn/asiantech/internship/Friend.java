package vn.asiantech.internship;

public class Friend {
    private String mName;
    private int mNumberOfFriend;
    private int mAvatar;

    public Friend(String mName, int mNumberOfFriend, int mAvatar)   {
        this.mName = mName;
        this.mNumberOfFriend = mNumberOfFriend;
        this.mAvatar = mAvatar;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmNumberOfFriend() {
        return mNumberOfFriend;
    }

    public void setmNumberOfFriend(int mNumberOfFriend) {
        this.mNumberOfFriend = mNumberOfFriend;
    }

    public int getmAvatar() {
        return mAvatar;
    }

    public void setAvatar(int mAvatar) {
        this.mAvatar = mAvatar;
    }
}
