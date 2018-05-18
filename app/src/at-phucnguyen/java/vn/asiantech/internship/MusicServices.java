package vn.asiantech.internship;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RemoteViews;

import java.util.concurrent.TimeUnit;

public class MusicServices extends Service {
    private static final String SEEBARPROGRESS = "seeBarProgress";
    private static final String ACTIONSEEKBARCHANGE = "seekBarListenes";
    private static final String STATUSMEDIA = "mediaIsPlaying";
    private static final String NAMESONG = "NameSong";
    private static final String DURATIONSONG = "DurationSong";
    private static final String CURRENTPOSITION = "currentPosition";
    private static final String SONGISPLAY = "SONGISPLAY";
    private static final int SONG = R.raw.co_gai_m52;
    private static final String TAG = "MusicServices";
    private static final int IDNOTIMUSIC = 1111;
    private static final String ACTIONPLAYMUSIC = "actionPlayMusic";
    private static final String ACTIONPAUSEMUSIC = "actionPauseMusic";
    private static final String ACTIONCLOSESERVICE = "actionCLoseService";
    private static final int IMGPLAY = R.drawable.ic_play_arrow_black_24dp;
    private static final int IMGPAUSE = R.drawable.ic_pause_black_24dp;

    private MediaPlayer mMedia;
    private NotificationManager mNotificationManager;
    private RemoteViews mRemoteViewsNoti;
    private Notification mNotification;
    private Handler mHandler = new Handler();
    private UpdateTimeCurrentSong updateTimeCurrentSong;
    private PendingIntent mIntentStartMusic;
    private PendingIntent mIntentPauseMusic;
    private PendingIntent mIntentCloseService;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate ");

        init();
        showNotification();
    }

    public void init() {
        mMedia = MediaPlayer.create(this, SONG);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mRemoteViewsNoti = new RemoteViews(getPackageName(), R.layout.notification_music);

        mIntentPauseMusic = setActionForPendingIntetForServices(ACTIONPAUSEMUSIC);
        mIntentStartMusic = setActionForPendingIntetForServices(ACTIONPLAYMUSIC);
        mIntentCloseService = setActionForPendingIntetForServices(ACTIONCLOSESERVICE);
    }

    private void showNotification() {
        Log.e(TAG, "showNotification: ");

        Intent intent = new Intent(this, PlayMusicActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{intent}, 0);

        mRemoteViewsNoti.setOnClickPendingIntent(R.id.imgBtnNotiPause
                , mIntentPauseMusic);
        mRemoteViewsNoti.setOnClickPendingIntent(R.id.imgBtnNotiClose
                , mIntentCloseService);
        mRemoteViewsNoti.setTextViewText(R.id.tvNameSongNoti, getNameMusic(SONG));

        mNotification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_music_note_black_24dp)
                .setContent(mRemoteViewsNoti)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(IDNOTIMUSIC, mNotification);
        mNotificationManager.notify(IDNOTIMUSIC, mNotification);
    }

    private PendingIntent setActionForPendingIntetForServices(String action) {
        Intent intent = new Intent(this, MusicServices.class);
        intent.setAction(action);
        return PendingIntent.getService(this, 0, intent, 0);
    }

    @NonNull
    private String getNameMusic(int idMusic) {
        TypedValue value = new TypedValue();
        this.getResources().getValue(idMusic, value, true);

        return value.string.toString();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        if (action != null) {
            switch (intent.getAction()) {
                case ACTIONPLAYMUSIC: {
                    Log.e(TAG, "ACTIONPLAYMUSIC:");
                    startMusicByNoti();
                    break;
                }
                case ACTIONPAUSEMUSIC: {
                    Log.e(TAG, "ACTIONPAUSEMUSIC: ");
                    pauseMusicByNoti();
                    break;
                }
                case ACTIONCLOSESERVICE: {
                    Log.e(TAG, "ACTIONCLOSESERVICE: ");
                    closeServiceByNoti();
                    break;
                }
                case ACTIONSEEKBARCHANGE: {
                    int progress = intent.getIntExtra(SEEBARPROGRESS, -1);
                    Log.e(TAG, "ACTIONSEEKBARCHANGE: " + progress);
                    if (progress != -1) {
                        mMedia.seekTo(progress);
                    }
                    break;
                }
            }
        }
        return START_STICKY;
    }

    private void closeServiceByNoti() {
        if (!mMedia.isPlaying()) {
            this.stopSelf();
        }
    }

    private void pauseMusicByNoti() {
        mMedia.pause();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        //Service khong rang buoc thi ham nay se khong bao gio dc goi
        return null;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy: ");
        mMedia.pause();
        mNotificationManager.cancel(IDNOTIMUSIC);
        removeUpdateTimeSong();
        super.onDestroy();
    }

    private void removeUpdateTimeSong() {
        mHandler.removeCallbacks(updateTimeCurrentSong);
    }

    private void startMusicByNoti() {
        mMedia.start();
        updateTimeCurrentSong = new UpdateTimeCurrentSong();
        mHandler.post(updateTimeCurrentSong);
    }

    private String miliSecondsToString(int miliseconds) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) miliseconds);
        long seconds = (TimeUnit.MILLISECONDS.toSeconds((long) miliseconds)) % 60;
        return minutes + ":" + seconds;
    }

    /**
     * Class is used to update process Seekbar and Notification
     */
    class UpdateTimeCurrentSong implements Runnable {
        Intent mIntent = new Intent().setAction(SONGISPLAY);

        @Override
        public void run() {
            sendCurrentTimeMedia();
            mRemoteViewsNoti.setTextViewText(R.id.tvTimeCountNoti, miliSecondsToString(mMedia.getCurrentPosition()));
            mNotificationManager.notify(IDNOTIMUSIC, mNotification);
            changeImgBtnPauseNoti(mMedia.isPlaying());
            sendStatusMedia(mMedia.isPlaying());
            mHandler.postDelayed(this, 1000);
            if (!mMedia.isPlaying()) {
                Log.e(TAG, "run: false");
                mHandler.removeCallbacks(this);
            }
        }

        private void changeImgBtnPauseNoti(boolean isPlaying) {
            if (isPlaying) {
                mRemoteViewsNoti.setImageViewResource(R.id.imgBtnNotiPause, IMGPAUSE);
                mRemoteViewsNoti.setOnClickPendingIntent(R.id.imgBtnNotiPause, mIntentPauseMusic);
            } else {
                mRemoteViewsNoti.setImageViewResource(R.id.imgBtnNotiPause, IMGPLAY);
                mRemoteViewsNoti.setOnClickPendingIntent(R.id.imgBtnNotiPause, mIntentStartMusic);
            }
            mNotificationManager.notify(IDNOTIMUSIC, mNotification);
        }

        private void sendStatusMedia(boolean isPlaying) {
            mIntent.putExtra(STATUSMEDIA, isPlaying);
            getBaseContext().sendBroadcast(mIntent);
        }

        private void sendCurrentTimeMedia() {
            mIntent.putExtra(NAMESONG, getNameMusic(SONG));
            mIntent.putExtra(DURATIONSONG, mMedia.getDuration());
            mIntent.putExtra(CURRENTPOSITION, mMedia.getCurrentPosition());
            getBaseContext().sendBroadcast(mIntent);
            Log.e(TAG, "run: ");
        }
    }
}
