package vn.asiantech.internship;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.Song;

public class LoadPlayListTask extends AsyncTask<Void, Integer, Void> {
    @SuppressLint("StaticFieldLeak")
    private Context mContext;
    private Dialog mDialog;
    @SuppressLint("StaticFieldLeak")
    private ProgressBar mProgressBar;
    @SuppressLint("StaticFieldLeak")
    private TextView mTvPercent;
    private OnLoadPlayListListener mListener;
    private List<Song> mListSong;

    LoadPlayListTask(Context context) {
        mContext = context;
    }

    public void setOnLoadPlayListListener(OnLoadPlayListListener listener) {
        mListener = listener;
    }

    @Override
    protected void onPreExecute() {
        mDialog = new Dialog(mContext);

        mDialog.setContentView(R.layout.dialog_with_progress_bar);
        TextView tvTitle = mDialog.findViewById(R.id.tvTitle);
        mProgressBar = mDialog.findViewById(R.id.progressBar);
        mTvPercent = mDialog.findViewById(R.id.tvPercent);
        tvTitle.setText(R.string.loading_playlist);
        mDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        getPlayList();
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressBar.setProgress(values[0]);
        String percent = values[0] + " %";
        mTvPercent.setText(percent);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        mListener.onGetPlayList(mListSong);
        mDialog.dismiss();
    }

    private void getPlayList() {
        mListSong = new ArrayList<>();
        Uri allSongsUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
                + " AND " + MediaStore.Audio.Media.MIME_TYPE + "= 'audio/mpeg'";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC ";
        String[] projection = new String[]{
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DURATION
        };
        Cursor cursor = mContext.getContentResolver().query(allSongsUri, projection, selection, null, sortOrder);
        if (cursor != null) {
            int total = cursor.getCount();
            int i = 1;
            int percent;
            if (cursor.moveToFirst()) {
                do {
                    Song song = new Song();
                    song.setTitle(cursor.getString(0));
                    song.setArtist(cursor.getString(1));
                    song.setPath(cursor.getString(2));
                    song.setDuration(cursor.getLong(3));
                    mListSong.add(song);
                    percent = i * 100 / total;
                    i++;
                    publishProgress(percent);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
    }
}
