package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final ListFriendRequestFragment mListFriendRequestFragment;
    private final ListFriendFragment mListFriendFragment;

    ViewPagerAdapter(FragmentManager fm, ListFriendFragment listFriendFragment, ListFriendRequestFragment  listFriendRequestFragment) {
        super(fm);
        mListFriendFragment = listFriendFragment;
        mListFriendRequestFragment = listFriendRequestFragment;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return mListFriendFragment;
            case 1:
                return mListFriendRequestFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "List Friend";
            case 1:
                return "List Friend Request";
            default:
                return null;
        }
    }
}
