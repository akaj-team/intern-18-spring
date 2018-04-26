package vn.asiantech.internship.model;

import android.net.Uri;

public class HeaderMenu {
    private Uri mAvatar;
    private String mNameHeader;
    private String mEmailHeader;
    private int mImageResource;
    private Uri mUri;

    public HeaderMenu(int imageResource, String NameHeader, String EmailHeader) {
        this.mImageResource = imageResource;
        this.mNameHeader = NameHeader;
        this.mEmailHeader = EmailHeader;
    }

    public Uri getAvatar() {
        return mAvatar;
    }

    public String getNameHeader() {
        return mNameHeader;
    }

    public String getEmailHeader() {
        return mEmailHeader;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public Uri getUri() {
        return mUri;
    }

    public void setUri(Uri Uri) {
        this.mUri = Uri;
    }
}
