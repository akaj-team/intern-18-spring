package vn.asiantech.internship.api;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import vn.asiantech.internship.R;

public class InformationSingerActivity extends AppCompatActivity {
    public static final String IMAGE_SINGER = "image_singer";
    public static final String SINGER_NAME = "singer_name";
    public static final String NUMBER_TRACKER = "number_tracker";
    private ImageView mImgSinger;
    private TextView mTvSingerName;
    private TextView mTvNumberTracker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_singer);
        initViews();
        initInformationSinger();
    }

    private void initViews() {
        mImgSinger = findViewById(R.id.imgSinger);
        mTvSingerName = findViewById(R.id.tvSingerName);
        mTvNumberTracker = findViewById(R.id.tvNumberTracker);
    }

    @SuppressLint("SetTextI18n")
    public void initInformationSinger() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String imgSinger = bundle.getString(IMAGE_SINGER);
            Glide.with(this)
                    .load(imgSinger)
                    .override(250, 250)
                    .centerCrop()
                    .into(mImgSinger);
            mTvSingerName.setText(bundle.getString(SINGER_NAME));
            mTvNumberTracker.setText(bundle.getInt(NUMBER_TRACKER) + " Tracks");
        }
    }
}
