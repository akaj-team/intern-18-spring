package vn.asiantech.drawerlayout;

import android.net.Uri;

class ItemMail {
    private final int mIcon;
    private String mName;
    private Uri mUri;
    private static final String ITEM_INBOX = "Inbox";
    private static final String ITEM_TRASH = "Trash";
    private static final String ITEM_OUTBOX = "Outbox";
    private static final String ITEM_SPAM = "Spam";
    private boolean mIsSelected = false;

    ItemMail(int icon, Uri uri) {
        mIcon = icon;
        initItem();
        mUri = uri;
    }

    public int getIcon() {
        return mIcon;
    }

    public String getName() {
        return mName;
    }

    private void initItem() {
        switch (mIcon) {
            case 1:
                mName = ITEM_INBOX;
                break;

            case 2:
                mName = ITEM_OUTBOX;
                break;

            case 3:
                mName = ITEM_TRASH;
                break;

            case 4:
                mName = ITEM_SPAM;
                break;

            default:
                mName = ITEM_TRASH;
                break;
        }
    }

    public void setIsSelected(boolean isSelected) {
        mIsSelected = isSelected;
    }

    public boolean isSelected()
    {
        return mIsSelected;
    }

    public Uri getUri()
    {
        return  mUri;
    }

    public void setUri(Uri uri)
    {
        mUri = uri;
    }

}
