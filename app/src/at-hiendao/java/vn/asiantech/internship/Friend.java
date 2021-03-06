package vn.asiantech.internship;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;

class Friend {
    private final String mName;
    private final int mNumOfMutualFriends;
    private final int mAvatar;
    private boolean mIsFriend;

    Friend(String name, int mutualFriends, boolean isfriend) {

        mName = name;
        mNumOfMutualFriends = mutualFriends;
        Random random = new Random();
        mIsFriend = isfriend;
        int valueColor = random.nextInt(4);
        switch (valueColor) {
            case 0:
                mAvatar = Color.RED;
                break;

            case 1:
                mAvatar = Color.BLUE;
                break;

            case 2:
                mAvatar = Color.GREEN;
                break;

            case 3:
                mAvatar = Color.GRAY;
                break;

            default:
                Log.e("wrong color", "wrong color");
                mAvatar = Color.BLACK;
                break;
        }
    }

    public String getName() {
        return mName;
    }

    public int getNumOfMutualFriends() {
        return mNumOfMutualFriends;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public boolean isFriend() {
        return mIsFriend;
    }

    public void setIsFriend(boolean isFriend) {
        mIsFriend = isFriend;
    }
}
