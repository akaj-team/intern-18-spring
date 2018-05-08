package vn.asiantech.internship.service_and_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import java.util.Objects;

public class MyBroadCastReceiver extends BroadcastReceiver {
    private static final String TAG = "123";
    private IEventReceiverData mEventReceiverData;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " + intent.getAction());
        if (intent.getExtras() != null) {
            mEventReceiverData.onReceiverData(intent);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if (Objects.requireNonNull(intent.getAction()).compareTo(MusicService.ACTION_PAUSE) == 0) {
                    Intent serviceIntent = new Intent(context, MusicService.class);
                    serviceIntent.putExtra(MusicService.FILTER_PAUSE, true);
                    context.startService(serviceIntent);
                } else if (intent.getAction().compareTo(MusicService.ACTION_CLOSE) == 0) {
                    Intent serviceIntent = new Intent(context, MusicService.class);
                    serviceIntent.putExtra(MusicService.FILTER_CLOSE, true);
                    context.startService(serviceIntent);
                }
            }

        }
    }

    public void setListennerReceiverData(IEventReceiverData receiverData) {
        mEventReceiverData = receiverData;
    }

}
