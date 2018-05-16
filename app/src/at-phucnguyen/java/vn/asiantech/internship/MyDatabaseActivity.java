package vn.asiantech.internship;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyDatabaseActivity extends AppCompatActivity implements View.OnClickListener
        , UseSharedPreferencesFragment.OnUSPreferencesFragment {
    private SharedPreferences mSharedPreferences;
    private final static String SHARED_PREFERENCES_NAME = "phucSharedPreferences";
    private final static String TAG = "MyDatabaseActivity";
    private Button mBtnStorage;
    private Button mBtnSharedPreferences;
    private Button mBtnSQLite;
    private final static String SWITCH_STATUS = "SwitchStatus";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_database);

        initView();
        initEventView();

        initSharedPrefenrences();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStorage: {
                UseStorageFragment useStorageFragment = new UseStorageFragment();
                createFragmentStore(useStorageFragment);
                break;
            }
            case R.id.btnSharedPreferences: {
                UseSharedPreferencesFragment fragment = new UseSharedPreferencesFragment();
                Bundle bundle = new Bundle();
                //get du lieu tu SharedPreferences voi key va defauValue
                boolean b = mSharedPreferences.getBoolean(SWITCH_STATUS, true);
                bundle.putBoolean(SWITCH_STATUS, b);
                fragment.setArguments(bundle);
                createFragmentStore(fragment);
                break;
            }
            case R.id.btnSQLite: {
                UseSQLiteFragment fragment = new UseSQLiteFragment();
                createFragmentStore(fragment);
                break;
            }
        }
    }

    private void createFragmentStore(Fragment fragment) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.flDatabase, fragment);
        mFragmentTransaction.commit();
    }

    private void initEventView() {
        mBtnSQLite.setOnClickListener(this);
        mBtnSharedPreferences.setOnClickListener(this);
        mBtnStorage.setOnClickListener(this);
    }

    private void initView() {
        mBtnStorage = findViewById(R.id.btnStorage);
        mBtnSharedPreferences = findViewById(R.id.btnSharedPreferences);
        mBtnSQLite = findViewById(R.id.btnSQLite);
    }

    private void initSharedPrefenrences() {
        //Khoi tao bien Luu tru du lieu
        mSharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    private void putData(boolean b) {
        //Khoi tao doi tuong Editor de co the ghi vao file du lieu
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        //X:float, string, int, boolean, long; key:Ten bien; value :gia tri cua bien
        editor.putBoolean(SWITCH_STATUS, b);
        //commit() hoac apply() de luu thay doi, apply() se ton it thoi gian de luu hon
        editor.apply();
    }

    @Override
    public void onSwitchCheckChanged(boolean isCheked) {
        Log.e(TAG, "onSwitchCheckChanged:" + isCheked);
        putData(isCheked);
    }
}
