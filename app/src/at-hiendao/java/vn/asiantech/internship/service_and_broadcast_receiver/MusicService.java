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
    public static String TAG = "123";
    private Handler mHandler = new Handler();
    private static final int mNotifyId = 3;
    public static final String ACTION = "notification";
    public static final String CURRENT_TIME = "current_time";
    public static final String TOTAL_TIME = "total_time";
    public static final String PAUSE = "Pause";
    public static final String PLAY = "play";
    public static final String ACTION_PAUSE = "android.hdx.action.PauseMusic";
    public static final String ACTION_CLOSE = "android.hdx.action.Close_Notification";
    private MyBroadCastReceiver mBroadCastReceiver = new MyBroadCastReceiver();
    private NotificationManager mManager;

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            try {

                float currentTime = mMediaPlayer.getCurrentPosition();
                float totalTime = mMediaPlayer.getDuration();
                int percent = (int) (currentTime / totalTime * 100);
                loadMusic(currentTime, totalTime);
                initNotification(percent);
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
            if (intent.getExtras().getBoolean(PLAY) && !mMediaPlayer.isPlaying()) {
                mMediaPlayer.start();
                play();
            } else if (intent.getExtras().getBoolean(PAUSE)) {
                mMediaPlayer.pause();
                mHandler.removeCallbacks(mRunnable);
            }
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initService();
        mMediaPlayer = MediaPlayer.create(this, R.raw.music);
        loadMusic(0, mMediaPlayer.getDuration());
    }

    void play() {
        mRunnable.run();
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
    }

    void initNotification(int progress) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notification);
        remoteViews.setImageViewResource(R.id.imgIconNotify, R.drawable.custom_circle);
        remoteViews.setProgressBar(R.id.progressBar, 100, progress, false);
        float currentTime = mMediaPlayer.getCurrentPosition();
        remoteViews.setTextViewText(R.id.tvCurrentTimeNotify, String.format(Locale.ENGLISH,
                "%02d:%02d", (int) (currentTime / 1000) / 60, (int) (currentTime / 1000) % 60));
        remoteViews.setTextColor(R.id.tvCurrentTimeNotify, Color.BLACK);
        float totalTime = mMediaPlayer.getDuration();
        remoteViews.setTextViewText(R.id.tvTotalTimeNotify, String.format(Locale.ENGLISH,
                "%02d:%02d", (int) (totalTime / 1000) / 60, (int) (totalTime / 1000) % 60));
        remoteViews.setTextColor(R.id.tvCurrentTimeNotify, Color.BLACK);
        remoteViews.setTextColor(R.id.tvTotalTimeNotify, Color.BLACK);

        Intent intent = new Intent(ACTION_CLOSE);
        PendingIntent pending = PendingIntent.getBroadcast(this, mNotifyId, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.btnPlay, pending);

        Intent notificationIntent = new Intent(this, ServiceActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, mNotifyId, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.custom_icon_person)
                .setContentTitle(getString(R.string.app_name))
                .setContent(remoteViews)
                .setContentText(getString(R.string.notification_text));
        builder.setContentIntent(pendingIntent);

        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (mManager != null) {
                startForeground(mNotifyId, builder.build());
                mManager.notify(mNotifyId, builder.build());
            }
        }
    }

    void closeNotification() {
        mManager.cancel(mNotifyId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.stop();
        mHandler.removeCallbacks(mRunnable);
        Log.e(TAG, "onDestroy: ");
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
        IntentFilter test = IntentFilter.
        Log.e(TAG, "onReceive: " + intent.getAction());
    }


}
