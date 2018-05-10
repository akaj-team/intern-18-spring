package vn.asiantech.internship.api;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import vn.asiantech.internship.R;

public class ApiActivity extends Activity {
    public static final String NAME_ARTIST = "NameArt";

    private EditText mEdtCheck;
    private Button mBtnCheck;
    private ConstraintLayout mLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_api);
        initViews();
        setListenners();
    }

    void initViews() {
        mBtnCheck = findViewById(R.id.btnCheck);
        mEdtCheck = findViewById(R.id.edtArtistName);
        mLayout = findViewById(R.id.clEditFont);
        showView(true);
    }

    void setListenners() {
        mBtnCheck.setOnClickListener((view) -> {
            if (!TextUtils.isEmpty(mEdtCheck.getText().toString().trim())) {
                showView(false);
                ArtistInfoFragment artistInfoFragment = new ArtistInfoFragment();
                Bundle data = new Bundle();
                data.putString(NAME_ARTIST, mEdtCheck.getText().toString());
                artistInfoFragment.setArguments(data);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.clAPI, artistInfoFragment)
                        .addToBackStack(artistInfoFragment.getClass().getSimpleName()).commit();
            }
        });
    }

    void showView(boolean isShow) {
        if (isShow) {
            mLayout.setX(0);
        } else {
            mLayout.setX(-mLayout.getWidth());
        }
    }
}
