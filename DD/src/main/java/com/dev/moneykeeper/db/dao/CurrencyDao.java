package com.dev.moneykeeper.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dev.moneykeeper.db.DataBase;
import com.dev.moneykeeper.db.beans.Currency;
import com.dev.moneykeeper.db.entry.MoneyKeeperContract;

import java.util.ArrayList;
import java.util.List;

/**
 * DD
 * Created by light on 11/16/13.
 */
public class CurrencyDao extends DataBase implements BaseDao<Currency> {

    //Context mContext;

    public CurrencyDao(Context context) {
        super(context);
        //mContext = context;
    }

    @Override
    public long add(Currency currency) {

        final SQLiteDatabase database = mOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MoneyKeeperContract.Currency.COLUMN_MAME, currency.getName());
        values.put(MoneyKeeperContract.Currency.COLUMN_DESCRIPTION, currency.getDescription());

        long id = database.insert(MoneyKeeperContract.Currency.TABLE_NAME, null, values);
        database.close();

        Log.i("CurrencyDao", "add, id = " + id);
        return id;
    }

    @Override
    public Currency get(long id) {
        final SQLiteDatabase database = mOpenHelper.getWritableDatabase();

        Cursor cursor = database.query(MoneyKeeperContract.Currency.TABLE_NAME,
                new String[]{MoneyKeeperContract.Currency.COLUMN_MAME, MoneyKeeperContract.Currency.COLUMN_DESCRIPTION},
                MoneyKeeperContract.Currency._ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Currency currency = convert(cursor);

        return currency;
    }

    @Override
    public List<Currency> getAll() {
        List<Currency> currencyList = new ArrayList<Currency>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + MoneyKeeperContract.Currency.TABLE_NAME;

        final SQLiteDatabase database = mOpenHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Currency currency = convert(cursor);

                // Adding contact to list
                currencyList.add(currency);
            } while (cursor.moveToNext());
        }

        return currencyList;
    }

    @Override
    public long update(Currency currency) {
        final SQLiteDatabase database = mOpenHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(MoneyKeeperContract.Currency.COLUMN_MAME, currency.getName());
        values.put(MoneyKeeperContract.Currency.COLUMN_DESCRIPTION, currency.getDescription());

        // updating row
        return database.update(MoneyKeeperContract.Currency.TABLE_NAME, values, MoneyKeeperContract.Currency._ID + " = ?",
                new String[]{String.valueOf(currency.getId())});


    }

    @Override
    public boolean remove(long id) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int rows = db.delete(MoneyKeeperContract.Currency.TABLE_NAME, MoneyKeeperContract.Currency._ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();

        return rows > 0;
    }

    @Override
    public long count() {

        String countQuery = "SELECT  * FROM " + MoneyKeeperContract.Currency.TABLE_NAME;
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    private Currency convert(Cursor cursor) {

        int indexId = cursor.getColumnIndex(MoneyKeeperContract.Currency._ID);
        int indexName = cursor.getColumnIndex(MoneyKeeperContract.Currency.COLUMN_MAME);
        int indexDescription = cursor.getColumnIndex(MoneyKeeperContract.Currency.COLUMN_DESCRIPTION);

        Currency currency = new Currency();

        Log.i("id = ", cursor.getString(indexId));

        currency.setId(Integer.parseInt(cursor.getString(indexId)));
        currency.setName(cursor.getString(indexName));
        currency.setDescription(cursor.getString(indexDescription));
        return currency;
    }
}
