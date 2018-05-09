package vn.asiantech.internship.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = "MySQLiteHelper";

    /**
     * Class is Database Table Info
     */
    private final class PersonTable implements BaseColumns {
        private final static String TABLE_NAME = "MyPerson";
        private final static String ID = "_id";
        private final static String NAME = "Name";
        private final static String AGE = "Age";
    }

    //Database Info
    private final static String DATABASE_NAME = "myDataBase.db";
    private final static int DATABASE_VERSION = 1;
    private final static String CREATE_DB = "CREATE TABLE " + PersonTable.TABLE_NAME + " ("
            + PersonTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PersonTable.NAME + " TEXT NOT NULL,"
            + PersonTable.AGE + " INTEGER)";
    private final static String DROP_DB = "DROP TABLE IF EXISTS " + PersonTable.TABLE_NAME;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_DB);
        onCreate(db);
    }

    public void addNewPerson(Person person) {
        try {
            //Khởi tạo provide để inset record DB
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            //ContentValues sử dụng để insert và cập nhật dữ liệu trong record
            //ContentValus được ví như một record
            ContentValues values = new ContentValues();
            values.put(PersonTable.NAME, person.getName());
            values.put(PersonTable.AGE, person.getAge());

            //Insert bản ghi ở trên vào DB
            sqLiteDatabase.insert(PersonTable.TABLE_NAME, null, values);
        } catch (SQLiteException sQLE) {
            Log.e(TAG, "addNewPerson: " + sQLE.toString());
        }
    }

    public void deletePersonById(Integer id) {
        //Khởi tạo provide để delete record DB
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            sqLiteDatabase.delete(PersonTable.TABLE_NAME, PersonTable.ID + " = ?"
                    , new String[]{Integer.toString(id)});
        } catch (SQLiteException sQLE) {
            Log.e(TAG, "addNewPerson: " + sQLE.toString());
        }
    }

    public void updateChangedList(List<Person> personList) {
        personList.clear();
        String query = "SELECT * FROM " + PersonTable.TABLE_NAME;
        //Khoi tao bien de doc du lieu
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //Khoi tao con tro de tro toi dong du lieu
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        //Dua con tro toi dong dau tien cua du lieu
        cursor.moveToFirst();

        //Doc con tro lan luot cho den khi con tro toi dong cuoi cung
        while (!cursor.isAfterLast()) {
            Person person = new Person(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            personList.add(person);
            //Di chuyen con tro toi dong tiep theo
            cursor.moveToNext();
        }
    }
}
