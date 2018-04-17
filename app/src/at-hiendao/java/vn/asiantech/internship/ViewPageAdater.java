package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class ViewPageAdater extends FragmentPagerAdapter implements IEventClick {
    private final FriendRequestFragment mFriendRequestFragment;
    private final FriendFragment mFriendFragment;

    ViewPageAdater(FragmentManager fm) {
        super(fm);
        mFriendFragment = new FriendFragment();
        mFriendFragment.settingEventClickButtonFriend(this);
        mFriendRequestFragment = new FriendRequestFragment();
        mFriendRequestFragment.settingEventClickButtonFriend(this);
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("1", "getItem: ");
        if (position == 0) {
            return mFriendRequestFragment;
        } else {
            return mFriendFragment;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "Friend Request";
        } else {
            return "Friend";
        }
    }


    @Override
    public void onButtonFriendClick(Friend friend, boolean isfriend, int position) {
        mFriendFragment.changeRecycleView(friend,isfriend,position);
        mFriendRequestFragment.changeRecycleView(friend,isfriend,position);
    }
}
