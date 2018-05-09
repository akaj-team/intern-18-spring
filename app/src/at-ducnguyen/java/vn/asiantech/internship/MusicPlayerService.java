package vn.asiantech.internship;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.RemoteViews;

public class MusicPlayerService extends Service {
    private static final String CHANNEL_DEFAULT_IMPORTANCE = " MUSIC APP";
    private static final String CLOSE_ACTION = "CLOSE ACTION";
    private static final String PLAY_PAUSE_ACTION = "PLAY PAUSE ACTION";
    private static final int NOTIFICATION_ID = 0;
    private MediaPlayer mMediaPlayer;
    private Handler mHandler;
    private Runnable mRunable;
    private RemoteViews mNotifycationView;
    private NotificationManager mNotificationManager;
    private NotificationCompat.Builder mBuilder;
    private BroadcastReceiver mPlayPauseReceiver;
    private BroadcastReceiver mCloseReceiver;
    private Intent mSongIntent;

    public MusicPlayerService() {
        mHandler = new Handler();
        mRunable = new Runnable() {
            @Override
            public void run() {
                Intent durationIntent = new Intent(MusicActivity.DURATION_ACTION);
                durationIntent.putExtra(MusicActivity.DURATION_KEY, mMediaPlayer.getCurrentPosition());
                LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(durationIntent);
                mNotifycationView.setTextViewText(R.id.tvTime, getDurationMS(mMediaPlayer.getCurrentPosition()));
                mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
                mHandler.postDelayed(mRunable, 1000);
            }
        };
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSongIntent = new Intent(MusicActivity.SONG_ACTION);

        mCloseReceiver = new CloseButtonClickListener();
        registerReceiver(mCloseReceiver, new IntentFilter(CLOSE_ACTION));
        Intent closeIntent = new Intent(CLOSE_ACTION);
        PendingIntent closePendingIntent = PendingIntent.getBroadcast(this, 0, closeIntent, 0);

        mPlayPauseReceiver = new PlayPauseButtonClickListener();
        registerReceiver(mPlayPauseReceiver, new IntentFilter(PLAY_PAUSE_ACTION));
        Intent playPauseIntent = new Intent(PLAY_PAUSE_ACTION);
        PendingIntent playPausePendingIntent = PendingIntent.getBroadcast(this, 0, playPauseIntent, 0);

        mNotifycationView = new RemoteViews(getPackageName(), R.layout.remote_view_music_player);

        mNotifycationView.setOnClickPendingIntent(R.id.btnClose, closePendingIntent);
        mNotifycationView.setTextViewText(R.id.btnPlayPause, getString(R.string.pause));
        mNotifycationView.setOnClickPendingIntent(R.id.btnPlayPause, playPausePendingIntent);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.song_save), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                editor.putString(MusicActivity.SONG_PATH, bundle.getString(MusicActivity.SONG_PATH));
                editor.putString(MusicActivity.SONG_NAME, bundle.getString(MusicActivity.SONG_NAME));
                editor.putString(MusicActivity.SONG_ARTIST, bundle.getString(MusicActivity.SONG_ARTIST));
                editor.putInt(MusicActivity.DURATION_POSITION, bundle.getInt(MusicActivity.DURATION_POSITION));
                editor.apply();
            }
        }
        Uri pathSong = Uri.parse(sharedPreferences.getString(MusicActivity.SONG_PATH, null));
        String nameSong = sharedPreferences.getString(MusicActivity.SONG_NAME, null);
        String artistSong = " - " + sharedPreferences.getString(MusicActivity.SONG_ARTIST, null);
        int positionDuration = sharedPreferences.getInt(MusicActivity.DURATION_POSITION, 0);

        mNotifycationView.setTextViewText(R.id.tvTitle, nameSong);
        mNotifycationView.setTextViewText(R.id.tvArtist, artistSong);

        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
        mMediaPlayer = MediaPlayer.create(getBaseContext(), pathSong);
        mMediaPlayer.start();
        mMediaPlayer.seekTo(positionDuration);
        showNotification();
        mRunable.run();
        return START_STICKY;
    }

    public class PlayPauseButtonClickListener extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (mMediaPlayer.isPlaying()) {
                mSongIntent.putExtra(MusicActivity.SONG_ACTION, R.string.play);
                mMediaPlayer.pause();
                mNotifycationView.setTextViewText(R.id.btnPlayPause, getString(R.string.play));
                mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            } else {
                mSongIntent.putExtra(MusicActivity.SONG_ACTION, R.string.pause);
                mMediaPlayer.start();
                mNotifycationView.setTextViewText(R.id.btnPlayPause, getString(R.string.pause));
                mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
            }
            LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(mSongIntent);
        }
    }

    public class CloseButtonClickListener extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!mMediaPlayer.isPlaying()) {
                mSongIntent.putExtra(MusicActivity.SONG_ACTION, R.string.play);
                LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(mSongIntent);
                mHandler.removeCallbacks(mRunable);
                mMediaPlayer.stop();
                stopSelf();
                mNotificationManager.cancel(NOTIFICATION_ID);
            }
        }
    }

    private void showNotification() {
        mBuilder = new NotificationCompat.Builder(this, CHANNEL_DEFAULT_IMPORTANCE)
                .setSmallIcon(R.drawable.ic_library_music_black_24dp)
                .setContent(mNotifycationView);
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (mNotificationManager != null) {
            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
        }
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(mPlayPauseReceiver);
        unregisterReceiver(mCloseReceiver);
        mNotificationManager.cancelAll();
        mHandler.removeCallbacks(mRunable);
        mMediaPlayer.stop();
        stopSelf();
        super.onDestroy();
    }

    public String getDurationMS(int duration) {
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
}
