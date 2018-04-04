package vn.asiantech.internship;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.text.style.UpdateLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        settingButtonsClick();
        Log.w("Create", "Create");
    }

    private void settingButtonsClick()
    {
        Button btnView = (Button)(findViewById(R.id.btnView));
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ViewActivity.class);
                intent.putExtra("345","Comment");
                Bundle bundle = new Bundle();
                bundle.putString("123","123456789");
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
        Log.w("Pause","Menu Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("Destroy", "Menu Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("Restart","Menu Restart");
    }



}
