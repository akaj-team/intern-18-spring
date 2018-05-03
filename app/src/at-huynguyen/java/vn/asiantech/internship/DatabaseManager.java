package vn.asiantech.internship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.List;

import vn.asiantech.internship.model.ItemDatabase;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Manager_Information.db";
    private static final int VERSION = 1;
    private IEventChangeData mEventChangeData;

    public static class UserInformation implements BaseColumns {

        static final String TABLE_NAME = "User";
        static final String ID = "_ID";
        static final String NAME = "Name";
        static final String AGE = "Age";
    }

    private static final String SQLCreate = "CREATE TABLE " + UserInformation.TABLE_NAME + " (" +
            UserInformation.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            UserInformation.NAME + " TEXT, " +
            UserInformation.AGE + " INTEGER)";

    private final static String SQLDrop = "DROP TABLE IF EXISTS " + UserInformation.TABLE_NAME;

    DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQLDrop);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        super.onDowngrade(sqLiteDatabase, oldVersion, newVersion);
    }

    public void addItemDatabase(ItemDatabase itemDatabase) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserInformation.NAME, itemDatabase.getNameDatabase());
        values.put(UserInformation.AGE, itemDatabase.getAgeDatabase());
        sqLiteDatabase.insert(UserInformation.TABLE_NAME, null, values);
        mEventChangeData.onChangeData();
        sqLiteDatabase.close();
    }

    public void deleteItemDatabase(ItemDatabase itemDatabase) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String selection = UserInformation.NAME + "= '" + itemDatabase.getNameDatabase() + "'";
        sqLiteDatabase.delete(UserInformation.TABLE_NAME, selection, null);
        mEventChangeData.onChangeData();
    }

    public void updateItemDatabase(List<ItemDatabase> listItemDatabase) {
        listItemDatabase.clear();
        String selectQuery = "SELECT * FROM " + UserInformation.TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ItemDatabase itemDatabase = new ItemDatabase();
                itemDatabase.setId(cursor.getInt(0));
                itemDatabase.setNameDatabase(cursor.getString(1));
                itemDatabase.setAgeDatabase(cursor.getInt(2));
                listItemDatabase.add(itemDatabase);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
    }

    public void setListenerChangeItem(IEventChangeData listenerChangeData) {
        mEventChangeData = listenerChangeData;
    }

}
