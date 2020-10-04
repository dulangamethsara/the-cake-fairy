package com.example.myapplication.database;

import android.provider.BaseColumns;

public final class userLogin {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private userLogin() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "userLogin";
        public static final String COLUMN_1 = "uName";
        public static final String COLUMN_2 = "password";
    }
}
