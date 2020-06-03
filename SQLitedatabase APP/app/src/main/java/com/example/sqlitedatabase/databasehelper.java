package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import androidx.cursoradapter.widget.CursorAdapter;

//import androidx.annotation.Nullable;

// SQLiteOpenHelper creates a helper object to create, open or manage a database. It doesn't create the database unless getWritableDatabase() is called.
public class databasehelper extends SQLiteOpenHelper {

    // Creating variables for database name, table name and its columns
    public static final String DATABASE_NAME = "USER.db";
    public static final String TABLE_NAME = "USERS";
    public static final String COL_1 = "_id";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "AGE";

    // Creates the database.
    public databasehelper(Context context) {

        super(context , DATABASE_NAME , null , 1);
    }

    // Method for creating the table with name "TABLE_NAME" and specifying the columns
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( " + COL_1 +" INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 +" TEXT," + COL_3 + " INTEGER)");
    }

    // Drops the existing table and calls the method onCreate to create a new table of the name TABLE_NAME
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method for inserting data into the table. It returns a boolean value to Main2Activity.java to show whether insertion has been successful
    public boolean InsertData(String name , String age){

        // This line of code helps to create/open a database for reading and writing. The FIRST TIME this is called, the database will be opened and
        // onCreate(SQLiteDatabase) and onUpgrade(SQLiteDatabase, int, int) will be called.
        SQLiteDatabase db = getWritableDatabase();

        // An object of class ContentValues is created and the data to be added is stored in it.
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2 ,name);
        contentValues.put(COL_3 ,age);

        // in-built function which inserts the data in contentValues into the table. It returns -1 if insertion is unsuccessful.
        // If successful, it returns the row ID.
        long result = db.insert(TABLE_NAME , null ,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }


    public Cursor getData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        c.moveToFirst();
        return c;
    }

//    public SimpleCursorAdapter list_Adapter(Cursor res , databasehelper db) {
//        String[] from = {res.getColumnName(0), res.getColumnName(1), res.getColumnName(2)};
//        int[] to = new int[] {R.id.id_textview , R.id.name_textView , R.id.age_textView};
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(, android.R.layout.simple_list_item_1, res, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//        return adapter;
//    }
}
