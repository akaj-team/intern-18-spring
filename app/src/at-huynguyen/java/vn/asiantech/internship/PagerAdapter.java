package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag=new ListFriendFragment();
                break;
            case 1:
                frag=new FavoriteFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {

        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Friends";
        } else {
            return "Favorite Friends";
        }
    }
}
