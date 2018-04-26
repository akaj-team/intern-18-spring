package vn.asiantech.internship;

import android.annotation.SuppressLint;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.HeaderMenu;
import vn.asiantech.internship.model.LeftMenu;


public class DrawerLayoutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnChangeAvatarClickListener, View.OnClickListener {

    public static final int PICK_FROM_CAMERA = 1;
    public static final int PICK_FROM_FILE = 2;
    private final List<HeaderMenu> mListHeaderMenu = new ArrayList<>();
    private final List<LeftMenu> mListLeftMenu = new ArrayList<>();
    private DrawerLayoutAdapter mDrawerLayoutAdapter;
    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    ImageButton mImgBtnAvatar;
    private Dialog mDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_menu);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mDrawerLayoutAdapter = new DrawerLayoutAdapter(mListHeaderMenu, mListLeftMenu);
        mDrawerLayoutAdapter.setOnChangeAvatarClickListener(this);
        recyclerView.setAdapter(mDrawerLayoutAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(DrawerLayoutActivity.this));
        initListItem();

        Toolbar toolBar = findViewById(R.id.toolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        final RelativeLayout frame = findViewById(R.id.rlContent);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolBar, R.string.drawopen, R.string.drawclose) {
            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float setTranslation = drawerView.getWidth() * slideOffset;
                frame.setTranslationX(setTranslation);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        mImgBtnAvatar = findViewById(R.id.imgBtnAvatar);
    }

    private void initListItem() {
        mListHeaderMenu.add(new HeaderMenu(R.drawable.custom_circle, "Huy Nguyen Q.", "quanghuy19496@gmail.com"));
        mListLeftMenu.add(new LeftMenu(R.drawable.ic_email, "Email"));
        mListLeftMenu.add(new LeftMenu(R.drawable.ic_gallery, "Gallery"));
        mListLeftMenu.add(new LeftMenu(R.drawable.ic_slideshow, "Slide show"));
        mListLeftMenu.add(new LeftMenu(R.drawable.ic_tool, "Tools"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PICK_FROM_CAMERA: {
                    setOnChangeAvatarFromCamera(data);
                    break;
                }
                case PICK_FROM_FILE: {
                    setOnChangeAvatarFromFile(data);
                    break;
                }
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
        return false;
    }

    public void onPickFromCamera() {
        Intent Intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(Intent, PICK_FROM_CAMERA);
        } else {
            throw new RuntimeException();
        }
    }

    public void onPickFromFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_FROM_FILE);
    }

    private void setOnChangeAvatarFromCamera(Intent data) {
        if (data.getExtras() != null) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            assert bp != null;
            bp.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(getContentResolver(), bp, "Title", null);
            mListHeaderMenu.get(0).setUri(Uri.parse(path));
            mDrawerLayoutAdapter.notifyDataSetChanged();
        }
        mDialog.cancel();
    }

    private void setOnChangeAvatarFromFile(Intent data) {
        Uri imgResult;
        imgResult = data.getData();
        mListHeaderMenu.get(0).setUri(imgResult);
        mDrawerLayoutAdapter.notifyDataSetChanged();
        mDialog.cancel();
    }

    public void showDialog() {
        mDialog = new Dialog(DrawerLayoutActivity.this);
        mDialog.setContentView(R.layout.menu_dialog);
        Button btnPickFromCamera = mDialog.findViewById(R.id.btnPickFromCamera);
        Button btnPickFromFile = mDialog.findViewById(R.id.btnPickFromFile);
        btnPickFromCamera.setOnClickListener(this);
        btnPickFromFile.setOnClickListener(this);
        mDialog.show();
    }

    @Override
    public void onChangeAvatarClick() {
        showDialog();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPickFromCamera: {
                onPickFromCamera();
                break;
            }
            case R.id.btnPickFromFile: {
                onPickFromFile();
                break;
            }
        }
    }
}
