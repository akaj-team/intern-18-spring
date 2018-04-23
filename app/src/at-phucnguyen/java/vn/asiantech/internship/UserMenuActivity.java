package vn.asiantech.internship;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;
import vn.asiantech.internship.model.MyMenu;
import vn.asiantech.internship.model.MyMenuHeader;
import vn.asiantech.internship.model.IOnEventListenes;

public class UserMenuActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, View.OnClickListener, IOnEventListenes {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private final static String TAG = "DrawerListener";
    private RecyclerView mRvMenu;
    private MenuAdapter mMenuAdapter;
    private final List<MyMenu> mMyMenuList = new ArrayList<>();
    private final List<MyMenuHeader> mMyMenuHeaderList = new ArrayList<>();
    private final static int GALLERY_REQUEST = 101;
    private final static int CAMERA_REQUEST = 102;
    private Dialog mDialog;
    private FrameLayout mFDrawerLayout;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CAMERA_REQUEST: {
                    setImgHeaderMenuByCamera(data);
                    break;
                }
                case GALLERY_REQUEST: {
                    setImgHeaderMenuByGalary(data);
                    break;
                }
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermenu);

        initView();
        initEventOfView();

        //Cho hiển thị Button menu hình hambager
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void showDialog() {
        //Khoi tao mot Dialog tu mot Activity
        mDialog = new Dialog(UserMenuActivity.this);
        //Set Layout cho Dialog
        mDialog.setContentView(R.layout.dialog_menu);
        //Set tieu de cho Dialog
        mDialog.setTitle(R.string.chose_a_photo);
        //Set id View tu Dialog
        Button btnOpenCamera = mDialog.findViewById(R.id.btnOpenCamera);
        Button btnOpenGalary = mDialog.findViewById(R.id.btnOpenGallary);
        Button btnCanle = mDialog.findViewById(R.id.btnCancle);
        btnOpenCamera.setOnClickListener(this);
        btnOpenGalary.setOnClickListener(this);
        btnCanle.setOnClickListener(this);
        //Hien thi Dialog
        mDialog.show();
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawerMenu);
        mRvMenu = findViewById(R.id.rvMenu);
        mFDrawerLayout = findViewById(R.id.flDrawerLayout);

        initRecyclerView();

        //Khởi tạo một ActionBar và đồng bộ thành phần ActionBar với activity.
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open
                , R.string.navigation_drawer_close);
    }

    private void initRecyclerView() {
        mMenuAdapter = new MenuAdapter(mMyMenuList, mMyMenuHeaderList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(UserMenuActivity.this);
        mRvMenu.setLayoutManager(mLayoutManager);
        initListMenu();
        //ScaleInAnimationAdapter: Hiệu ứng khi phần tử đcượ thêm vào hoặc xóa đi
        mRvMenu.setAdapter(new ScaleInAnimationAdapter(mMenuAdapter));
        mRvMenu.setItemAnimator(new DefaultItemAnimator());
        //Chèn một kẻ ngang giữa các phần tử
        DividerItemDecoration dividerHorizontal = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRvMenu.addItemDecoration(dividerHorizontal);
        mRvMenu.setAdapter(mMenuAdapter);
    }

    private void initEventOfView() {
        //Đồng bộ sự lắng nghe sự kiện của ActionBar với Activity(DrawerLayout).
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.addDrawerListener(this);
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
        return mActionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Log.e(TAG, "onDrawerSlide: " + slideOffset);
        slideMenu(mRvMenu.getWidth() * slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        Log.e(TAG, "onDrawerOpened");
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        Log.e(TAG, "onDrawerClosed");
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        Log.e(TAG, "onDrawerStateChanged");
    }

    private void slideMenu(float locationX) {
        mFDrawerLayout.setX(locationX);
    }

    private void initListMenu() {
        mMyMenuHeaderList.add(new MyMenuHeader("phuc.nguyen3@asiantech.vn", R.drawable.img_phucnguyen));
        mMyMenuList.add(new MyMenu("Giới Thiệu"));
        mMyMenuList.add(new MyMenu("View"));
        mMyMenuList.add(new MyMenu("Intent"));
        mMyMenuList.add(new MyMenu("Activity/Fragment"));
        mMyMenuList.add(new MyMenu("Resources"));
        mMyMenuList.add(new MyMenu("ViewPager"));
        mMyMenuList.add(new MyMenu("Menu,Toolbar, DrawerLayout"));
        mMyMenuList.add(new MyMenu("Database"));
        mMyMenuList.add(new MyMenu("Async Task"));
        mMyMenuList.add(new MyMenu("Thread - Handler - Runnable"));
        mMyMenuList.add(new MyMenu("Services & Broadcast Receiver"));
        mMyMenuList.add(new MyMenu("API"));
        mMyMenuList.add(new MyMenu("Google Map"));
        mMyMenuList.add(new MyMenu("Unit Test"));
        mMyMenuList.add(new MyMenu("Kotlin"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOpenCamera: {
                menuOpenCamera();
                break;
            }
            case R.id.btnOpenGallary: {
                menuOpenGalary();
                break;
            }
            case R.id.btnCancle: {
                if (mDialog != null) {
                    mDialog.cancel();
                }
                break;
            }
        }
    }

    private void menuOpenCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CAMERA_REQUEST);
        } else {
            throw new RuntimeException();
        }
    }

    private void menuOpenGalary() {
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, GALLERY_REQUEST);
    }

    private void setImgHeaderMenuByCamera(Intent data) {
        Log.e("Camera", "Changed Data");
        if (data.getExtras() != null) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            mMyMenuHeaderList.get(0).setBitmapHeader(bp);
            mMenuAdapter.notifyDataSetChanged();
        }
        mDialog.cancel();
    }

    private void setImgHeaderMenuByGalary(Intent data) {
        Log.e("Galary", "Changed Data");
        Uri imgResult;
        imgResult = data.getData();
        mMyMenuHeaderList.get(0).setUri(imgResult);
        mMenuAdapter.notifyDataSetChanged();
        mDialog.cancel();
    }

    @Override
    public void onImgHeaderMenuClick() {
        showDialog();
    }
}
