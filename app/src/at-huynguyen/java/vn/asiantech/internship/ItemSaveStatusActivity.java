package vn.asiantech.internship;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

public class ItemSaveStatusActivity extends AppCompatActivity {
    private final String SHARED_PREFERENCES_NAME = "sharepreferences";
    private final String IS_STATUS = "is_status";
    private Switch mSwSaveStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_save_status);
        mSwSaveStatus = findViewById(R.id.swSaveStatus);
        loadData();
    }

    public void addData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_STATUS, false);

        editor.apply();
        Toast.makeText(ItemSaveStatusActivity.this, "Save Successfully", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            boolean isStatus = sharedPreferences.getBoolean(IS_STATUS, false);
            Log.d("zxc", "Status: "+isStatus );
        }
    }

}
