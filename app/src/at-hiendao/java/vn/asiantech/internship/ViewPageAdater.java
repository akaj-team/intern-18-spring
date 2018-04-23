package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPageAdater extends FragmentPagerAdapter implements IEventClick {
    private final FriendRequestFragment mFriendRequestFragment;
    private final FriendFragment mFriendFragment;
    private static final String FRIEND = "Friend";
    private static final String FRIEND_REQUEST = "Friend Request";

    ViewPageAdater(FragmentManager fm) {
        super(fm);
        mFriendFragment = new FriendFragment();
        mFriendFragment.setIEventClick(this);
        mFriendRequestFragment = new FriendRequestFragment();
        mFriendRequestFragment.settingEventClickButtonFriend(this);
    }

    @Override
    public Fragment getItem(int position) {
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
            return FRIEND;
        } else {
            return FRIEND_REQUEST;
        }
    }

    @Override
    public void onButtonFriendClick(Friend friend, boolean isfriend, int position) {
        mFriendFragment.changeRecycleView(friend, isfriend, position);
        mFriendRequestFragment.changeRecycleView(friend, isfriend, position);
    }
}
