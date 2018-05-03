package vn.asiantech.internship.model;

public class ItemDatabase {
    private int mId;
    private String mNameDatabase;
    private int mAgeDatabase;

    public ItemDatabase() {
    }

    public ItemDatabase(String nameDatabase, int ageDatabase) {
        this.mNameDatabase = nameDatabase;
        this.mAgeDatabase = ageDatabase;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getNameDatabase() {
        return mNameDatabase;
    }

    public void setNameDatabase(String nameDatabase) {
        this.mNameDatabase = nameDatabase;
    }

    public int getAgeDatabase() {
        return mAgeDatabase;
    }

    public void setAgeDatabase(int AgeDatabase) {
        this.mAgeDatabase = AgeDatabase;
    }
}
