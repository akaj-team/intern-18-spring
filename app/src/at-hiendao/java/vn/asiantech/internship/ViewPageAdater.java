package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPageAdater extends FragmentPagerAdapter {
    ViewPageAdater(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        if(position ==0){
            return new FriendRequestFragment();
        } else {
            return new FriendFragment();
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
}
