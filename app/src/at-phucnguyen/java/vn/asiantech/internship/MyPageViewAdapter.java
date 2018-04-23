package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPageViewAdapter extends FragmentStatePagerAdapter {
    public static final String KEY_PAGE_POSITION = "key_page_position";

    MyPageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PAGE_POSITION, "Page " + position);
        switch (position) {
            case 0: {
                Fragment fragment = new FriendListFragment();
                fragment.setArguments(bundle);
                return fragment;
            }
            case 1: {
                Fragment fragment = new FollowListFragment();
                fragment.setArguments(bundle);
                return fragment;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0: {
                title = "Friends";
                break;
            }
            case 1: {
                title = "Follow ";
                break;
            }
        }
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
