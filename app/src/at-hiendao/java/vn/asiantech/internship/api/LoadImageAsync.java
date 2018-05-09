package vn.asiantech.internship.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static vn.asiantech.internship.api.ArtistInfoFragment.TAG;

public class LoadImageAsync extends AsyncTask<String, Integer, Bitmap> {

    private Bitmap mBitmapImage = null;

    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.e(TAG, "doInBackground: " + strings[0] + " ");
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
            Log.e(TAG, "doInBackground: " + e.toString());
        }
        return mBitmapImage;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG, "onPreExecute: ");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }


}
