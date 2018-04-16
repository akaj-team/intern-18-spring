package vn.asiantech.internship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;


public class ViewPageActivity extends FragmentActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        ViewPager viewPager = findViewById(R.id.vpViewPage);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        TabLayout tabLayout = findViewById(R.id.tlTabLayout);
        tabLayout.setupWithViewPager(viewPager);
        ViewPageAdater viewPageAdater = new ViewPageAdater(fragmentManager);
        viewPager.setAdapter(viewPageAdater);
        CirclePageIndicator indicator = findViewById(R.id.cpiIndicator);
        indicator.setViewPager(viewPager);
        indicator.setFillColor(Color.RED);

    }

}
