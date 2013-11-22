package com.dev.moneykeeper.db.entry;

import android.provider.BaseColumns;

/**
 * Created by light on 10/13/13.
 */
public final class MoneyKeeperContract {

    private MoneyKeeperContract() {
    }

    public static final class Currency implements BaseColumns {

        public static final String TABLE_NAME = "currency";
        public static final String COLUMN_MAME = "currency_name";
        public static final String COLUMN_DESCRIPTION = "currency_description";
        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MAME + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT"
                + ")";
        public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME + " IF EXIST";

    }

    public static final class Wallet implements BaseColumns {

        public static final String TABLE_NAME = "wallet";
        public static final String COLUMN_MAME = "wallet_name";
        public static final String COLUMN_DESCRIPTION = "wallet_description";
        public static final String COLUMN_AMOUNT = "wallet_amount";
        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MAME + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT"
                + COLUMN_AMOUNT + " TEXT"
                + ")";
        public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME + " IF EXIST";

    }


}
