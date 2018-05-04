package vn.asiantech.internship.model;

public class Song {
    private String title;
    private String artist;
    private String path;
    private Long duration;

    public String getDuration() {
        int hours = (int) (duration / 3600);
        int temp = (int) (duration - hours * 3600);
        int mins = temp / 60;
        int secs = temp - mins * 60;
        if (hours == 0){
            return mins + ": " + secs;
        } else {
            return hours + ": " + mins + ": " + secs;
        }
    }

    public void setDuration(Long duration) {
        this.duration = duration / 1000;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
