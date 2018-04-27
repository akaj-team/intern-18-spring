package vn.asiantech.internship.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.List;

public class ReaderDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private IEventChangeData mEventChangeData;

    private SQLiteDatabase mWriteableDb;


    public static class FeedEntry implements BaseColumns {
        static final String TABLE_NAME = "Person";
        static final String COLLUM_NAME = "Name";
        static final String COLLUM_AGE = "Age";
    }

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry.COLLUM_NAME + " TEXT," +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLLUM_AGE + " INTERGER)";

    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    ReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mWriteableDb = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addPerson(Person person) {
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLLUM_NAME, person.getName());
        values.put(FeedEntry.COLLUM_AGE, person.getAge());
        mWriteableDb.insert(FeedEntry.TABLE_NAME, null, values);
        mEventChangeData.onChangeData();
    }

    public void deletePerson(Person person) {
        String selection = FeedEntry.COLLUM_NAME + "= '" + person.getName() + "'";
        mWriteableDb.delete(FeedEntry.TABLE_NAME, selection, null);
        mEventChangeData.onChangeData();
    }

    public void updateListPerson(List<Person> listPerson) {
        listPerson.clear();
        Cursor allRows = mWriteableDb.rawQuery("SELECT * FROM " + FeedEntry.TABLE_NAME, null);
        while (allRows.moveToNext()) {
            String name = allRows.getString(allRows.getColumnIndex(FeedEntry.COLLUM_NAME));
            int age = allRows.getInt(allRows.getColumnIndex(FeedEntry.COLLUM_AGE));
            listPerson.add(new Person(name, age));
        }
        allRows.close();
    }

    public void setListenerChangeData(IEventChangeData listenerChangeData) {
        mEventChangeData = listenerChangeData;
    }

}
