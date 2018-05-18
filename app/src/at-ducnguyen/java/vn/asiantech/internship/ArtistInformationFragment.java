package vn.asiantech.internship;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


public class ArtistInformationFragment extends Fragment {
    private ImageView mImgThumb;
    private TextView mTvName;
    private TextView mTvTracker;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_artist_information, container, false);
        initViews();
        setData();
        return mView;
    }

    private void initViews() {
        mImgThumb = mView.findViewById(R.id.imgThumb);
        mTvName = mView.findViewById(R.id.tvName);
        mTvTracker = mView.findViewById(R.id.tvTracker);
    }

    private void setData() {
        Bundle bundle = getArguments();
        String url = bundle.getString(ArtistInfomationActivity.ARTIST_THUMB);
        if (url != null) {
            Glide.with(getActivity())
                    .load(url)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error_loading)
                    .into(mImgThumb);
        }
        mTvName.setText(bundle.getString(ArtistInfomationActivity.ARTIST_NAME));
        mTvTracker.setText(bundle.getString(ArtistInfomationActivity.ARTIST_TRACK_COUNT));
    }
}
