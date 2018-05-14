package vn.asiantech.internship;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MusicServices extends Service implements View.OnClickListener, MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener {
    public static MediaPlayer mMediaPlayer;
    public static WeakReference<Button> mBtnPlay;
    public static WeakReference<TextView> mTvTimeSong;
    public static WeakReference<TextView> mTvTotalOfSong;
    public static WeakReference<SeekBar> mSeekbar;
    private static final String NOTIFY_PLAY = "vn.asiantech.internship.play";
    private static final String NOTIFY_PAUSE = "vn.asiantech.internship.pause";
    private static final String NOTIFY_DELETE = "vn.asiantech.internship.delete";
    private static final int NOTIFICATION_ID = 1;
    private static final String TAG = "Music_Services";


    static Handler mHandler = new Handler();
    private boolean isPause = false;
    private RemoteViews mRemoteViews;
    private NotificationManager mNotificationManager;
    private Notification.Builder mNotification;
    private PendingIntent mIntentPlay;
    private PendingIntent mIntentPause;
    private PendingIntent mIntentDelete;

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
        mMediaPlayer.reset();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        initNotification();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initView();
        super.onStart(intent, startId);
        String action = intent.getAction();
        if (action != null) {
            switch (intent.getAction()) {
                case NOTIFY_PLAY: {
                    playMusicNotification();
                    mBtnPlay.get().setText(R.string.pause);
                    break;
                }
                case NOTIFY_PAUSE: {
                    pauseMusicNotification();
                    mBtnPlay.get().setText(R.string.play);
                    break;
                }
                case NOTIFY_DELETE: {
                    deleteMusicNotification();
                }
            }
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void playMusicNotification() {
        mMediaPlayer.start();
    }

    private void pauseMusicNotification() {
        mMediaPlayer.pause();
    }

    private void deleteMusicNotification() {
        if (!mMediaPlayer.isPlaying()) {
            stopForeground(true);
            mNotificationManager.cancel(NOTIFICATION_ID);
        }
    }

    private void initView() {
        mBtnPlay = new WeakReference<>(ServicesActivity.mBtnPlay);
        mTvTimeSong = new WeakReference<>(ServicesActivity.mTvTimeSong);
        mTvTotalOfSong = new WeakReference<>(ServicesActivity.mTvTotalOfSong);
        mSeekbar = new WeakReference<>(ServicesActivity.mSeekBar);
        mSeekbar.get().setOnSeekBarChangeListener(this);
        mBtnPlay.get().setOnClickListener(this);
        mMediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.stop();
        super.onDestroy();
    }

    public void playSong() {
        try {
            mMediaPlayer.reset();
            Uri myUri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.music);
            mMediaPlayer.setDataSource(this, myUri);
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    try {
                        mp.start();
                        updateProgressBar();
                        mBtnPlay.get().setText(R.string.pause);
                    } catch (Exception e) {
                        Log.d("TAG", "" + e.getMessage());
                    }
                }
            });

        } catch (Exception e) {
            Log.d(TAG, "" + e.getMessage());
        }
    }

    @Override
    public void onClick(View view) {
        changeImgBtnPauseNoti(mMediaPlayer.isPlaying());
        switch (view.getId()) {
            case R.id.btnPlay:
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    isPause = true;
                    mHandler.removeCallbacks(mUpdateTimeTask);
                    mBtnPlay.get().setText(R.string.play);
                    return;
                }
                if (isPause) {
                    mMediaPlayer.start();
                    isPause = false;
                    updateProgressBar();
                    mBtnPlay.get().setText(R.string.pause);
                }
                if (!mMediaPlayer.isPlaying()) {
                    playSong();
                }
        }
    }

    public void updateProgressBar() {
        try {
            mHandler.postDelayed(mUpdateTimeTask, 100);
        } catch (Exception e) {
            Log.d("TAG", "" + e.getMessage());
        }
    }

    Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            long totalTime;
            long currentTime;

            try {
                totalTime = mMediaPlayer.getDuration();
                currentTime = mMediaPlayer.getCurrentPosition();
                mTvTimeSong.get().setText(Utility.milliSecondsToTimer(currentTime));
                mTvTotalOfSong.get().setText(Utility.milliSecondsToTimer(totalTime));
                int progress = Utility.getProgressPercentage(currentTime, totalTime);
                mSeekbar.get().setProgress(progress);
                mHandler.postDelayed(this, 100);
                changeImgBtnPauseNoti(mMediaPlayer.isPlaying());
                mRemoteViews.setTextViewText(R.id.tvTimeSongNotification, Utility.milliSecondsToTimer(currentTime));
            } catch (Exception e) {
                Log.d(TAG, "" + e.getMessage());
            }

        }
    };

    public class NotificationBroadcastReceiver extends BroadcastReceiver {

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                Intent intentNotify = new Intent(context, MusicServices.class);
                intentNotify.putExtra(MusicServices.NOTIFY_PAUSE, true);
                context.startService(intentNotify);
                mNotificationManager.notify(NOTIFICATION_ID, mNotification.build());
            } else {
                Intent intentNotify = new Intent(context, MusicServices.class);
                intentNotify.putExtra(MusicServices.NOTIFY_DELETE, true);
                context.startService(intentNotify);
                mNotificationManager.notify(NOTIFICATION_ID, mNotification.build());
            }
        }
    }

    private void initNotification() {
        mRemoteViews = new RemoteViews(getPackageName(), R.layout.item_notification);
        Intent notifyIntent = new Intent(this, ServicesActivity.class);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mIntentPlay = setActionForPendingIntent(NOTIFY_PLAY);
        mIntentPause = setActionForPendingIntent(NOTIFY_PAUSE);
        mIntentDelete = setActionForPendingIntent(NOTIFY_DELETE);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mRemoteViews.setOnClickPendingIntent(R.id.imgBtnPlayNotification, mIntentPlay);
        mRemoteViews.setOnClickPendingIntent(R.id.btnDeleteNotification, mIntentDelete);
        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_play_arrow_black)
                .setContent(mRemoteViews)
                .setContentTitle("Player Music")
                .setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startForeground(NOTIFICATION_ID, mNotification.build());
            mNotificationManager.notify(NOTIFICATION_ID, mNotification.build());
        }
    }

    private PendingIntent setActionForPendingIntent(String action) {
        Intent intent = new Intent(this, MusicServices.class);
        intent.setAction(action);
        return PendingIntent.getService(this, 0, intent, 0);
    }

    private void changeImgBtnPauseNoti(boolean isPlaying) {
        if (isPlaying) {
            mRemoteViews.setImageViewResource(R.id.imgBtnPlayNotification, R.drawable.ic_pause_black);
            mRemoteViews.setOnClickPendingIntent(R.id.imgBtnPlayNotification, mIntentPause);
        } else {
            mRemoteViews.setImageViewResource(R.id.imgBtnPlayNotification, R.drawable.ic_play_arrow_black);
            mRemoteViews.setOnClickPendingIntent(R.id.imgBtnPlayNotification, mIntentPlay);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotificationManager.notify(NOTIFICATION_ID, mNotification.build());
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mSeekbar.get().setProgress(0);
        mHandler.removeCallbacks(mUpdateTimeTask);
        mBtnPlay.get().setText(R.string.play);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask);
        int totalTime = mMediaPlayer.getDuration();
        int currentTime = Utility.progressToTimer(seekBar.getProgress(), totalTime);
        mMediaPlayer.seekTo(currentTime);
        updateProgressBar();
    }
}
