package com.dev.moneykeeper.db.entry;

import android.provider.BaseColumns;

/**
 * Created by light on 10/13/13.
 */
public class CategoryEntry implements BaseColumns {

    public static final String TABLE_NAME = "category";
    public static final String COLUMN_NAME_ID_CATEGORY = "idcategory";
    public static final String COLUMN_NAME_CATEGORY = "name";
    public static final String COLUMN_NAME_SUBTITLE = "description";

}
