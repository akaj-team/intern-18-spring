package vn.asiantech.internship.model;

public class Friend {
    private String nameFriend;
    private int countFriend;
    private int urlImage;

    public Friend(String nameFriend, int countFriend, int urlImage) {
        this.nameFriend = nameFriend;
        this.countFriend = countFriend;
        this.urlImage = urlImage;
    }

    public String getNameFriend() {
        return nameFriend;
    }

    public void setNameFriend(String nameFriend) {
        this.nameFriend = nameFriend;
    }

    public int getCountFriend() {
        return countFriend;
    }

    public void setCountFriend(int countFriend) {
        this.countFriend = countFriend;
    }

    public int getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(int urlImage) {
        this.urlImage = urlImage;
    }
}
