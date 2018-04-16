package vn.asiantech.internship;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class ViewPageActivity extends FragmentActivity implements IEventClick {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        ViewPager viewPager = new ViewPager(this);
        viewPager = findViewById(R.id.vpViewPage);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        TabLayout tabLayout = findViewById(R.id.tlTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        ViewPageAdater viewPageAdater  = new ViewPageAdater(fragmentManager);
        viewPager.setAdapter(viewPageAdater);
    }

    @Override
    public void onButtonFriendClick(Friend friend) {

    }

    @Override
    public void onButtonUnfriendClick(Friend friend) {

    }
}
