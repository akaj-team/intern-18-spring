package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class InformationSingerActivity extends AppCompatActivity {
    private ImageView mImgSinger;
    private TextView mTvSingerName;
    private TextView mTvNumberTracker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinformationsinger);
        initView();
        initInformationSinger();
    }

    public void initView() {
        mImgSinger = findViewById(R.id.imgSinger);
        mTvSingerName = findViewById(R.id.tvSingerName);
        mTvNumberTracker = findViewById(R.id.tvNumberTracker);
    }

    @SuppressLint("SetTextI18n")
    public void initInformationSinger() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String imgSinger = bundle.getString(String.valueOf(R.string.imagesinger));
            Glide.
                    with(this)
                    .load(imgSinger)
                    .override(250, 250)
                    .centerCrop()
                    .into(mImgSinger);
            mTvSingerName.setText(bundle.getString(String.valueOf(R.string.singername)));
            mTvNumberTracker.setText(String.valueOf(bundle.getInt(String.valueOf(R.string.numbertracker))) + " Trackers");
        }
    }
}
