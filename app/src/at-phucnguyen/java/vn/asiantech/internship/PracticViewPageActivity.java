package vn.asiantech.internship;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class PracticViewPageActivity extends AppCompatActivity{
    ViewPager mViewPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practic_view_page);

        mappingView();
        setViewPage();
    }

    private void setViewPage() {
        MyPageViewAdapter myPageViewAdapter=new MyPageViewAdapter(getSupportFragmentManager());
        mViewPage.setAdapter(myPageViewAdapter);
        mViewPage.setPageTransformer(true,new ZoomOutPageTransformer());
    }

    private void mappingView() {
        mViewPage=findViewById(R.id.viewPage);
    }

}
