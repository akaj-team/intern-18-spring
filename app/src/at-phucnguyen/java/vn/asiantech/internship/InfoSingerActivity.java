package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoSingerActivity extends AppCompatActivity {
    private static final String TAG = "InfoSingerActivity";

    private ImageView mImgSinger;
    private TextView mTvNameSinger;
    private TextView mTvCountTrack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_info);

        initView();
        initDataView();
    }

    public void initView() {
        mImgSinger = findViewById(R.id.imgSinger);
        mTvNameSinger = findViewById(R.id.tvNameSinger);
        mTvCountTrack = findViewById(R.id.tvCountTrackers);
    }

    @SuppressLint("SetTextI18n")
    public void initDataView() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            mTvNameSinger.setText(bundle.getString(String.valueOf(R.string.key_singername)));
            mTvCountTrack.setText((String.valueOf(bundle.getInt(String.valueOf(R.string.key_singertrack)))) + " Tracks");
            String urlImg = bundle.getString(String.valueOf(R.string.key_singer_url_img));
            Log.e(TAG, "initDataView: " + urlImg);
            Picasso.with(this)
                    .load(urlImg)
                    .placeholder(R.drawable.ic_cloud_download_red_400_24dp)
                    .error(R.drawable.ic_error_outline_red_400_24dp)
                    .into(mImgSinger);
        }
    }
}
