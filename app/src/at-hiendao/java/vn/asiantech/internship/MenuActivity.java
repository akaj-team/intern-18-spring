package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

@SuppressLint("Registered")
public class MenuActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        settingButtonsClick();
        Log.w("Create", "Create");
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("Start", "Menu Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("Stop", "Menu Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Menu Pause", "Menu Pause");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("Pause", "Menu Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Destroy", "Menu Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Restart", "Menu Restart");
    }


}