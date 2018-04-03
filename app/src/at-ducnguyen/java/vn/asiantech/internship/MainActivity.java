package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mBtnViewAndViewGroup;
    private Button mBtnActivityAndFragment;
    public static String KEY_TITLE = "KEY_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Android Training");
        setContentView(R.layout.activity_main);
        mBtnViewAndViewGroup = (Button) findViewById(R.id.btnViewAndViewGroup);
        mBtnViewAndViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                String result = mBtnViewAndViewGroup.getText().toString();
                intent.putExtra(KEY_TITLE, result);
                startActivity(intent);
            }
        });
        mBtnActivityAndFragment = (Button) findViewById(R.id.btnActivityAndFragment);
        mBtnActivityAndFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SendDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
