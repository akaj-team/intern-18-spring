package vn.asiantech.internship;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_READ_EXTERNAL_STORAGE = 1;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Button btnSharedPreference = findViewById(R.id.btnSharedPreference);
        btnSharedPreference.setOnClickListener(this);

        Button btnStorage = findViewById(R.id.btnStorage);
        btnStorage.setOnClickListener(this);

        Button btnSqlite = findViewById(R.id.btnSqlLite);
        btnSqlite.setOnClickListener(this);

        mFragmentManager = getFragmentManager();

        SharedPreferenceFragment sharedPreferenceFragment = new SharedPreferenceFragment();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, sharedPreferenceFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSharedPreference: {
                SharedPreferenceFragment sharedPreferenceFragment = new SharedPreferenceFragment();
                showFragment(sharedPreferenceFragment);
                break;
            }
            case R.id.btnStorage: {
                askExternalStoragePermissionGranted();
                break;
            }
            case R.id.btnSqlLite: {
                SqliteFragment sqliteFragment = new SqliteFragment();
                showFragment(sqliteFragment);
                break;
            }
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }

    private void askExternalStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_READ_EXTERNAL_STORAGE);
            } else {
                StorageFragment storageFragment = new StorageFragment();
                showFragment(storageFragment);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    StorageFragment storageFragment = new StorageFragment();
                    showFragment(storageFragment);
                }
            }
        }
    }
}
