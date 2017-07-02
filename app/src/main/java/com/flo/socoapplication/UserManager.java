package com.flo.socoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by florian on 02/07/17.
 */

public class UserManager {

    private DatabaseHelper data;
    private SQLiteDatabase db;
    private User u;

    public UserManager(Context ctx) {
        data = new DatabaseHelper(ctx, DatabaseHelper.DATABASE_NAME, null, DatabaseHelper.DATABASE_VERSION);
    }

    public void open(){
        db = data.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long addUser (User u){

        ContentValues vals = new ContentValues();

        vals.put(DatabaseHelper.KEY_USER_LASTNAME, u.getUser_lastname());
        vals.put(DatabaseHelper.KEY_USER_FIRSTNAME, u.getUser_firstname());
        vals.put(DatabaseHelper.KEY_USER_EMPLOYEE_NUMBER, u.getEmployee_number());
        vals.put(DatabaseHelper.KEY_USER_EMAIL, u.getEmail());
        vals.put(DatabaseHelper.KEY_USER_PASSWORD, u.getPassword());
        vals.put(DatabaseHelper.KEY_USER_CONFIMATION_PASSWORD, u.getConfirmation_password());

        return db.insert(DatabaseHelper.TABLE_USER, null, vals);


    }

   /* public User getUser (int id){

        return User;
    }*/
}
