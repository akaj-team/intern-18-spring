package vn.asiantech.internship.api;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import vn.asiantech.internship.R;

import static vn.asiantech.internship.api.ArtistInfoFragment.TAG;

public class ApiActivity extends Activity {
    private EditText mEdtCheck;
    private ConstraintLayout mLayout;
    public static final String NAME_ARTIST = "NameArt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_api);
        initView();
    }

    void initView() {
        Button btnCheck = findViewById(R.id.btnCheck);
        mEdtCheck = findViewById(R.id.edtArtistName);
        mLayout = findViewById(R.id.clEditFont);
        btnCheck.setOnClickListener((view) ->
        {
            if (!TextUtils.isEmpty(mEdtCheck.getText().toString())) {
                Log.e(TAG, "initView: " + mEdtCheck.getText().toString() );
                showView(false);
                ArtistInfoFragment artistInfoFragment = new ArtistInfoFragment();
                Bundle data = new Bundle();
                data.putString(NAME_ARTIST, mEdtCheck.getText().toString());
                artistInfoFragment.setArguments(data);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.clAPI, artistInfoFragment).addToBackStack(null).commit();
            }
        });
        showView(true);
    }

    void showView(boolean isShow) {
        if (isShow) {
            mLayout.setX(0);
        } else {
            mLayout.setX(-mLayout.getWidth());
        }
    }
}
