package com.example.gemox94.diabapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by gemox94 on 26/04/17.
 */

public class DiabappDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Diabapp.db";


    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP DEFAULT CURRENT_TIMESTAMP";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ROLS =
            "CREATE TABLE " + DiabappContract.Rol.TABLE_NAME + " (" +
                    DiabappContract.Rol._ID + " INTEGER PRIMARY KEY," +
                    DiabappContract.Rol.COLUMN_NAME_NAME + TEXT_TYPE + " )";

    private static final String SQL_CREATE_USERS =
            "CREATE TABLE " + DiabappContract.User.TABLE_NAME + " (" +
                    DiabappContract.User._ID + " INTEGER PRIMARY KEY," +
                    DiabappContract.User.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.User.COLUMN_NAME_LASTNAME + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.User.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.User.COLUMN_NAME_ADDRESS + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.User.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.User.COLUMN_NAME_ROL_ID + INTEGER_TYPE + COMMA_SEP +
                    DiabappContract.User.COLUMN_NAME_DOCTOR_ID + INTEGER_TYPE + " )";


    private static final String SQL_CREATE_MEASUREMENTS =
            "CREATE TABLE " + DiabappContract.Measurement.TABLE_NAME + " (" +
                    DiabappContract.Measurement._ID + " INTEGER PRIMARY KEY," +
                    DiabappContract.Measurement.COLUMN_NAME_B_MEAL + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.Measurement.COLUMN_NAME_A_MEAL + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.Measurement.COLUMN_NAME_GlUCOSE + TEXT_TYPE + COMMA_SEP +
                    DiabappContract.Measurement.COLUMN_NAME_PATIENT_ID + INTEGER_TYPE + COMMA_SEP +
                    DiabappContract.Measurement.COLUMN_NAME_DOCTOR_ID + INTEGER_TYPE + COMMA_SEP +
                    DiabappContract.Measurement.COLUMN_NAME_CREATED+ TIMESTAMP_TYPE + " )";

    private static final String SQL_DELETE_ROLS = "DROP TABLE IF EXISTS " + DiabappContract.Rol.TABLE_NAME;
    private static final String SQL_DELETE_USERS = "DROP TABLE IF EXISTS " + DiabappContract.User.TABLE_NAME;
    private static final String SQL_DELETE_MEASUREMENTS = "DROP TABLE IF EXISTS " + DiabappContract.Measurement.TABLE_NAME;


    public DiabappDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void addRols(SQLiteDatabase db, String rol_name){
        ContentValues values = new ContentValues();
        values.put(DiabappContract.Rol.COLUMN_NAME_NAME, rol_name);
        db.insert(DiabappContract.Rol.TABLE_NAME, null, values);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ROLS);
        this.addRols(db,"patient");
        this.addRols(db,"doctor");

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_MEASUREMENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DELETE_ROLS);
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_MEASUREMENTS);
        onCreate(db);

    }
}

