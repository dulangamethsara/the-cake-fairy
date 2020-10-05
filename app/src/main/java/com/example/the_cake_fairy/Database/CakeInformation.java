package com.example.the_cake_fairy.Database;

import android.provider.BaseColumns;

public  final class CakeInformation {
        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private CakeInformation() {}

        /* Inner class that defines the table contents */
        public static class Cakes implements BaseColumns {
            public static final String TABLE_NAME = "CakeInfo";
            public static final String COLUMN_1 = "cakeName";
            public static final String COLUMN_2 = "weight";
            public static final String COLUMN_3 = "category";
            public static final String COLUMN_4 = "price";
        }
}
