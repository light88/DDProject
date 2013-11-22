package com.dev.moneykeeper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dev.moneykeeper.db.entry.MoneyKeeperContract;

/**
 * Created by light on 10/13/13.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = "DbHelper";

    public DbHelper(Context context, String name, int version) {
        super(context, name, null, version);
        Log.e(TAG, "constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "onCreate");

        db.execSQL(MoneyKeeperContract.Currency.SQL_CREATE_TABLE);
        db.execSQL(MoneyKeeperContract.Wallet.SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade");

        db.execSQL(MoneyKeeperContract.Currency.SQL_DROP_TABLE);
        db.execSQL(MoneyKeeperContract.Wallet.SQL_DROP_TABLE);

        onCreate(db);
    }

}
