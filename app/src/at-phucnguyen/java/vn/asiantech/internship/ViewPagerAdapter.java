package vn.asiantech.internship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class ViewPagerAdapter extends FragmentPagerAdapter{
    ViewPagerAdapter(FragmentManager fm){//Class yeu cau phai co contructor
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("My Log on PageAdapter","getItems"+position);
        Fragment frag=null;
        switch(position){
            case 0:{
                frag=new AndroidFragment();
                break;
            }
            case 1:{
                frag=new IosFragment();
                break;
            }
            case 2:{
                frag=new PhpFragment();
                break;
            }
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("My Log on PageAdapter","getPageTitle"+position);
        String mTitle="";
        switch (position){
            case 0:{
                mTitle="Android";
                break;
            }
            case 1:{
                mTitle="Ios";
                break;
            }
            case 2:{
                mTitle="Php";
                break;
            }
        }
        return mTitle;
    }
}
