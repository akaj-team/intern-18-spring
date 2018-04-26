package vn.asiantech.internship;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ItemSaveTextActivity extends AppCompatActivity implements View.OnClickListener {
    private final String SHARED_PREFERENCES_NAME = "sharepreferencesSaveText";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private EditText mEdtText;
    private Button mBtnSaveText;
    private TextView mTvShowText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_save_text);
        mEdtText = findViewById(R.id.edtText);
        mBtnSaveText = findViewById(R.id.btnSaveText);
        mTvShowText = findViewById(R.id.tvShowText);
        initPreferences();

        String saveText = sharedPreferences.getString("DATA", "");
        mEdtText.setText(saveText);
        mTvShowText.setText(saveText);

        mBtnSaveText.setOnClickListener(this);
    }

    private void initPreferences() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View view) {
        if (view == mBtnSaveText) {
            String data = mTvShowText.getText().toString();
            String data1 = mEdtText.getText().toString();
            editor.putString("DATA", data);
            editor.putString("DATA", data1);
            editor.apply();
        }
    }
}
