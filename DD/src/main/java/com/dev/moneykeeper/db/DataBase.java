package com.dev.moneykeeper.db;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DD
 * Created by light on 11/9/13.
 */
public abstract class DataBase {

    protected static final String DATABASE_NAME = "MoneyKeeper.db";
    protected static final int DATABASE_VERSION = 1;
    //private static DataBase mDataBase;
    protected SQLiteOpenHelper mOpenHelper;

    public DataBase(Context context) {
        mOpenHelper = new DbHelper(context, DATABASE_NAME, DATABASE_VERSION);
    }

//    public static DataBase getInstance(Context context) {
//        if (mDataBase == null)
//            mDataBase = new DataBase(context);
//        return mDataBase;
//    }

//    protected SQLiteOpenHelper getOpenHelper(){
//       return mOpenHelper;
//    }

}
