package vn.asiantech.internship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

import vn.asiantech.internship.model.Song;

public class MusicActivity extends AppCompatActivity implements
        OnLoadPlayListListener, OnChooseSongListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public static final String SONG_PATH = "SONG PATH";
    public static final String SONG_NAME = "SONG NAME";
    public static final String SONG_ARTIST = "SONG ARTIST";
    public static final String SONG_ACTION = "SONG ACTION";
    public static final String DURATION_KEY = "DURATION KEY";
    public static final String DURATION_ACTION = "DURATION ACTION";
    public static final String DURATION_POSITION = "DURATION POSITION";
    private Intent mServiceIntent;
    private SeekBar mSeekBarDuration;
    private BroadcastReceiver mDurationReceiver;
    private BroadcastReceiver mSongStateReceiver;
    private Button mBtnPlayPause;
    private TextView mTvDurationTime;
    private TextView mTvPositionTime;
    private TextView mTvPlayingSong;
    private int mPositionDuration;
    private Song mSong;
    private String mPathOfSongPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mPositionDuration = 0;

        mSeekBarDuration = findViewById(R.id.seekBarDuration);
        mSeekBarDuration.setOnSeekBarChangeListener(this);

        mBtnPlayPause = findViewById(R.id.btnPlayPause);
        mBtnPlayPause.setOnClickListener(this);

        mTvDurationTime = findViewById(R.id.tvDurationTime);
        mTvPositionTime = findViewById(R.id.tvPositionTime);
        mTvPlayingSong = findViewById(R.id.tvPlayingSong);

        LoadPlayListTask loadPlayListTask = new LoadPlayListTask(this);
        loadPlayListTask.setOnLoadPlayListListener(this);
        loadPlayListTask.execute();

        mDurationReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    mSeekBarDuration.setProgress(bundle.getInt(DURATION_KEY));
                    mTvPositionTime.setText(getDurationMS(bundle.getInt(DURATION_KEY)));
                }
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(mDurationReceiver, new IntentFilter(DURATION_ACTION));
        mSongStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    if (isPlaying(mSong.getPath())) {
                        mBtnPlayPause.setText(bundle.getInt(SONG_ACTION));
                    }
                }
            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(mSongStateReceiver, new IntentFilter(SONG_ACTION));
    }

    @Override
    public void onGetPlayList(List<Song> listSong) {
        ListMusicAdapter listMusicAdapter = new ListMusicAdapter(listSong, this);
        RecyclerView recyclerViewListMusic = findViewById(R.id.recyclerViewListMusic);
        recyclerViewListMusic.setAdapter(listMusicAdapter);
        recyclerViewListMusic.setLayoutManager(new LinearLayoutManager(this));
        mServiceIntent = new Intent(MusicActivity.this, MusicPlayerService.class);
    }

    @Override
    public void onChooseSong(Song song) {
        mSong = song;
        if (isPlaying(song.getPath())) {
            mBtnPlayPause.setText(R.string.pause);
        } else {
            mBtnPlayPause.setText(R.string.play);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mServiceIntent.putExtra(DURATION_POSITION, mSeekBarDuration.getProgress());
        startService(mServiceIntent);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mDurationReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mSongStateReceiver);
    }

    @Override
    public void onClick(View view) {
        if (mBtnPlayPause.getText().toString().equals(getString(R.string.play))) {
            if (!isPlaying(mSong.getPath())) {
                mPositionDuration = 0;
            }
            String nameOfSongPlaying = mSong.getTitle() + " - " + mSong.getArtist();
            mPathOfSongPlaying = mSong.getPath();

            mServiceIntent.putExtra(SONG_PATH, mPathOfSongPlaying);
            mServiceIntent.putExtra(SONG_NAME, mSong.getTitle());
            mServiceIntent.putExtra(SONG_ARTIST, mSong.getArtist());
            mServiceIntent.putExtra(DURATION_POSITION, mPositionDuration);

            mSeekBarDuration.setMax(mSong.getDuration());
            mTvDurationTime.setText(mSong.getDurationMS());
            mTvPlayingSong.setText(nameOfSongPlaying);

            stopService(mServiceIntent);
            startService(mServiceIntent);
            mBtnPlayPause.setText(R.string.pause);
        } else {
            mPositionDuration = mSeekBarDuration.getProgress();
            stopService(mServiceIntent);
            mBtnPlayPause.setText(R.string.play);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (b) {
            mServiceIntent.putExtra(DURATION_POSITION, i);
            startService(mServiceIntent);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private String getDurationMS(int duration) {
        int hours = duration / 3600000;
        int temp = duration - hours * 3600000;
        int mins = temp / 60000;
        int secs = (temp - mins * 60000) / 1000;
        if (hours == 0) {
            return mins + ":" + secs;
        } else {
            return hours + ":" + mins + ":" + secs;
        }
    }

    private boolean isPlaying(String path) {
        return mPathOfSongPlaying != null && mPathOfSongPlaying.equals(path);
    }
}
