package vn.asiantech.drawerlayout;

import android.content.Intent;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.R;

public class DrawerLayoutActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, View.OnClickListener {
    private ItemMailAdapter mAdapter;
    private LinearLayout mMainlayout;
    private RecyclerView mRecyclerViewMenu;
    private DrawerLayout mDrawerLayout;
    public static final int REQUEST_CAPTURE_PICTURE = 999;
    public static final int REQUEST_OPEN_GALLERY = 666;
    private List<ItemMail> mListData;
    static final String AVATAR_USER = "Avatar_user";
    private static final String TAG = "test";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        initListData();
        mMainlayout = findViewById(R.id.llMainDrawerLayout);
        mRecyclerViewMenu = findViewById(R.id.recycleViewDrawerLayout);
        mRecyclerViewMenu.setHasFixedSize(false);
        mRecyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ItemMailAdapter(this, mListData);
        mRecyclerViewMenu.setAdapter(mAdapter);
        mDrawerLayout = findViewById(R.id.dlDrawerLayout);
        mDrawerLayout.addDrawerListener(this);
        Button btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(this);

    }

    private void onOpenMenu(int distange) {
        mMainlayout.setX(distange);
    }

    private void initListData() {
        mListData = new ArrayList<>();
        ItemMail userInfo = new ItemMail(ItemMail.ItemMailType.UserInfo, null);
        mListData.add(userInfo);
        ItemMail inbox = new ItemMail(ItemMail.ItemMailType.Inbox, null);
        mListData.add(inbox);
        ItemMail outbox = new ItemMail(ItemMail.ItemMailType.Outbox, null);
        mListData.add(outbox);
        ItemMail trash = new ItemMail(ItemMail.ItemMailType.Trash, null);
        mListData.add(trash);
        ItemMail spam = new ItemMail(ItemMail.ItemMailType.Spam, null);
        mListData.add(spam);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAPTURE_PICTURE) {
                if (data.getExtras() != null) {
                    saveAvatar(data, true);
                    mAdapter.notifyItemChanged(ItemMailAdapter.TYPE_USER_INFO);
                }
            } else {
                if (data.getData() != null) {
                    saveAvatar(data, false);
                    mAdapter.notifyItemChanged(ItemMailAdapter.TYPE_USER_INFO);
                }
            }
        }

    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        float widthDrawer = mRecyclerViewMenu.getWidth();
        float distange = widthDrawer * slideOffset;
        onOpenMenu((int) distange);
    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public void onClick(View v) {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }

    File getAvatarFilePath() {
        String path = getFilesDir() + File.separator + AVATAR_USER + ".jpg";
        File imgFilePath = new File(path);
        boolean isCreateFile = false;
        if (!imgFilePath.exists()) {
            try {
                isCreateFile = imgFilePath.createNewFile();

            } catch (Exception e) {
                Log.e(TAG, "getAvatarFilePath: " + e.toString());
            }
        }
        if (!isCreateFile) {
            return imgFilePath;
        } else {
            return null;
        }
    }

    private void saveAvatar(Intent data, boolean isCapturePicture) {

        Bitmap bitmap = null;
        if (isCapturePicture) {
            if (data.getExtras() != null) {
                bitmap = (Bitmap) data.getExtras().get("data");
            }
        } else {
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            } catch (Exception e) {
                Log.e(TAG, "saveAvatar: " + e.toString());
            }
        }
        File path = getAvatarFilePath();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            }
        } catch (Exception e) {
            Log.e(TAG, "saveAvatar: " + e.toString());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "saveAvatar: " + e.toString());
            }
        }
        mListData.get(0).setUri(Uri.fromFile(path));
    }
}
