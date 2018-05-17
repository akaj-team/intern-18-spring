package vn.asiantech.internship;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import vn.asiantech.internship.api.ApiService;
import vn.asiantech.internship.api.ArtistAPI;
import vn.asiantech.internship.model.Artist;
import vn.asiantech.internship.model.ErrorFragment;

public class ArtistInfomationActivity extends AppCompatActivity implements Callback<Artist> {
    public static final String ARTIST_NAME = "artist_name";
    public static final String ARTIST_THUMB = "artist_thumb";
    public static final String ARTIST_TRACK_COUNT = "artist_track_count";

    private static final String APP_ID = "nmduc3";

    private EditText mEdtArtistName;
    private Button mBtnSearch;

    private LoadingFragment mLoadingFragment;
    private ErrorFragment mErrorFragment;
    private ArtistInformationFragment mArtistInformationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_infomation);

        initViews();
        setListeners();
    }

    private void initViews() {
        mEdtArtistName = findViewById(R.id.edtArtistName);
        mBtnSearch = findViewById(R.id.btnSearch);

        mLoadingFragment = new LoadingFragment();
        mErrorFragment = new ErrorFragment();
        mArtistInformationFragment = new ArtistInformationFragment();
    }

    private void setListeners() {
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService apiService = new ApiService();
                ArtistAPI artistAPI = apiService.getArtistAPI();
                Call<Artist> artistCall = artistAPI.getArtistByName(mEdtArtistName.getText().toString().trim(), APP_ID);
                artistCall.enqueue(ArtistInfomationActivity.this);
                mEdtArtistName.onEditorAction(EditorInfo.IME_ACTION_DONE);
                showFragment(mLoadingFragment);
            }
        });
    }

    @Override
    public void onResponse(Response<Artist> response, Retrofit retrofit) {
        Artist artist = response.body();
        if (artist != null) {
            Bundle bundle = new Bundle();
            bundle.putString(ArtistInfomationActivity.ARTIST_NAME, artist.getName());
            bundle.putString(ArtistInfomationActivity.ARTIST_THUMB, artist.getThumbUrl());
            bundle.putString(ArtistInfomationActivity.ARTIST_TRACK_COUNT, artist.getTrackerCount());
            mArtistInformationFragment.setArguments(bundle);
            showFragment(mArtistInformationFragment);
        } else {
            showFragment(mErrorFragment);
        }

    }

    @Override
    public void onFailure(Throwable t) {
        showFragment(mErrorFragment);
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }
}
