package vn.asiantech.internship.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Friend {
    private String mName;
    private int mNumberOfFriend;
    private boolean isFriend;

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
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

    public void setNumberOfFriend(int numberOfFriend) {
        this.mNumberOfFriend = numberOfFriend;
    }

    public List<Friend> createListFriend(int sum) {
        List<Friend> listFriend = new ArrayList();
        for (int i = 1; i <= sum; i++) {
            Friend friend = new Friend();
            friend.setName("Duc Nguyen " + i);
            friend.setNumberOfFriend(i * 2);
            friend.setFriend(i%4 == 0);
            listFriend.add(friend);
        }
        Log.d("AAA", "createListFriend: ");
        return listFriend;
    }
}
