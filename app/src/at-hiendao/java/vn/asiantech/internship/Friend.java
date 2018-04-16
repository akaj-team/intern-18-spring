package vn.asiantech.internship;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;

class Friend {
    private final String mName;
    private final int mNumOfMutualFriends;
    private final int mAvatar;

    Friend(String name, int mutualFriends) {

        mName = name;
        mNumOfMutualFriends = mutualFriends;
        Random random = new Random();
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

    public String getmName() {
        return mName;
    }

    public int getmNumOfMutualFriends() {
        return mNumOfMutualFriends;
    }

    public int getmAvatar() {
        return mAvatar;
    }
}
