package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnViewAndViewGroup;
    public static final String TAG = "EXCEPTION";
    public static final String MSG = "OPS! FOUND EXCEPTION";
    public final static String KEY_TITLE = "KEY_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Android Training");
        setContentView(R.layout.activity_begin);

        Button btnActivityAndFragment = findViewById(R.id.btnActivityAndFragment);
        btnActivityAndFragment.setOnClickListener(this);

        Button btnResource = findViewById(R.id.btnResource);
        btnResource.setOnClickListener(this);

        Button btnListFriend = findViewById(R.id.btnListFriend);
        btnListFriend.setOnClickListener(this);

        mBtnViewAndViewGroup = findViewById(R.id.btnViewAndViewGroup);
        mBtnViewAndViewGroup.setOnClickListener(this);

        Button btnViewPagerListFriend = findViewById(R.id.btnViewPagerListFriend);
        btnViewPagerListFriend.setOnClickListener(this);

        Button btnListener = findViewById(R.id.btnListener);
        btnListener.setOnClickListener(this);

        Button btnDatabase = findViewById(R.id.btnDatabase);
        btnDatabase.setOnClickListener(this);

        Button btnApi = findViewById(R.id.btnApi);
        btnApi.setOnClickListener(this);

        Button btnUnitTest = findViewById(R.id.btnUnitTest);
        btnUnitTest.setOnClickListener(this);
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
            case R.id.btnListener: {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnResource: {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnListFriend: {
                Intent intent = new Intent(MainActivity.this, ListFriendActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnActivityAndFragment: {
                Intent intent = new Intent(MainActivity.this, SendDataActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnViewPagerListFriend: {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnDatabase: {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btnUnitTest: {
                goTo(LoginActivity.class);
                break;
            }
            case R.id.btnApi: {
                goTo(ArtistInfomationActivity.class);
            }
        }
    }

    private void goTo(Class classMark) {
        Intent intent = new Intent(MainActivity.this, classMark);
        startActivity(intent);
    }
}
