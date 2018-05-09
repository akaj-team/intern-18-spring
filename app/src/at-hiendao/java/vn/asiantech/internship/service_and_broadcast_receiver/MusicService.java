package vn.asiantech.internship.service_and_broadcast_receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Locale;

import vn.asiantech.internship.R;


public class MusicService extends Service implements IEventReceiverData {
    private MediaPlayer mMediaPlayer;
    public static final String TAG = "123";
    private Handler mHandler = new Handler();
    private static final int mNotifyId = 3;
    public static final String ACTION = "notification";
    public static final String CURRENT_TIME = "currenttime";
    public static final String TOTAL_TIME = "totaltime";
    public static final String FILTER_PAUSE = "Filterpause";
    public static final String FILTER_CLOSE = "Filterclose";
    public static final String FILTER_PLAY = "Filterplay";
    public static final String ACTION_PAUSE = "android.hdx.action.PauseMusic";
    public static final String ACTION_CLOSE = "android.hdx.action.Close_Notification";
    private MyBroadCastReceiver mBroadCastReceiver = new MyBroadCastReceiver();
    private NotificationManager mManager;
    private Notification.Builder mNotificationBuilder;
    private RemoteViews mRemoteViews;
    private final String FORMAT = "%02d:%02d";

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            try {

                float currentTime = mMediaPlayer.getCurrentPosition();
                float totalTime = mMediaPlayer.getDuration();
                int percent = (int) (currentTime / totalTime * 100);
                loadMusic(currentTime, totalTime);
                updateNotification(percent);
            } finally {
                if (mMediaPlayer.getCurrentPosition() == mMediaPlayer.getDuration()) {
                    stopMusic();
                } else {
                    int mTimeDelay = 1000;
                    mHandler.postDelayed(mRunnable, mTimeDelay);
                }
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getExtras() != null) {
            if (intent.getExtras().getBoolean(FILTER_PLAY) && !mMediaPlayer.isPlaying()) {
                mMediaPlayer.start();
                play();
            } else if (intent.getExtras().getBoolean(FILTER_PAUSE)) {
                pause();
            } else if (intent.getExtras().getBoolean(FILTER_CLOSE)) {
                closeNotification();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initService();
        loadMusic(0, mMediaPlayer.getDuration());
    }

    void play() {
        mRemoteViews.setImageViewResource(R.id.imgBtnPlay, R.drawable.custom_icon_pause);
        mRunnable.run();
    }

    int getProgressMusic() {
        float currentTime = mMediaPlayer.getCurrentPosition();
        float totalTime = mMediaPlayer.getDuration();
        return (int) (currentTime / totalTime * 100);
    }

    void pause() {
        Log.e(TAG, "pause: " );
        if(mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mHandler.removeCallbacks(mRunnable);
            mRemoteViews.setImageViewResource(R.id.imgBtnPlay, R.drawable.custom_icon_play);
        }
        else
        {
            mMediaPlayer.start();
            play();
        }
        updateNotification(getProgressMusic());
    }

    void loadMusic(float currentTime, float totalTime) {
        Intent intent = new Intent();
        intent.setAction(ACTION);
        intent.putExtra(CURRENT_TIME, currentTime);
        intent.putExtra(TOTAL_TIME, totalTime);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    void stopMusic() {
        mMediaPlayer.stop();
        mHandler.removeCallbacks(mRunnable);
    }

    void initService() {
        mBroadCastReceiver.setListennerReceiverData(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CURRENT_TIME);
        registerReceiver(mBroadCastReceiver, intentFilter);
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
        initNotification();
    }

    void initNotification() {
        Log.e(TAG, "initNotification: ");
        mRemoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        mRemoteViews.setProgressBar(R.id.progressBar, 100, 0, false);
        mRemoteViews.setTextViewText(R.id.tvCurrentTimeNotify, String.format(Locale.ENGLISH,
                FORMAT, 0, 0));
        mRemoteViews.setTextColor(R.id.tvCurrentTimeNotify, Color.BLACK);
        float totalTime = mMediaPlayer.getDuration();
        mRemoteViews.setTextViewText(R.id.tvTotalTimeNotify, String.format(Locale.ENGLISH,
                FORMAT, (int) (totalTime / 1000) / 60, (int) (totalTime / 1000) % 60));
        mRemoteViews.setTextColor(R.id.tvCurrentTimeNotify, Color.BLACK);
        mRemoteViews.setTextColor(R.id.tvTotalTimeNotify, Color.BLACK);

        Intent intentPause = new Intent(ACTION_PAUSE);
        PendingIntent pendingIntentPause = PendingIntent.getBroadcast(this, mNotifyId, intentPause, 0);
        mRemoteViews.setOnClickPendingIntent(R.id.btnPlay, pendingIntentPause);

        Intent intentClose = new Intent(ACTION_CLOSE);
        PendingIntent pendingIntentClose = PendingIntent.getBroadcast(this, mNotifyId, intentClose, 0);
        mRemoteViews.setOnClickPendingIntent(R.id.btnClose, pendingIntentClose);

        Intent notificationIntent = new Intent(this, ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, mNotifyId,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mNotificationBuilder = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.custom_icon_person)
                    .setContentTitle(getString(R.string.app_name))
                    .setContent(mRemoteViews)
                    .setContentText(getString(R.string.notification_text))
                    .setContentIntent(pendingIntent);
        }
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (mManager != null) {
                startForeground(mNotifyId, mNotificationBuilder.build());
            }
        }
    }

    void updateNotification(int progress) {
        mRemoteViews.setProgressBar(R.id.progressBar, 100, progress, false);
        float currentTime = mMediaPlayer.getCurrentPosition();
        mRemoteViews.setTextViewText(R.id.tvCurrentTimeNotify, String.format(Locale.ENGLISH,
                FORMAT, (int) (currentTime / 1000) / 60, (int) (currentTime / 1000) % 60));
        mRemoteViews.setTextColor(R.id.tvCurrentTimeNotify, Color.BLACK);
        float totalTime = mMediaPlayer.getDuration();
        mRemoteViews.setTextViewText(R.id.tvTotalTimeNotify, String.format(Locale.ENGLISH,
                FORMAT, (int) (totalTime / 1000) / 60, (int) (totalTime / 1000) % 60));
        mRemoteViews.setTextColor(R.id.tvCurrentTimeNotify, Color.BLACK);
        mRemoteViews.setTextColor(R.id.tvTotalTimeNotify, Color.BLACK);
        mNotificationBuilder.setContent(mRemoteViews);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (mManager != null) {
                mManager.notify(mNotifyId, mNotificationBuilder.build());
            }
        }
    }

    void closeNotification() {

        if (!mMediaPlayer.isPlaying()) {
            Log.e(TAG, "closeNotification: " );
            stopForeground(true);
            mManager.cancel(mNotifyId);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e(TAG, "onLowMemory: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");
        return super.onUnbind(intent);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        return null;
    }

    @Override
    public void onReceiverData(Intent intent) {
        if (intent.getExtras() != null) {
            float progress = intent.getExtras().getInt(CURRENT_TIME);
            int currentTime = (int) ((progress / 100) * mMediaPlayer.getDuration());
            mMediaPlayer.seekTo(currentTime);
            if (!mMediaPlayer.isPlaying()) {
                mMediaPlayer.start();
                play();
            }
        }

    }


}
