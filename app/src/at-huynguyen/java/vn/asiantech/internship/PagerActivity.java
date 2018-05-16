package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import me.relex.circleindicator.CircleIndicator;

public class PagerActivity extends FragmentActivity {

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.view_pager);
        setContentView(R.layout.activity_viewpage);

        ListFriendFragment listFriendFragment = new ListFriendFragment();
        FavoriteFragment favoriteFragment = new FavoriteFragment();
        listFriendFragment.setOnFriendClickListener(favoriteFragment);
        favoriteFragment.setOnFriendCLickListener(listFriendFragment);

        ViewPager viewPager = findViewById(R.id.viewPage);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), listFriendFragment, favoriteFragment));
        mTabLayout = findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(viewPager);
        CircleIndicator circleIndicator = findViewById(R.id.indicatorView);
        circleIndicator.setViewPager(viewPager);
        setTabIcons();
    }

    private static final int[] TAB_ICONS = {
            R.drawable.ic_person_black,
            R.drawable.ic_star_border_black,
    };

    private void setTabIcons() {
        TabLayout.Tab x = mTabLayout.getTabAt(0);
        TabLayout.Tab x1 = mTabLayout.getTabAt(1);
        if (x != null) {
            x.setIcon(TAB_ICONS[0]);
            if (x1 != null) {
                x1.setIcon(TAB_ICONS[1]);
            }
        }
    }
}
