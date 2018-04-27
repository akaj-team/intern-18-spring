package vn.asiantech.internship.service_and_broadcast_receiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;

public class MusicService extends Service {
    private Looper mServiceLooper;

    private final class ServiceHandler extends
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
