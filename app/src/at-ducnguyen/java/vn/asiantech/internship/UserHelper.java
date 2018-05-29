package vn.asiantech.internship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vn.asiantech.internship.model.Person;

public class UserHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USERDATA";
    private static final String TABLE_NAME = "USER";
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String AGE = "AGE";

    UserHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void insertUser(Person user) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, user.getName());
        contentValues.put(AGE, user.getAge());
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void deleteUser(Person user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ?", new String[]{String.valueOf(user.getId())});
        sqLiteDatabase.close();
    }

    public Person getNewUser() {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToLast();
        Person user = new Person();
        user.setId(cursor.getInt(0));
        user.setName(cursor.getString(1));
        user.setAge(cursor.getInt(2));
        cursor.close();
        return user;
    }

    public List<Person> getAllUser() {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        List<Person> listUser = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Person user = new Person();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setAge(cursor.getInt(2));
                listUser.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listUser;
    }

    public void resetDatabase() {
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                NAME + " text, " +
                AGE + " integer)";
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
