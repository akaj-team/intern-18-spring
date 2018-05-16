package vn.asiantech.internship;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SharePreferencesActivity extends AppCompatActivity {
    private ItemSaveStatusFragment mItemSaveStatusFragment;
    private ItemSaveTextFragment mItemSaveTextFragment;
    private ItemDatabaseFragment mItemDatabaseFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreferences);
        mItemSaveStatusFragment = new ItemSaveStatusFragment();
        mItemSaveTextFragment = new ItemSaveTextFragment();
        mItemDatabaseFragment = new ItemDatabaseFragment();
        final FragmentManager fragmentManager = getFragmentManager();


        Button btnSaveStatus = findViewById(R.id.btnSaveStatus);
        btnSaveStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.acDatabase, mItemSaveStatusFragment).commit();
            }
        });

        Button btnSaveText = findViewById(R.id.btnSaveText);
        btnSaveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.acDatabase, mItemSaveTextFragment).commit();
            }
        });

        Button btnDatabase = findViewById(R.id.btnDatabase);
        btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction().replace(R.id.acDatabase, mItemDatabaseFragment).commit();
            }
        });
    }
}
