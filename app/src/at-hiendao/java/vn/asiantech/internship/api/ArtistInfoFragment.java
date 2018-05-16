package vn.asiantech.internship.api;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.asiantech.internship.R;

public class ArtistInfoFragment extends Fragment {
    private static final String APP_ID = "123";
    private static final String TEXT_TRACKER = "Tracker";
    private static final String TAG = ArtistInfoFragment.class.getSimpleName();

    private ImageView mImgAvatar;
    private TextView mTvNumOfTrack;
    private TextView mTvNameArtist;
    private ConstraintLayout mLoadProgressLayout;
    private ConstraintLayout mArtistLayout;
    private LoadImageAsync mLoadImageAsync = new LoadImageAsync();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist_info, container, false);
        initViews(view);
        Bundle data = getArguments();
        loadData(data.getString(ApiActivity.NAME_ARTIST));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Activity activity = getActivity();
        if (activity instanceof ApiActivity) {
            ((ApiActivity) activity).showViews(true);
        }
        super.onDestroyView();
    }

    private void initViews(View view) {
        mImgAvatar = view.findViewById(R.id.imgAvatarArtist);
        mTvNumOfTrack = view.findViewById(R.id.tvNumberTracker);
        mTvNameArtist = view.findViewById(R.id.tvNameArtist);
        mLoadProgressLayout = view.findViewById(R.id.clLoadArtistInfo);
        mArtistLayout = view.findViewById(R.id.clArtistInfo);
    }

    private void loadData(String name) {
        showLoadProgress(true);
        ServiceApi.getInstance().getRequest().getData(name, APP_ID).enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(@NonNull Call<ResponseData> call, @NonNull Response<ResponseData> response) {
                ResponseData responseData = response.body();
                showLoadProgress(false);
                if (responseData != null) {
                    try {
                        mImgAvatar.setImageBitmap(mLoadImageAsync.execute(responseData.getImageUrl()).get());
                    } catch (InterruptedException e) {
                        Log.e(TAG, "InterruptedException: " + e.toString());
                    } catch (ExecutionException e) {
                        Log.e(TAG, "ExecutionException: " + e.toString());
                    }
                    mTvNumOfTrack.setText(String.format(Locale.ENGLISH, "%,d %s", responseData.getTrackerCount(), TEXT_TRACKER));
                    mTvNameArtist.setText(responseData.getName());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseData> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: ");
                showLoadProgress(false);
            }
        });
    }

    private void showLoadProgress(boolean isShow) {
        if (isShow) {
            mLoadProgressLayout.setAlpha(1);
            mArtistLayout.setX(-mArtistLayout.getWidth());
        } else {
            mArtistLayout.setX(0);
            mLoadProgressLayout.setAlpha(0);
        }
    }
}
