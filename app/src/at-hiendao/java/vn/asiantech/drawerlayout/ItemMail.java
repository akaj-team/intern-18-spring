package vn.asiantech.drawerlayout;

import android.net.Uri;
import android.util.Log;

class ItemMail {
    private final ItemMailType mType;
    private String mName;
    private Uri mUri;

    public enum ItemMailType {
        UserInfo,
        Inbox,
        Outbox,
        Trash,
        Spam
    }

    private boolean mIsSelected = false;

    ItemMail(ItemMailType type, Uri uri) {
        mType = type;
        mName = mType.toString();
        mUri = uri;
    }

    public ItemMailType getType() {
        return mType;
    }

    public String getName() {
        return mName;
    }

    public void setIsSelected(boolean isSelected) {
        mIsSelected = isSelected;
    }

    public boolean isSelected() {
        return mIsSelected;
    }

    public Uri getUri() {
        return mUri;
    }

    public void setUri(Uri uri) {
        mUri = uri;
    }

}
