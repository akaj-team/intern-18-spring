package vn.asiantech.internship.model;

import com.google.gson.annotations.SerializedName;

public class Artist {
    private String name;
    @SerializedName("thumb_url")
    private String thumbUrl;
    @SerializedName("tracker_count")
    private long trackerCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getTrackerCount() {
        return trackerCount + " trackers";
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public void setTrackerCount(long trackerCount) {
        this.trackerCount = trackerCount;
    }
}
