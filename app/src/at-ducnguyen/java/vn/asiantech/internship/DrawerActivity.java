package vn.asiantech.internship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

public class DrawerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final RecyclerView recyclerViewInformation = findViewById(R.id.recyclerViewInformation);
        recyclerViewInformation.setAdapter(new DrawerLayoutAdapter(this));
        recyclerViewInformation.setLayoutManager(new LinearLayoutManager(DrawerActivity.this));

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        final RelativeLayout rlContent = findViewById(R.id.rlContent);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.draw_desc_open, R.string.drawer_desc_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                rlContent.setTranslationX(slideX);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }
}
