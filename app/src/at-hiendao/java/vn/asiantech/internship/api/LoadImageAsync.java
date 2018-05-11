package vn.asiantech.internship.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadImageAsync extends AsyncTask<String, Integer, Bitmap> {
    private static final String TAG = LoadImageAsync.class.getSimpleName();
    private Bitmap mBitmapImage = null;

    @Override
    protected Bitmap doInBackground(String... strings) {
        String path = strings[0];
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            mBitmapImage = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            Log.e(TAG, "doInBackground - IOException" + e.toString());
        }
        return mBitmapImage;
    }
}
