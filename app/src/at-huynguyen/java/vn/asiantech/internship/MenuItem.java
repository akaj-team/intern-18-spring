package vn.asiantech.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MenuItem {

    private int mAvatar;
    private String mName;
    private String mEmail;
    private int mItem;
    private String mNameItem;

    public int getAvatar() {
        return mAvatar;
    }

    public void setAvatar(int mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getItem() {
        return mItem;
    }

    public void setItem(int mItem) {
        this.mItem = mItem;
    }

    public String getNameItem() {
        return mNameItem;
    }

    private void setNameItem(String mNameItem) {
        this.mNameItem = mNameItem;
    }

    public static List<MenuItem> createListMenuItem() {
        List<MenuItem> list = new ArrayList<>();
        MenuItem menu = new MenuItem();
        Random random = new Random();
        int position = random.nextInt(4);
        List<Integer> listItem = new ArrayList<>();
        listItem.add(R.drawable.ic_email);
        listItem.add(R.drawable.ic_gallery);
        listItem.add(R.drawable.ic_slideshow);
        listItem.add(R.drawable.ic_tool);
        List<String> listNameItem = new ArrayList<>();
        listNameItem.add("Email");
        listNameItem.add("Gallery");
        listNameItem.add("Slide show");
        listNameItem.add("Tools");
        menu.setAvatar(R.drawable.custom_circle);
        menu.setName("Huy Nguyen Q.");
        menu.setEmail("quanghuy19496@gmail.com");
        menu.setItem(listItem.get(position));
        menu.setNameItem(listNameItem.get(position));
        list.add(menu);
        return list;
    }
}
