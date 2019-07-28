package com.example.muhammadarslan.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 9/24/2017.
 */

public class MySqliteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="MySQLDB.db";
    private static final int DB_VER=1;
    private final String TABLE_NAME = "Contacts";
    private final String COLUMN_ID = "id";
    private final String COLUMN_NAME = "name";

    public MySqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Contacts(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(50))");
    }

    public long addName(Name name){
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name.getName());
        return getWritableDatabase().insert("Contacts",null,contentValues);
    }

    public ArrayList<Name> getContacts(){
        ArrayList<Name> contacts = new ArrayList<>();
        String[] cols = new String[]{
                "id","name"
        };
        Cursor cursor = getReadableDatabase().query("Contacts",cols,null,null,null,null,null);
        while (cursor.moveToNext()){
            int nameColumnIndex = cursor.getColumnIndex("name");
            String name = cursor.getString(nameColumnIndex);

            int idColumnIndex = cursor.getColumnIndex("id");
            int id = cursor.getInt(idColumnIndex);
            contacts.add(new Name(id,name));
        }
        return contacts;
    }

    public void delContact(int id){
        String [] arg=new String[] {
                String.valueOf(id)
        };
        getWritableDatabase().delete("Contacts","id=?",arg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
