package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.relex.circleindicator.CircleIndicator;

public class PagerActivity extends AppCompatActivity {

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.viewpager);
        setContentView(R.layout.activity_viewpage);
        ViewPager viewPager = findViewById(R.id.viewPage);
        mTabLayout = findViewById(R.id.tabLayout);
        CircleIndicator circleIndicator = findViewById(R.id.indicatorView);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        circleIndicator.setViewPager(viewPager);
        setTabIcons();
    }

    private int[] tabIcons = {
            R.drawable.ic_person_black,
            R.drawable.ic_star_border_black,
    };

    private void setTabIcons() {
        TabLayout.Tab x = mTabLayout.getTabAt(0);
        TabLayout.Tab x1 = mTabLayout.getTabAt(1);
        if(x != null){
            x.setIcon(tabIcons[0]);
            if (x1!= null) {
                x1.setIcon(tabIcons[1]);
            }
        }
    }
}
