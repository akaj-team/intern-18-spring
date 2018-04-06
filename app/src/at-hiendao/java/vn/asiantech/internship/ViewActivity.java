package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("Registered")
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
//                Fragment fmResources = new ResourcesFragment();
//                FragmentManager fmManager = getFragmentManager();
//                FragmentTransaction fmTransaction = fmManager.beginTransaction();
//                fmTransaction.replace(R.id.llViewAndViewGroup, fmResources);
//                fmTransaction.addToBackStack(null);
//                fmTransaction.commit();
            }
        });

    }

    @Override
    protected void onStart() {
        Log.e("Start", "View Start");
        super.onStart();

    }

    @Override
    protected void onStop() {
        Log.e("Stop", "View Stop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.e("Pause", "View Pause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e("Destroy", "View Destroy");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.e("Resume", "View Resume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e("Restart", "View Restart");
        super.onRestart();
    }
}
