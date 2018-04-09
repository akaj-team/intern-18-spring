package vn.asiantech.internship;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(MainActivity.KEY_TITLE);
            this.setTitle(title);
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        UserFragment userFragment = new UserFragment();
        transaction.replace(R.id.flFragment, userFragment);
        transaction.commit();
    }
}
