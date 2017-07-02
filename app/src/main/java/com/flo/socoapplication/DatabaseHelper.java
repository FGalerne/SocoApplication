package com.flo.socoapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by florian on 02/07/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database
    public static final String DATABASE_NAME = "SocotecDB";
    public static final int DATABASE_VERSION = 1;

    // Tables name
    public static final String TABLE_USER = "User";

    // Fields of user table
    public static final String KEY_USER_ID ="Id";
    public static final String KEY_USER_LASTNAME = "Lastname";
    public static final String KEY_USER_FIRSTNAME ="Firstname";
    public static final String KEY_USER_EMPLOYEE_NUMBER = "Employee Number";
    public static final String KEY_USER_EMAIL = "Email";
    public static final String KEY_USER_PASSWORD = "Password";
    public static final String KEY_USER_CONFIMATION_PASSWORD = "Confirmation";

    //Create tables
    private static final String CREATE_USER_ENTRIES = "CREATE TABLE " + TABLE_USER + " (" + KEY_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_USER_LASTNAME + " TEXT, " + KEY_USER_FIRSTNAME + " TEXT, " + KEY_USER_EMPLOYEE_NUMBER + " TEXT, " + KEY_USER_EMAIL + " TEXT, " + KEY_USER_PASSWORD + " TEXT," + KEY_USER_CONFIMATION_PASSWORD + " TEXT";

    //Drop tables
    private static final String USER_DELETE_ENTRIES = "DROP TABLE IF EXITS " + TABLE_USER;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL(USER_DELETE_ENTRIES);
            onCreate(db);
        }


    }
}
