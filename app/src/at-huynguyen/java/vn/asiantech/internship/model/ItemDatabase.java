package vn.asiantech.internship.model;

public class ItemDatabase {
    private long mIdDatabase;
    private String mNameDatabase;
    private int mAgeDatabase;

    public long getIdDatabase() {
        return mIdDatabase;
    }

    public void setIdDatabase(long idDatabase) {
        this.mIdDatabase = idDatabase;
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

    public void setAgeDatabase(int ageDatabase) {
        this.mAgeDatabase = ageDatabase;
    }
}
