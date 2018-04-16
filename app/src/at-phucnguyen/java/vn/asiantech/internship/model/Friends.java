package vn.asiantech.internship.model;

public class Friends {
    private String mNameFriend;
    private int mCountFriend;
    private int mUrlImage;
    private String mStatus;

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public Friends(String mNameFriend, int mCountFriend, int mUrlImage, String mStatus) {
        this.mNameFriend = mNameFriend;
        this.mCountFriend = mCountFriend;
        this.mUrlImage = mUrlImage;
        this.mStatus = mStatus;
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
