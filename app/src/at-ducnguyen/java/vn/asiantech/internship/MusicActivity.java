package vn.asiantech.internship;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import vn.asiantech.internship.model.Song;

public class MusicActivity extends AppCompatActivity implements OnLoadPlayListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        LoadPlayListTask loadPlayListTask = new LoadPlayListTask(this);
        loadPlayListTask.setOnLoadPlayListListener(this);
        loadPlayListTask.execute();
    }

    @Override
    public void onGetPlayList(List<Song> listSong) {
        ListMusicAdapter listMusicAdapter = new ListMusicAdapter(listSong);
        RecyclerView recyclerViewListMusic = findViewById(R.id.recyclerViewListMusic);
        recyclerViewListMusic.setAdapter(listMusicAdapter);
        recyclerViewListMusic.setLayoutManager(new LinearLayoutManager(this));
    }
}
