package com.miniproject.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.firebase.client.Firebase;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;

/**
 * Created by kishor on 9/7/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final int dtabase_version=1;
    public static final String database_name = "rotaract";
    public static final String tablename = "bdtable";
    public static final String table_rno = "rno";
    public static final String table_name = "name";
    public static final String table_dept = "dept";
    public static final String table_year = "year";
    public static final String phonenumber = "phone_number";
    public static final String bg = "blood_group";
    //public Firebase fb;


    public DatabaseHelper(Context context) {
        super(context, database_name , null , 1);
        //fb = new Firebase('https://blooddonation-31019.firebaseio.com/');
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tablename + " (" + table_rno + " INTEGER PRIMARY KEY,"
                + table_name + " TEXT," + table_dept + " TEXT," + table_year + " INTEGER,"
                + phonenumber + " INTEGER," + bg + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+tablename);
        onCreate(db);

    }
    public Boolean adddata(String rn,String na,String de,String y,String p,String b)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (rn == "")
        {
            return false;
        }
        contentValues.put(table_rno, rn);
        contentValues.put(table_name, na);
        contentValues.put(table_dept, de);
        contentValues.put(table_year, y);
        contentValues.put(phonenumber, p);
        contentValues.put(bg, b);
        long  r = db.insert(tablename, null, contentValues );
        db.close();
        if (r == -1){
            return false;
        }
            return true;
    }
    public Cursor search(String s)
    {
        SQLiteDatabase db=getWritableDatabase();
        if(s.isEmpty()) {
            Cursor r = db.rawQuery("select * from " + tablename, null);
            return r;
        }
        Cursor r = db.rawQuery("select * from bdtable where blood_group = \"" + s + "\";", null);
        return r;
    }
    public Integer deletedata(String t1,String c1){
        SQLiteDatabase db=getWritableDatabase();
        if(c1 == "k1")
        {
            return db.delete(tablename, "rno = ?", new String[]{t1});
        }else return db.delete(tablename, "year = ?", new String[]{t1});
    }
    public Integer updatedata(String rn,String na,String de,String y,String p,String b)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(table_rno, rn);
        contentValues.put(table_name, na);
        contentValues.put(table_dept, de);
        contentValues.put(table_year, y);
        contentValues.put(phonenumber, p);
        contentValues.put(bg, b);
        return db.update(tablename,contentValues,"rno = ?",new String[]{ rn });
    }
}

