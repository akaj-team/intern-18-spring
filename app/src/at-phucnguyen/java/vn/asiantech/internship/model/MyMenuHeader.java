package vn.asiantech.internship.model;

import android.graphics.Bitmap;
import android.net.Uri;

public class MyMenuHeader {
    private String emailHeader;
    private Uri uri;
    private int urlImgResource;
    private Bitmap bitmapHeader;

    public Bitmap getBitmapHeader() {
        return bitmapHeader;
    }

    public void setBitmapHeader(Bitmap bitmapHeader) {
        this.bitmapHeader = bitmapHeader;
    }

    public int getUrlImgResource() {
        return urlImgResource;
    }

    public MyMenuHeader(String emailHeader, int urlImage) {
        this.emailHeader = emailHeader;
        this.urlImgResource = urlImage;
    }

    public String getEmailHeader() {
        return emailHeader;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
