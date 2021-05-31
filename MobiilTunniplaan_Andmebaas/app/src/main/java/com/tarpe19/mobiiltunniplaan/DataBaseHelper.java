package com.tarpe19.mobiiltunniplaan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TUNNIPLAAN_TABLE = "TUNNIPLAAN_TABLE";
    public static final String COLUMN_GROUP_NAME = "GROUP_NAME";
    public static final String COLUMN_CLASS = "CLASS";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TEACHER_NAME = "TEACHER_NAME";
    public static final String COLUMN_DAY = "DAY";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "Tunniplaan.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableTunniplaan = "CREATE TABLE " + TUNNIPLAAN_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_GROUP_NAME + "," + COLUMN_CLASS + "," + COLUMN_DATE + "," + COLUMN_TEACHER_NAME + ", " + COLUMN_DAY + ")";

        db.execSQL(createTableTunniplaan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean addOne(TunniplaaniModel tunniplaaniModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GROUP_NAME, TunniplaaniModel.getGroup_name());
        cv.put(COLUMN_CLASS, TunniplaaniModel.getGroup_name());
        cv.put(COLUMN_DATE, TunniplaaniModel.getGroup_name());
        cv.put(COLUMN_TEACHER_NAME, TunniplaaniModel.getGroup_name());
        cv.put(COLUMN_DAY, TunniplaaniModel.getGroup_name());

        long insert = db.insert(TUNNIPLAAN_TABLE, null, cv);
        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean deleteOne(TunniplaaniModel tunniplaaniModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TUNNIPLAAN_TABLE + " WHERE " + COLUMN_ID + " = " + tunniplaaniModel.getId();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }
    public List<TunniplaaniModel> getTunniplaan() {
        List<TunniplaaniModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + TUNNIPLAAN_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            do {
                int TunniplaaniID = cursor.getInt(0);
                String GroupName = cursor.getString(1);
                String Class = cursor.getString(2);
                int Date = cursor.getInt(3);
                String TeacherName = cursor.getString(4);
                String Day = cursor.getString(5);

                TunniplaaniModel tunniplaaniModel = new TunniplaaniModel(TunniplaaniID,GroupName, Date ,Class, TeacherName, Day);

            }while(cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }

}
