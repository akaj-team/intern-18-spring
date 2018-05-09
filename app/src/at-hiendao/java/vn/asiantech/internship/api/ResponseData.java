package vn.asiantech.internship.api;

public class ResponseData {

    /**
     * id : 307871
     * name : Justin Bieber
     * url : https://www.bandsintown.com/a/307871?came_from=267&app_id=1235
     * image_url : https://s3.amazonaws.com/bit-photos/large/8070867.jpeg
     * thumb_url : https://s3.amazonaws.com/bit-photos/thumb/8070867.jpeg
     * facebook_page_url : https://www.facebook.com/JustinBieber
     * mbid : e0140a67-e4d1-4f13-8a01-364355bee46e
     * tracker_count : 3581671
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getFacebook_page_url() {
        return facebook_page_url;
    }

    public void setFacebook_page_url(String facebook_page_url) {
        this.facebook_page_url = facebook_page_url;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public int getTracker_count() {
        return tracker_count;
    }

    public void setTracker_count(int tracker_count) {
        this.tracker_count = tracker_count;
    }

    public int getUpcoming_event_count() {
        return upcoming_event_count;
    }

    public void setUpcoming_event_count(int upcoming_event_count) {
        this.upcoming_event_count = upcoming_event_count;
    }
}