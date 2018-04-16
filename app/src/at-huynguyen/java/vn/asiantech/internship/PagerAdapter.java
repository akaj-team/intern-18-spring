package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ListFriendFragment();
            case 1:
                return new FavoriteFragment();
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
        if (position == 0) {
            return "Friends";
        } else {
            return "Favorite Friends";
        }
    }
}
