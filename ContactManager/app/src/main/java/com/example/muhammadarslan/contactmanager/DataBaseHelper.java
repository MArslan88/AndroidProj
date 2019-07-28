package com.example.muhammadarslan.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Muhammad Arslan on 9/3/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts_table";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, int mobile_number, String email){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("MOBILE_NUMBER",mobile_number);
        contentValues.put("EMAIL",email);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getData(String mobile_number){
        SQLiteDatabase db= this.getWritableDatabase();

        // SQLite Query should be like
        // SELECT * FROM TABLE WHERE MOBILE_NUMBER = '123'
        String query= "SELECT * FROM " + TABLE_NAME + " WHERE MOBILE_NUMBER = '" +mobile_number+"'";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
}
