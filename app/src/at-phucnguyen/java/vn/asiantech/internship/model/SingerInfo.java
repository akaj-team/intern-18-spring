package vn.asiantech.internship.model;

import com.google.gson.annotations.SerializedName;

public class SingerInfo {

    /**
     * id : 1309258
     * name : JustinBieber
     * url : https://www.bandsintown.com/a/1309258?came_from=267&app_id=12
     * imageUrl : https://s3.amazonaws.com/bit-photos/large/189101.jpeg
     * thumbUrl : https://s3.amazonaws.com/bit-photos/thumb/189101.jpeg
     * facebookPageUrl : http://www.facebook.com/pages/JustinBieber/347868178556844
     * mbid :
     * trackerCount : 2960
     * upcomingEventCount : 0
     */

    private String id;
    private String name;
    private String url;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("thumb_url")
    private String thumbUrl;
    @SerializedName("facebook_page_url")
    private String facebookPageUrl;
    private String mbid;
    @SerializedName("tracker_count")
    private int trackerCount;
    @SerializedName("upcoming_event_count")
    private int upcomingEventCount;

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
        return imageUrl;
    }

    public int getTrackerCount() {
        return trackerCount;
    }
}
