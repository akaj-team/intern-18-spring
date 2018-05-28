package vn.asiantech.internship;

import java.util.List;

import vn.asiantech.internship.model.Song;

public interface OnLoadPlayListListener {
    void onGetPlayList(List<Song> listSong);
}
