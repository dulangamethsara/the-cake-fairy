package com.example.myapplication.database;

import android.provider.BaseColumns;

public final class userProfile {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private userProfile() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "userProfile";
        public static final String COLUMN_1 = "fName";
        public static final String COLUMN_2 = "lName";
        public static final String COLUMN_3 = "phone";
        public static final String COLUMN_4 = "email";
        public static final String COLUMN_5 = "password";
    }
}