package vn.asiantech.internship.model;

public class Song {
    private String title;
    private String artist;
    private String path;
    private Long duration;

    public String getDurationMS() {
        int hours = (int) (duration / 3600000);
        int temp = (int) (duration - hours * 3600000);
        int mins = temp / 60000;
        int secs = (temp - mins * 60000)/1000;
        if (hours == 0){
            return mins + ":" + secs;
        } else {
            return hours + ":" + mins + ":" + secs;
        }
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration.intValue();
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
