package com.example.myapplication.database;

import android.provider.BaseColumns;
public final class adminRegistration {



    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private adminRegistration() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "adminRegistration";
        public static final String COLUMN_1 = "uName";
        public static final String COLUMN_2 = "password";


    }




}
