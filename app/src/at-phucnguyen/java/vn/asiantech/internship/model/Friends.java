package vn.asiantech.internship.model;

public class Friends {
    private String mNameFriend;
    private int mCountFriend;
    private int mUrlImage;

    public Friends(String mNameFriend, int mCountFriend, int mUrlImage) {
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

    public int getmUrlImage() {
        return mUrlImage;
    }

    public void setmUrlImage(int mUrlImage) {
        this.mUrlImage = mUrlImage;
    }
}
