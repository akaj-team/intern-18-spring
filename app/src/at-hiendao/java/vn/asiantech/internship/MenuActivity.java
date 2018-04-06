package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

@SuppressLint("Registered")
public class MenuActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        settingButtonsClick();
    }

    private void settingButtonsClick() {
        Button btnView = findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ViewActivity.class);
                intent.putExtra("345", "Comment");
                Bundle bundle = new Bundle();
                bundle.putString("123", "123456789");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

}
