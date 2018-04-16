package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPageViewAdapter extends FragmentStatePagerAdapter {

    MyPageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        String sKEY_DATA = "key";
        bundle.putString(sKEY_DATA, "Page " + position);
        switch (position) {
            case 0: {
                Fragment fragment = new FriendsListFragments();
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
