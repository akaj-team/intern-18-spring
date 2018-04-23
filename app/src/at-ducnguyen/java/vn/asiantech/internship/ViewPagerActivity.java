package vn.asiantech.internship;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.LinePageIndicator;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ListFriendFragment listFriendFragment = new ListFriendFragment();
        ListFriendRequestFragment listFriendRequestFragment = new ListFriendRequestFragment();
        listFriendFragment.setOnFriendClickListener(listFriendRequestFragment);
        listFriendRequestFragment.setOnFriendClickListener(listFriendFragment);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), listFriendFragment, listFriendRequestFragment));

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        LinePageIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
    }
}
