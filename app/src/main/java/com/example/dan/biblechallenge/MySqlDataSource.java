package com.example.dan.biblechallenge;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dan on 4/11/2017.
 */

public class MySqlDataSource {
    private SQLiteDatabase mDatabase;
    private MySQLiteHelper mySQLiteHelper;
    private Context mContext;

    public MySqlDataSource (Context context) {
        mContext = context;
        mySQLiteHelper = new MySQLiteHelper(mContext);
    }

    //open
    public void open() throws SQLException {
        mDatabase= mySQLiteHelper.getWritableDatabase();
    }

    //close
    public void close() {
        mDatabase.close();
    }
    //insert


}
