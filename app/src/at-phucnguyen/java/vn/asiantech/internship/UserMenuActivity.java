package vn.asiantech.internship;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class UserMenuActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle  mActionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermenu);

        initView();
        initEventOfView();

        //Cho hiển thị Button menu hình hambager
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initView() {
        mDrawerLayout=findViewById(R.id.drawerMenu);

        //Khởi tạo một ActionBar và đồng bộ thành phần ActionBar với activity.
        mActionBarDrawerToggle=new ActionBarDrawerToggle(this, mDrawerLayout,R.string.navigation_drawer_open
        ,R.string.navigation_drawer_close);
    }

    private void initEventOfView(){
        //Đồng bộ sự lắng nghe sự kiện của ActionBar với Activity(DrawerLayout).
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //Đồng bộ hóa trạng thái của hambager sau khi ỎnestoreInstanceState được khởi chạy
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
