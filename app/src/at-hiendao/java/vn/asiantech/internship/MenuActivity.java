package vn.asiantech.internship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import vn.asiantech.internship.service_and_broadcast_receiver.ServiceActivity;

import vn.asiantech.internship.api.ApiActivity;

import vn.asiantech.drawerlayout.DrawerLayoutActivity;

public class MenuActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        settingButtonsClick();
    }

    private void settingButtonsClick() {
        Button btnView = findViewById(R.id.btnView);
        btnView.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ViewActivity.class);
            startActivity(intent);
        });

        Button btnActivity = findViewById(R.id.btnActivityAndFragment);
        btnActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, SendDataActivity.class);
            startActivity(intent);
        });
        Button btnRecycleView = findViewById(R.id.btnRecycleView);
        btnRecycleView.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ListFriendActitivy.class);
            startActivity(intent);
        });

        Button btnViewPager = findViewById(R.id.btnViewPage);
        btnViewPager.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ViewPageActivity.class);
            startActivity(intent);
        });
        Button btnAPI = findViewById(R.id.btnAPI);
        btnAPI.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ApiActivity.class);
            startActivity(intent);
        });

        Button btnService = findViewById(R.id.btnService);
        btnService.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, ServiceActivity.class);
            startActivity(intent);
        });

        Button btnDrawerLayout = findViewById(R.id.btnDrawerLayout);
        btnDrawerLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, DrawerLayoutActivity.class);
            startActivity(intent);
        });
    }

}
