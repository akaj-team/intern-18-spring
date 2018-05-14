package vn.asiantech.internship;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class ServicesActivity extends AppCompatActivity {

    public static Button mBtnPlay;
    public static SeekBar mSeekBar;
    public static TextView mTvTimeSong;
    public static TextView mTvTotalOfSong;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        initView();
        mIntent = new Intent(ServicesActivity.this, MusicServices.class);
        startService(mIntent);
    }

    private void initView() {
        mBtnPlay = findViewById(R.id.btnPlay);
        mSeekBar = findViewById(R.id.seekBar);
        mTvTimeSong = findViewById(R.id.tvTimeSong);
        mTvTotalOfSong = findViewById(R.id.tvTotalOfSong);
    }

    @Override
    protected void onDestroy() {
        if (!MusicServices.mMediaPlayer.isPlaying()) {
            MusicServices.mMediaPlayer.stop();
            stopService(mIntent);
        } else {
            mBtnPlay.setText(R.string.pause);
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        try {
            if (!MusicServices.mMediaPlayer.isPlaying()) {
                mBtnPlay.setText(R.string.play);
            } else {
                mBtnPlay.setText(R.string.pause);
            }
        } catch (Exception e) {
            Log.d("TAG", "" + e.getMessage());
        }
        super.onResume();
    }

}
