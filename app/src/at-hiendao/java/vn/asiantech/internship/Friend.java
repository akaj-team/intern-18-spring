package vn.asiantech.internship;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

public class Friend {
    public final String Name;
    public final int MutualFriends;
    public final int Avatar;
    public boolean IsFriend;

    Friend(String name, int mutualFriends, boolean isFriend) {

        Name = name;
        MutualFriends = mutualFriends;
        IsFriend = isFriend;
        Random random = new Random();
        int valueColor = random.nextInt(4);
        switch (valueColor) {
            case 0:
                Avatar = Color.RED;
                break;

            case 1:
                Avatar = Color.BLUE;
                break;

            case 2:
                Avatar = Color.GREEN;
                break;

            case 3:
                Avatar = Color.GRAY;
                break;

            default:
                Log.e("wrong color", "wrong color");
                Avatar = Color.BLACK;
                break;
        }
    }
}
