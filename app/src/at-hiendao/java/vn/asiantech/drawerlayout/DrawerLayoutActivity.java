package vn.asiantech.drawerlayout;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;


import vn.asiantech.internship.R;

public class DrawerLayoutActivity extends Activity {
    private ItemMailAdapter mAdapter;
    private LinearLayout mMainlayout;
    private RecyclerView mRecyclerViewMenu;
    public static final int REQUEST_CAPTURE_PICTURE = 999;
    public static final int REQUEST_OPEN_GALLERY = 666;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        mMainlayout = findViewById(R.id.llMainDrawerLayout);
        mRecyclerViewMenu = findViewById(R.id.recycleViewDrawerLayout);
        mRecyclerViewMenu.setHasFixedSize(false);
        mRecyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ItemMailAdapter(this);
        mRecyclerViewMenu.setAdapter(mAdapter);
        final DrawerLayout drawerLayout = findViewById(R.id.dlDrawerLayout);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                float widthDrawer = mRecyclerViewMenu.getWidth();
                float distange = widthDrawer * slideOffset;
                onOpenMenu((int) distange);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mAdapter.resetDrawerLayout();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void onOpenMenu(int distange) {
        mMainlayout.setX(distange);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAPTURE_PICTURE) {
                if (data.getExtras() != null) {
                    mAdapter.changeAvatar(data, true);
                }
            } else {
                if (data.getData() != null) {
                    mAdapter.changeAvatar(data, false);
                }
            }
        }

    }

}
