package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class UseViewPageAcativity extends AppCompatActivity {
    private ViewPager mViewPage;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_view_page);

        getSupportActionBar().hide();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mAdapter = new ViewPagerAdapter(mFragmentManager);

        mappingView();
        initalViewPage();
    }

    public void mappingView() {
        mViewPage = findViewById(R.id.view_page);
        mTabLayout = findViewById(R.id.tab_layout);
    }

    public void initalViewPage() {
        mViewPage.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPage);
        mViewPage.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }
}
