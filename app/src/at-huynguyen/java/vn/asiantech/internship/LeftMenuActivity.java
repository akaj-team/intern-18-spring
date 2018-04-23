package vn.asiantech.internship;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class LeftMenuActivity extends AppCompatActivity {

    ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_menu);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new LeftMenuAdapter(MenuItem.createListMenuItem()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolBar = findViewById(R.id.toolBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolBar, R.string.drawopen, R.string.drawclose);
        drawerLayout.addDrawerListener(mDrawerToggle);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
}
