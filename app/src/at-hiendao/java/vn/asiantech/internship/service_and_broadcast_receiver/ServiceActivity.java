package vn.asiantech.internship.service_and_broadcast_receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

import vn.asiantech.internship.R;


public class ServiceActivity extends Activity {
    public static final String TAG = "123";
    private TextView mTvCurrentTime;
    private TextView mTvTotalTime;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_and_broadcast_receiver);
        initView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            showMusicPlay(intent);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void initView() {
        Button btnStart = findViewById(R.id.btnStartMusic);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, MusicService.class);
                intent.putExtra(MusicService.PLAY, true);
                startService(intent);
            }
        });
        Button btnStop = findViewById(R.id.btnPauseMusic);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, MusicService.class);
                intent.putExtra(MusicService.PAUSE, true);
                startService(intent);
            }
        });
        mTvTotalTime = findViewById(R.id.tvTotalTime);
        mTvCurrentTime = findViewById(R.id.tvCurrentTime);
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(TAG, "onStopTrackingTouch: " + seekBar.getProgress() );
                Intent intent = new Intent();
                intent.setAction(MusicService.CURRENT_TIME);
                intent.putExtra(MusicService.CURRENT_TIME, seekBar.getProgress());
                sendBroadcast(intent);
            }
        });
        Intent intent = new Intent(ServiceActivity.this, MusicService.class);
        startService(intent);
    }


    private void showMusicPlay(Intent intent) {
        if (intent.getExtras() != null) {
            float currentTime = intent.getExtras().getFloat(MusicService.CURRENT_TIME);
            float totalTime = intent.getExtras().getFloat(MusicService.TOTAL_TIME);
            mTvCurrentTime.setText(String.format(Locale.ENGLISH, "%02d:%02d", (int) (currentTime / 1000) / 60, (int) (currentTime / 1000) % 60));
            mTvTotalTime.setText(String.format(Locale.ENGLISH, "%02d:%02d", (int) (totalTime / 1000) / 60, (int) (totalTime / 1000) % 60));
            int percent = (int) (currentTime / totalTime * 100);
            mSeekBar.setProgress(percent);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(broadcastReceiver, new IntentFilter("notification"));
    }

}
