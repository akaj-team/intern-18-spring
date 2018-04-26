package vn.asiantech.internship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SharePreferencesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreferences);

        Button btnSaveStatus = findViewById(R.id.btnSaveStatus);
        btnSaveStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharePreferencesActivity.this, ItemSaveStatusActivity.class);
                startActivity(intent);
            }
        });

        Button btnSaveText = findViewById(R.id.btnSaveText);
        btnSaveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharePreferencesActivity.this, ItemSaveTextActivity.class);
                startActivity(intent);
            }
        });
    }
}
