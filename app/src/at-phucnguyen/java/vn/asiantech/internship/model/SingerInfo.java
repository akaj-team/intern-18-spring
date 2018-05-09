package vn.asiantech.internship.model;

public class SingerInfo {

    /**
     * id : 1309258
     * name : JustinBieber
     * url : https://www.bandsintown.com/a/1309258?came_from=267&app_id=12
     * image_url : https://s3.amazonaws.com/bit-photos/large/189101.jpeg
     * thumb_url : https://s3.amazonaws.com/bit-photos/thumb/189101.jpeg
     * facebook_page_url : http://www.facebook.com/pages/JustinBieber/347868178556844
     * mbid :
     * tracker_count : 2960
     * upcoming_event_count : 0
     */

    private String id;
    private String name;
    private String url;
    private String image_url;
    private String thumb_url;
    private String facebook_page_url;
    private String mbid;
    private int tracker_count;
    private int upcoming_event_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return image_url;
    }

    public int getTrackerCount() {
        return tracker_count;
    }
}
