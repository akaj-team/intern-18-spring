package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnViewAndViewGroup;
    public final static String KEY_TITLE = "KEY_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Android Training");
        setContentView(R.layout.activity_begin);
        final Button btnResource = findViewById(R.id.btnResource);
        btnResource.setOnClickListener(this);
        mBtnViewAndViewGroup = findViewById(R.id.btnViewAndViewGroup);
        mBtnViewAndViewGroup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnViewAndViewGroup: {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                String result = mBtnViewAndViewGroup.getText().toString();
                intent.putExtra(KEY_TITLE, result);
                startActivity(intent);
                break;
            }
            case R.id.btnResource: {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
