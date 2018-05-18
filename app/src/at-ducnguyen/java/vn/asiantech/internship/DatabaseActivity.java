package vn.asiantech.internship;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    private FragmentManager mFragmentManager;
    private SharedPreferenceFragment mSharedPreferenceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button btnSharedPreference = findViewById(R.id.btnSharedPreference);
        btnSharedPreference.setOnClickListener(this);

        Button btnStorage = findViewById(R.id.btnStorage);
        btnStorage.setOnClickListener(this);

        Button btnSqlLite = findViewById(R.id.btnSqlLite);
        btnSqlLite.setOnClickListener(this);

        mFragmentManager = getFragmentManager();

        mSharedPreferenceFragment = new SharedPreferenceFragment();
    }



    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = mFragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btnSharedPreference: {
                fragmentTransaction.replace(R.id.flFragment, mSharedPreferenceFragment);
                break;
            }
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
