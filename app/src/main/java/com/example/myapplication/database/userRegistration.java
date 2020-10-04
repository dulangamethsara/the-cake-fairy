package com.example.myapplication.database;

import android.provider.BaseColumns;

public final class userRegistration {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private userRegistration() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "userRegistration";
        public static final String COLUMN_1 = "uName";
        public static final String COLUMN_2 = "phone";
        public static final String COLUMN_3 = "email";
        public static final String COLUMN_4 = "password";
        public static final String COLUMN_5 = "Cpassword";
    }
}