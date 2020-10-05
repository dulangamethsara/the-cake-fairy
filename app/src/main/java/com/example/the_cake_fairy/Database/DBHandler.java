package com.example.the_cake_fairy.Database;

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
    public static final String DATABASE_NAME = "Database.db";

    public  DBHandler (Context context) {
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
            "CREATE TABLE " + CakeInformation.Cakes.TABLE_NAME + " (" +
                    CakeInformation.Cakes._ID + " INTEGER PRIMARY KEY," +
                    CakeInformation.Cakes.COLUMN_1 + " TEXT," +
                    CakeInformation.Cakes.COLUMN_2 + " TEXT,"+
                    CakeInformation.Cakes.COLUMN_3 + " TEXT,"+
                    CakeInformation.Cakes.COLUMN_4 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CakeInformation.Cakes.TABLE_NAME;

    public long addInfo(String cakename, String weight, String category,String price){
        // Gets the data repository in write mode
        SQLiteDatabase db =getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(CakeInformation.Cakes.COLUMN_1, cakename);
        values.put(CakeInformation.Cakes.COLUMN_2, weight);
        values.put(CakeInformation.Cakes.COLUMN_3, category);
        values.put(CakeInformation.Cakes.COLUMN_4, price);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(CakeInformation.Cakes.TABLE_NAME, null, values);
        return newRowId;
    }

    //**********************************************UPDATE INFORMATION *********************************************

    public Boolean updateInfo(String cakename, String weight, String category,String price){
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(CakeInformation.Cakes.COLUMN_2, weight);
        values.put(CakeInformation.Cakes.COLUMN_3, category);
        values.put(CakeInformation.Cakes.COLUMN_4, price);

        // Which row to update, based on the title
        String selection = CakeInformation.Cakes.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { cakename };

        int count = db.update(
                CakeInformation.Cakes.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >=1 ) {
            return true;
        }
        else {
            return false;
        }
    }

    //**********************************************DELETE INFORMATION *********************************************

    public boolean deleteInfo(String cakename){
        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = CakeInformation.Cakes.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { cakename };
        // Issue SQL statement.
        int deletedRows = db.delete(CakeInformation.Cakes.TABLE_NAME, selection, selectionArgs);
        return false;
    }

    //**********************************************READ INFORMATION *********************************************

    public ArrayList readAllInfo() {
        String cakename = "Chocolate";
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                CakeInformation.Cakes.COLUMN_1,
                CakeInformation.Cakes.COLUMN_2,
                CakeInformation.Cakes.COLUMN_3,
                CakeInformation.Cakes.COLUMN_4,
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = CakeInformation.Cakes.COLUMN_1 + " = ?";
        String[] selectionArgs = {cakename};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                CakeInformation.Cakes.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                CakeInformation.Cakes.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );


        ArrayList cakenames = new ArrayList<>();
        while (cursor.moveToNext()) {
            String cake = cursor.getString(cursor.getColumnIndexOrThrow(CakeInformation.Cakes.COLUMN_1));
            cakenames.add(cake);
        }
        cursor.close();
        return cakenames;
    }

    //**********************************************READ ALL INFORMATION *********************************************

    public List readAllInfo(String cakename) {
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                CakeInformation.Cakes.COLUMN_1,
                CakeInformation.Cakes.COLUMN_2,
                CakeInformation.Cakes.COLUMN_3,
                CakeInformation.Cakes.COLUMN_4,
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = CakeInformation.Cakes.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = {cakename};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                CakeInformation.Cakes.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                CakeInformation.Cakes.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );


        List cakeInfo = new ArrayList<>();
        while (cursor.moveToNext()) {
            String cake = cursor.getString(cursor.getColumnIndexOrThrow(CakeInformation.Cakes.COLUMN_1));
            String weight = cursor.getString(cursor.getColumnIndexOrThrow(CakeInformation.Cakes.COLUMN_2));
            String catego = cursor.getString(cursor.getColumnIndexOrThrow(CakeInformation.Cakes.COLUMN_3));
            String price = cursor.getString(cursor.getColumnIndexOrThrow(CakeInformation.Cakes.COLUMN_4));

            cakeInfo.add(cake);     //0
            cakeInfo.add(weight);   //1
            cakeInfo.add(catego);   //2
            cakeInfo.add(price);    //3
        }
        cursor.close();
        return cakeInfo;
    }

}





















