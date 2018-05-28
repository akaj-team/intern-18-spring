package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnViewAndViewGroup;
    public final static String KEY_TITLE = "KEY_TITLE";
    public static final String TAG = "AAA";

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

        Button btnMusicPlayer = findViewById(R.id.btnMusicPlayer);
        btnMusicPlayer.setOnClickListener(this);

        Button btnApi = findViewById(R.id.btnApi);
        btnApi.setOnClickListener(this);

        Button btnUnitTest = findViewById(R.id.btnUnitTest);
        btnUnitTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnViewAndViewGroup: {
                String title = mBtnViewAndViewGroup.getText().toString();
                goTo(UserActivity.class, title);
                break;
            }
            case R.id.btnListener: {
                goTo(SignUpActivity.class, null);
                break;
            }
            case R.id.btnResource: {
                goTo(UserActivity.class);
                break;
            }
            case R.id.btnListFriend: {
                goTo(ListFriendActivity.class);
                break;
            }
            case R.id.btnActivityAndFragment: {
                goTo(SendDataActivity.class);
                break;
            }
            case R.id.btnViewPagerListFriend: {
                goTo(ViewPagerActivity.class);
                break;
            }
            case R.id.btnMusicPlayer: {
                goTo(MusicActivity.class);
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

    private void goTo(Class classMark, String title) {
        Intent intent = new Intent(MainActivity.this, classMark);
        intent.putExtra(KEY_TITLE, title);
        startActivity(intent);
    }

    private void goTo(Class classMark) {
        Intent intent = new Intent(MainActivity.this, classMark);
        startActivity(intent);
    }
}
