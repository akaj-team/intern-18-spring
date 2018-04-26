package vn.asiantech.internship.database;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import vn.asiantech.internship.R;

public class DatabaseActivity extends Activity {
    Button mBtnSwitch;
    Button mBtnSaveText;
    Button mBtnSaveTable;
    private static final String TAG = "test";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        settingButtonListener();

    }

    private void settingButtonListener() {
        mBtnSwitch = findViewById(R.id.btnSwitch);
        mBtnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateButtonFragment stateButtonFragment = new StateButtonFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.clDatabase, stateButtonFragment).addToBackStack(null).commit();
                showDatabaseLayout(false);
            }
        });

        mBtnSaveText = findViewById(R.id.btnSaveText);
        mBtnSaveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveTextFragment saveTextFragment = new SaveTextFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.clDatabase, saveTextFragment).addToBackStack(null).commit();
                showDatabaseLayout(false);
            }
        });

        mBtnSaveTable = findViewById(R.id.btnSaveTable);
        mBtnSaveTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );
    }

    public void showDatabaseLayout(boolean isShow) {
        if (isShow) {
            mBtnSwitch.setX(0);
            mBtnSaveText.setX(0);
            mBtnSaveTable.setX(0);
        } else {
            mBtnSwitch.setX(-mBtnSwitch.getWidth());
            mBtnSaveText.setX(-mBtnSaveText.getWidth());
            mBtnSaveTable.setX(-mBtnSaveTable.getWidth());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(TAG, "onBackPressed: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }
}

