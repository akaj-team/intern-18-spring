package vn.asiantech.internship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener
        , SeekBar.OnSeekBarChangeListener {
    private static final String SEEBARPROGRESS = "seeBarProgress";
    private static final String ACTIONSEEKBARCHANGE = "seekBarListenes";
    private static final String STATUSMEDIA = "mediaIsPlaying";
    private static final String CURRENTPOSITION = "currentPosition";
    private static final String SONGISPLAY = "SONGISPLAY";
    private static final String TAG = "PlayMusicActivity";
    private static final String PAUSE = "Pause";
    private static final String PLAY = "Play";
    private static final String NAMESONG = "NameSong";
    private static final String DURATIONSONG = "DurationSong";
    private static final String ACTIONPLAYMUSIC = "actionPlayMusic";
    private static final String ACTIONPAUSEMUSIC = "actionPauseMusic";

    //View
    private SeekBar mSeebarTimeMusic;
    private TextView mTvTimeCount;
    private TextView mTvTimeCountDown;
    private Button mBtnPlayMusic;
    private TextView mTvNameSong;
    BroadcastReceiver mIntentReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_service_broadcastreceiver);

        initView();
        initEventView();
        initBroadcastReceiver();
    }

    private void initBroadcastReceiver() {
        mIntentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e(TAG, "onReceive: " + intent.getAction());
                if (intent.getAction() != null) {
                    switch (intent.getAction()) {
                        case SONGISPLAY: {
                            extraInfoSongWhenRunning(intent);
                            break;
                        }
                    }
                }
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SONGISPLAY);
        registerReceiver(mIntentReceiver, intentFilter);
    }

    public void initView() {
        mTvTimeCount = findViewById(R.id.tvTimeCount);
        mTvTimeCountDown = findViewById(R.id.tvTimeCountDown);
        mBtnPlayMusic = findViewById(R.id.btnPlayMusic);
        mTvNameSong = findViewById(R.id.tvNameSong);

        //Seekbar
        mSeebarTimeMusic = findViewById(R.id.seekbarTimeMusic);
        mSeebarTimeMusic.setClickable(false);
        mSeebarTimeMusic.setMax(0);
    }

    private void initEventView() {
        mBtnPlayMusic.setOnClickListener(this);
        mSeebarTimeMusic.setOnSeekBarChangeListener(this);
    }

    private void extraInfoSongWhenRunning(Intent intent) {
        int durationSong = intent.getIntExtra(DURATIONSONG, 0);
        mSeebarTimeMusic.setMax(durationSong);
        mTvTimeCountDown.setText(miliSecondsToString(durationSong));
        mTvNameSong.setText(intent.getStringExtra(NAMESONG));

        int currentPosition = intent.getIntExtra(CURRENTPOSITION, -1);
        updateSeekBar(currentPosition);
        changeStatusButtonPlay(intent.getBooleanExtra(STATUSMEDIA, true));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlayMusic: {
                onButtonPlayClick();
            }
        }
    }

    private void onButtonPlayClick() {
        switch (mBtnPlayMusic.getText().toString()) {
            case PAUSE: {
                sendActionToServices(ACTIONPAUSEMUSIC);
                break;
            }
            case PLAY: {
                sendActionToServices(ACTIONPLAYMUSIC);
                break;
            }
        }
    }

    private String miliSecondsToString(int miliseconds) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) miliseconds);
        long seconds = (TimeUnit.MILLISECONDS.toSeconds((long) miliseconds)) % 60;
        return minutes + ":" + seconds;
    }

    private void updateSeekBar(int currentPosition) {
        mSeebarTimeMusic.setProgress(currentPosition);
    }

    private void sendActionToServices(String action) {
        Intent musicServices = new Intent(this, MusicServices.class);
        musicServices.setAction(action);
        startService(musicServices);
    }

    private void changeStatusButtonPlay(boolean isPlaying) {
        if (isPlaying) {
            mBtnPlayMusic.setText(PAUSE);
        } else {
            mBtnPlayMusic.setText(PLAY);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mIntentReceiver);
        Log.e(TAG, "onStop: ");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTvTimeCount.setText(miliSecondsToString(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.e(TAG, "onStopTrackingTouch: " + seekBar.getProgress());
        Intent intent = new Intent(this, MusicServices.class);
        intent.setAction(ACTIONSEEKBARCHANGE);
        intent.putExtra(SEEBARPROGRESS, seekBar.getProgress());
        startService(intent);
    }
}
