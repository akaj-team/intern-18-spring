package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.viewpagerindicator.LinePageIndicator;

import vn.asiantech.internship.model.ZoomOutPageTransformer;

public class PracticViewPageActivity extends AppCompatActivity {
    ViewPager mViewPage;
    LinePageIndicator mLinePageIndicator;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practic_view_page);

        mappingView();
        setViewPage();
    }

    private void setViewPage() {
        MyPageViewAdapter myPageViewAdapter = new MyPageViewAdapter(getSupportFragmentManager());
        mViewPage.setAdapter(myPageViewAdapter);
        mViewPage.setPageTransformer(true, new ZoomOutPageTransformer());
        mTabLayout.setupWithViewPager(mViewPage);//Set tab Layout
        mLinePageIndicator.setViewPager(mViewPage);//hieu ungview
    }

    private void mappingView() {
        mViewPage = findViewById(R.id.viewPage);
        mLinePageIndicator = findViewById(R.id.lpiViewPage);
        mTabLayout = findViewById(R.id.tabLayout);
    }
}
