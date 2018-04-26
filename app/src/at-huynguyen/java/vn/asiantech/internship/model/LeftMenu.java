package vn.asiantech.internship.model;

public class LeftMenu {
    private int mItem;
    private String mNameItem;

    public LeftMenu(int item, String nameItem) {
        this.mItem = item;
        this.mNameItem = nameItem;
    }

    public int getItem() {
        return mItem;
    }

    public void setItem(int item) {
        this.mItem = item;
    }

    public String getNameItem() {
        return mNameItem;
    }

    public void setNameItem(String nameItem) {
        this.mNameItem = nameItem;
    }
}
