package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoSingerActivity extends AppCompatActivity {
    public static final String KEY_SINGER_NAME = "SingerName";
    public static final String KEY_SINGER_TRACK = "SingerTrack";
    public static final String KEY_SINGER_IMGURL = "SingerImageUrl";

    private ImageView mImgSinger;
    private TextView mTvNameSinger;
    private TextView mTvCountTrack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_info);
        initViews();
        initDataView();
    }

    public void initViews() {
        mImgSinger = findViewById(R.id.imgSinger);
        mTvNameSinger = findViewById(R.id.tvNameSinger);
        mTvCountTrack = findViewById(R.id.tvCountTrackers);
    }

    @SuppressLint("SetTextI18n")
    public void initDataView() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            mTvNameSinger.setText(bundle.getString(KEY_SINGER_NAME));
            mTvCountTrack.setText((String.valueOf(bundle.getInt(KEY_SINGER_TRACK))) + " Tracks");
            String urlImg = bundle.getString(KEY_SINGER_IMGURL);
            Picasso.with(this)
                    .load(urlImg)
                    .placeholder(R.drawable.ic_cloud_download_red_400_24dp)
                    .error(R.drawable.ic_error_outline_red_400_24dp)
                    .into(mImgSinger);
        }
    }
}
