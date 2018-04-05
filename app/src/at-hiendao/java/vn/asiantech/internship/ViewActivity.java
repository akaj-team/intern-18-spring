package vn.asiantech.internship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        getIntentData();
        settingButtonHomeClick();
        Log.e("Create", "View Create");
    }

    private void getIntentData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        EditText editText = findViewById(R.id.etCommentText);
        editText.setText(bundle != null ? bundle.getString("123") : null);
        TextView comment = findViewById(R.id.tvComment);
        comment.setText(intent.getStringExtra("345"));

    }

    private void settingButtonHomeClick() {
        Button button = findViewById(R.id.btnHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this, MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Start", "View Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Stop", "View Stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Pause", "View Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Destroy", "View Destroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Resume", "View Resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Restart", "View Restart");
    }
}
