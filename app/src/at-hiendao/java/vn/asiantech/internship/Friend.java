package vn.asiantech.internship;

import android.graphics.Color;
import android.util.Log;

import java.util.Random;

public class Friend {
    public final String Name;
    public final int MutualFriends;
    public final int Avatar;

    Friend(String name, int mutualFriends)
    {

        Name = name;
        MutualFriends = mutualFriends;
        Random random = new Random();
        int valueColor = random.nextInt(4);
        switch (valueColor)
        {
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
