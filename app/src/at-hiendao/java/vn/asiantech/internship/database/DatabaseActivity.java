package vn.asiantech.internship.database;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import vn.asiantech.internship.R;

public class DatabaseActivity extends Activity {
    Button mBtnSwitch;
    Button mBtnSaveText;
    Button mBtnSaveTable;

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
                SaveTableFragment saveTableFragment = new SaveTableFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.clDatabase, saveTableFragment).addToBackStack(null).commit();
                showDatabaseLayout(false);
            }
        });
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

}

