package com.example.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + userRegistration.Users.TABLE_NAME + " (" +
                    userRegistration.Users._ID + " INTEGER PRIMARY KEY," +
                    userRegistration.Users._ID + " INTEGER PRIMARY KEY," +
                    userRegistration.Users.COLUMN_1 + " TEXT," +
                    userRegistration.Users.COLUMN_2 + " TEXT," +
                    userRegistration.Users.COLUMN_3 + " TEXT," +
                    userRegistration.Users.COLUMN_4 + " TEXT," +
                    userRegistration.Users.COLUMN_5  + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + userRegistration.Users.TABLE_NAME;




    public long addInfo (String uName,String phone,String email,String password){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(userRegistration.Users.COLUMN_1, uName);
        values.put(userRegistration.Users.COLUMN_2, phone);
        values.put(userRegistration.Users.COLUMN_3, email);
        values.put(userRegistration.Users.COLUMN_4, password);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(userRegistration.Users.TABLE_NAME, null, values);

        return newRowId;
    }




    public Boolean updateInfo (String uName, String phone, String email , String password){
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(userProfile.Users.COLUMN_1, uName);
        values.put(userProfile.Users.COLUMN_2, uName);
        values.put(userProfile.Users.COLUMN_3, uName);
        values.put(userProfile.Users.COLUMN_4, uName);

        // Which row to update, based on the title
        String selection = userProfile.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { "MyOldTitle" };

        int count = db.update(
                userProfile.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if(count >= 1 ){
            return true;
        }
        else{
            return false;
        }
    }




    public void deleteInfo(String email){
        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = userProfile.Users.COLUMN_4 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "email" };
        // Issue SQL statement.
        int deletedRows = db.delete(userProfile.Users.TABLE_NAME, selection, selectionArgs);
    }



    public List ReadAllInfo (){

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                userRegistration.Users.COLUMN_1,
                userRegistration.Users.COLUMN_2,
                userRegistration.Users.COLUMN_3,
                userRegistration.Users.COLUMN_4,
                userRegistration.Users.COLUMN_5
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = userRegistration.Users.COLUMN_4 + " LIKE ?";
        String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                userRegistration.Users.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                userRegistration.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String uName = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_1));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_2));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_3));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_4));
            String Cpassword = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_5));
            userInfo.add(uName);
            userInfo.add(phone);
            userInfo.add(email);
            userInfo.add(password);
            userInfo.add(Cpassword);
        }
        cursor.close();
        return userInfo;
    }

    public List ReadAllInfo (String uName){

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                userLogin.Users.COLUMN_1,
                userLogin.Users.COLUMN_2

        };

        // Filter results WHERE "title" = 'My Title'
        String selection = userRegistration.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                userLogin.Users.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                userRegistration.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String password = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_2));
            userInfo.add(uName);
            userInfo.add(password);

        }
        cursor.close();
        return userInfo;
    }

    public List readAllInfo (String uName){

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                adminRegistration.Users.COLUMN_1,
                adminRegistration.Users.COLUMN_2

        };

        // Filter results WHERE "title" = 'My Title'
        String selection = userRegistration.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { "My Title" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                adminRegistration.Users.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                userRegistration.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String password = cursor.getString(cursor.getColumnIndexOrThrow(userRegistration.Users.COLUMN_2));
            userInfo.add(uName);
            userInfo.add(password);

        }
        cursor.close();
        return userInfo;
    }


}
