package vn.asiantech.internship.service_and_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static vn.asiantech.internship.service_and_broadcast_receiver.MusicService.TAG;

public class MyBroadCastReceiver extends BroadcastReceiver {
    private IEventReceiverData mEventReceiverData;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
//            float progress = intent.getExtras().getInt(CURRENT_TIME);
//            int currentTime = (int) ((progress / 100) * mMediaPlayer.getDuration());
//            mMediaPlayer.seekTo(currentTime);
//            if (!mMediaPlayer.isPlaying()) {
//                mMediaPlayer.start();
//                play();
//            }
//            Log.e(TAG, "onReceive: " + currentTime);
            mEventReceiverData.onReceiverData(intent);
        }
        Log.e(TAG, "onReceive: " + intent.getAction());

    }

    public void setListennerReceiverData(IEventReceiverData receiverData) {
        mEventReceiverData = receiverData;
    }

}