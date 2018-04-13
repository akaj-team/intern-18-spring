package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPageViewAdapter extends FragmentStatePagerAdapter {
    private static String sKEY_DATA="key";

    public MyPageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        bundle.putString(sKEY_DATA,"Page "+position);
        Fragment fragment=new FriendsListFragments();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
