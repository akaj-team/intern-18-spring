package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnEventAndListener = findViewById(R.id.btnEventAndListener);
        btnEventAndListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        Button btnViewViewGroup = findViewById(R.id.btnViewViewGroup);
        btnViewViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ViewViewGroupActivity.class);
                startActivity(intent);
            }
        });
        Button btnResources = findViewById(R.id.btnResources);
        btnResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        Button btnViewPager = findViewById(R.id.viewPager);
        btnViewPager.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PagerActivity.class);
                startActivity(intent);
            }
        });
    }
}
