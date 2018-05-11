package vn.asiantech.internship.api;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("thumb_url")
    private String mThumbUrl;
    @SerializedName("facebook_page_url")
    private String mFacebookPageUrl;
    @SerializedName("mbid")
    private String mBid;
    @SerializedName("tracker_count")
    private int mTrackerCount;
    @SerializedName("upcoming_event_count")
    private int mUpcomingEventCount;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String image_url) {
        this.mImageUrl = image_url;
    }

    public String getThumbUrl() {
        return mThumbUrl;
    }

    public void setThumbUrl(String thumb_url) {
        this.mThumbUrl = thumb_url;
    }

    public String getFacebookPageUrl() {
        return mFacebookPageUrl;
    }

    public void setFacebookPageUrl(String facebook_page_url) {
        this.mFacebookPageUrl = facebook_page_url;
    }

    public String getMbid() {
        return mBid;
    }

    public void setMbid(String mbid) {
        this.mBid = mbid;
    }

    public int getTrackerCount() {
        return mTrackerCount;
    }

    public void setTrackerCount(int tracker_count) {
        this.mTrackerCount = tracker_count;
    }

    public int getUpComingEventCount() {
        return mUpcomingEventCount;
    }

    public void setUpComingEventCount(int upcoming_event_count) {
        this.mUpcomingEventCount = upcoming_event_count;
    }
}
