package com.example.IT19236056.Database;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import static com.example.IT19236056.Database.ItemCart.*;


public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";

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
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    ItemCart.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemCart.FeedEntry.COLUMN_1 + " TEXT," +
                    ItemCart.FeedEntry.COLUMN_2 + " TEXT," +
                    ItemCart.FeedEntry.COLUMN_3 + " TEXT," +
                    ItemCart.FeedEntry.COLUMN_4 + " TEXT)";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ItemCart.FeedEntry.TABLE_NAME;

    public void addinfo(String ItemName,String Weight,String Price,String Description) {
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ItemCart.FeedEntry.COLUMN_1, ItemName);
        values.put(ItemCart.FeedEntry.COLUMN_2, Weight);
        values.put(ItemCart.FeedEntry.COLUMN_3, Price);
        values.put(ItemCart.FeedEntry.COLUMN_4, Description);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ItemCart.FeedEntry.TABLE_NAME, null, values);

    }

    public void deleteinfo(String ItemName){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = ItemCart.FeedEntry.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "ItemName" };
        // Issue SQL statement.
        int deletedRows = db.delete(ItemCart.FeedEntry.TABLE_NAME, selection, selectionArgs);

    }

    public List readAllInfo (){

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                ItemCart.FeedEntry.COLUMN_1,
                ItemCart.FeedEntry.COLUMN_2,
                ItemCart.FeedEntry.COLUMN_3,
                ItemCart.FeedEntry.COLUMN_4,

        };

        // Filter results WHERE "title" = 'My Title'
        String selection = ItemCart.FeedEntry.COLUMN_1 + " = ?";
        String[] selectionArgs = { "ItemName" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                ItemCart.FeedEntry.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                ItemCart.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List ItemNames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String ItemName = cursor.getString(cursor.getColumnIndexOrThrow(ItemCart.FeedEntry.COLUMN_1));
            ItemNames.add(ItemName);
        }
        cursor.close();
        return ItemNames;

    }

    public List readAllInfo (String ItemName) {

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                ItemCart.FeedEntry.COLUMN_1,
                ItemCart.FeedEntry.COLUMN_2,
                ItemCart.FeedEntry.COLUMN_3,
                ItemCart.FeedEntry.COLUMN_4,

        };

        // Filter results WHERE "title" = 'My Title'
        String selection = ItemCart.FeedEntry.COLUMN_1 + " = LIKE?";
        String[] selectionArgs = {"ItemName"};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                ItemCart.FeedEntry.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                ItemCart.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List ItemInfo = new ArrayList<>();
        while (cursor.moveToNext()) {
            String Weight = cursor.getString(cursor.getColumnIndexOrThrow(ItemCart.FeedEntry.COLUMN_2));
            String Price = cursor.getString(cursor.getColumnIndexOrThrow(ItemCart.FeedEntry.COLUMN_3));
            String Description = cursor.getString(cursor.getColumnIndexOrThrow(ItemCart.FeedEntry.COLUMN_4));
            ItemInfo.add(Weight);
            ItemInfo.add(Price);
            ItemInfo.add(Description);
        }
        cursor.close();
        return ItemInfo;
    }

}
