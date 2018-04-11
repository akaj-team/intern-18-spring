package vn.asiantech.internship.Model;

public class Friends {
    private String mNameFriend;
    private int mCountFriend;
    private String mUrlImage;

    public Friends(String mNameFriend, int mCountFriend, String mUrlImage) {
        this.mNameFriend = mNameFriend;
        this.mCountFriend = mCountFriend;
        this.mUrlImage = mUrlImage;
    }

    public String getmNameFriend() {
        return mNameFriend;
    }

    public void setmNameFriend(String mNameFriend) {
        this.mNameFriend = mNameFriend;
    }

    public int getmCountFriend() {
        return mCountFriend;
    }

    public void setmCountFriend(int mCountFriend) {
        this.mCountFriend = mCountFriend;
    }

    public String getmUrlImage() {
        return mUrlImage;
    }

    public void setmUrlImage(String mUrlImage) {
        this.mUrlImage = mUrlImage;
    }
}
