package vn.asiantech.internship.service_and_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyBroadCastReceiver extends BroadcastReceiver {
    private static final String TAG = "123";
    private IEventReceiverData mEventReceiverData;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " + intent.getAction());
        if (intent.getExtras() != null) {
            mEventReceiverData.onReceiverData(intent);
        } else {
            Log.e(TAG, "onReceive: " + intent.getAction().compareTo(MusicService.ACTION_CLOSE));
            if (intent.getAction().compareTo(MusicService.ACTION_PAUSE) == 0) {
                Intent serviceIntent = new Intent(context, MusicService.class);
                serviceIntent.putExtra(MusicService.PAUSE, true);
                context.startService(serviceIntent);
            } else if(intent.getAction().compareTo(MusicService.ACTION_CLOSE) == 0)
            {
                Intent serviceIntent = new Intent(context, MusicService.class);
                serviceIntent.putExtra(MusicService.CLOSE, true);
                context.startService(serviceIntent);
            }

        }
    }

    public void setListennerReceiverData(IEventReceiverData receiverData) {
        mEventReceiverData = receiverData;
    }

}
