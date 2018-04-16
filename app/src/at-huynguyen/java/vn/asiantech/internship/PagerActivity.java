package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import me.relex.circleindicator.CircleIndicator;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.viewpager);
        setContentView(R.layout.activity_viewpage);
        ViewPager viewPager = findViewById(R.id.viewPage);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        CircleIndicator indicatorView = findViewById(R.id.indicatorView);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        indicatorView.setViewPager(viewPager);
    }
}
