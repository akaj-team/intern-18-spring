package vn.asiantech.internship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vn.asiantech.internship.R;

public class Friend {
    private String mName;
    private int mNumberOfFriend;
    private boolean mIsFriend;
    private int mAvatar;

    public int getAvatar() {
        return mAvatar;
    }

    private void setAvatar(int avatar) {
        this.mAvatar = avatar;
    }

    public boolean isFriend() {
        return mIsFriend;
    }

    public void setFriend(boolean friend) {
        mIsFriend = friend;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getNumberOfFriend() {
        return mNumberOfFriend;
    }

    private void setNumberOfFriend(int numberOfFriend) {
        this.mNumberOfFriend = numberOfFriend;
    }

    public static List<Friend> createListFriend(int sum, boolean isFriend) {
        List<Friend> listFriend = new ArrayList<>();
        for (int i = 1; i <= sum; i++) {
            Friend friend = new Friend();
            Random random = new Random();
            int position = random.nextInt(4);
            List<Integer> listAvatar = new ArrayList<>();
            List<String> listName = new ArrayList<>();
            listAvatar.add(R.drawable.ducnguyen);
            listAvatar.add(R.drawable.phucnguyen);
            listAvatar.add(R.drawable.hiendao);
            listAvatar.add(R.drawable.huynguyen);
            listName.add("Duc Nguyen");
            listName.add("Phuc Nguyen");
            listName.add("Hien Dao");
            listName.add("Huy Nguyen");
            friend.setName(listName.get(position) + " " + i);
            friend.setNumberOfFriend(i * 2);
            friend.setFriend(isFriend);
            friend.setAvatar(listAvatar.get(position));
            listFriend.add(friend);
        }
        return listFriend;
    }
}
