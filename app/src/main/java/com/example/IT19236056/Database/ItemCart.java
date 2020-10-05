package com.example.IT19236056.Database;

import android.provider.BaseColumns;

public final class ItemCart {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ItemCart() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "ItemDetails";
        public static final String COLUMN_1 = "ItemName";
        public static final String COLUMN_2 = "Weight";
        public static final String COLUMN_3 = "Price";
        public static final String COLUMN_4 = "Description";
    }
}