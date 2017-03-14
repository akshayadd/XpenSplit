package com.akshay.finalyear;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Akshay on 2/25/2017.
 */
public class DBAdapater {
    static final String DATABASE_NAME = "xpensplit.db";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_TABLE1 = "Registration";
    static final String DATABASE_TABLE2 = "Groups";
    static final String DATABASE_TABLE3 = "Transaction";
    static final String DATABASE_TABLE4 = "Category";

    public static final int NAME_COLUMN = 1;

    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table " + DATABASE_TABLE1 +
            "( " + "ID" + " integer autoincrement," + "FIRSTNAME  text,LASTNAME text,Email_ID text primary key Not NULL,"
            + "PASSWORD text,Mobile_No number,BUDGET decimal,CREATED datetime,UPDATED datetime); ";

    // Variable to hold the database instance
    public SQLiteDatabase db;

    // Context of the application using the database.
    private final Context context;

    // Database open/upgrade helper
    private DataBaseHelper dbHelper;

    public DBAdapater(Context _context) {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBAdapater open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String Email_id, String Password) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("Email_ID", Email_id);
        newValues.put("PASSWORD", Password);

        // Insert the row into your table
        db.insert("Registration", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public int deleteEntry(String Email_id) {
        //String id=String.valueOf(ID);
        String where = "Email_ID=?";
        int numberOFEntriesDeleted = db.delete("Registration", where, new String[]{Email_id});
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String Email_id) {
        Cursor cursor = db.query("Registration", null, "Email_ID=?", new String[]{Email_id}, null, null, null);
        if (cursor.getCount() > 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public void updateEntry(String Email_id, String Password) {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("Email_ID", Email_id);
        updatedValues.put("PASSWORD", Password);

        String where = "Email_ID = ?";
        db.update("Registration", updatedValues, where, new String[]{Email_id});
    }
}
