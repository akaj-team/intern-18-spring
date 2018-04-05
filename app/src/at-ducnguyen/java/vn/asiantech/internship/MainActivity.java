package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public final static String KEY_TITLE = "KEY_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Android Training");
        setContentView(R.layout.activity_main);
        final Button btnViewAndViewGroup = findViewById(R.id.btnViewAndViewGroup);
        btnViewAndViewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                String result = btnViewAndViewGroup.getText().toString();
                intent.putExtra(KEY_TITLE, result);
                startActivity(intent);
            }
        });
        Button btnActivityAndFragment = findViewById(R.id.btnActivityAndFragment);
        btnActivityAndFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SendDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
