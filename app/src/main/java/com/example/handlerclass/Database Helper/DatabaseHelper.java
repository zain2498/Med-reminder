
package com.example.handlerclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Static variable
    //database name
    public static final String DATABASE_NAME = "Login.db";
    public static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        //changes made
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating TABLE
        //change email to phone number
        db.execSQL("Create table user(firstName String,lastName String,emailAddress String,phoneNumber int primary key, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }


    //inserting in database
    public boolean insert(String firstName , String lastName , String emailAddress , String phoneNumber , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //change email to phoneNumber
        contentValues.put("firstName", firstName);
        contentValues.put("lastName", lastName);
        contentValues.put("emailAddress", emailAddress);
        contentValues.put("phoneNumber", phoneNumber);
        contentValues.put("password", password);
        long ins = db.insert("user", null,contentValues);
        if (ins==-1) return false;
        else return true;
    }
    //checking change  (email to Number) if exists
    public Boolean chkNumber(String Number){
        SQLiteDatabase db = this.getReadableDatabase();                                 //CHANGE TO iNT THROUGH STRING.VALUEOF()
        Cursor cursor = db.rawQuery("Select * from user where Number=?", new String[]{String.valueOf(Number)});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    //checking the (email to Number) and password
    public Boolean Numberpassword(String Number, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and password=?", new String[]{String.valueOf(Number),password});
        if (cursor.getCount()>0) return true;
        else return false;
    }
}
		 