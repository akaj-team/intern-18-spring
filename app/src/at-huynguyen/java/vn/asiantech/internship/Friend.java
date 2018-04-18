package vn.asiantech.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Friend {
    private String mName;
    private int mNumberOfFriend;
    private int mAvatar;
    private boolean mIsFriend;

    public String getName() {
        return mName;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

    public int getNumberOfFriend() {
        return mNumberOfFriend;
    }

    private void setNumberOfFriend(int NumberOfFriend) {
        this.mNumberOfFriend = NumberOfFriend;
    }

    public int getAvatar() {
        return mAvatar;
    }

    private void setAvatar(int Avatar) {
        this.mAvatar = Avatar;
    }

    public boolean isFriend() {
        return mIsFriend;
    }

    public void setFriend(boolean friend) {
        this.mIsFriend = friend;
    }

    public static List<Friend> createListFriend() {
        List<Friend> listFriend = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Friend friend = new Friend();
            Random random = new Random();
            int position = random.nextInt(3);
            List<Integer> listAvatar = new ArrayList<>();
            listAvatar.add(R.drawable.img_duc);
            listAvatar.add(R.drawable.img_phuc);
            listAvatar.add(R.drawable.img_hien);
            List<String> listName = new ArrayList<>();
            listName.add("Duc Nguyen");
            listName.add("Phuc Nguyen");
            listName.add("Hien Dao");
            friend.setName(listName.get(position) + " " + i);
            friend.setNumberOfFriend(i * 5);
            friend.setFriend(i % 3 == 0);
            friend.setAvatar(listAvatar.get(position));
            listFriend.add(friend);
        }
        return listFriend;
    }
}
