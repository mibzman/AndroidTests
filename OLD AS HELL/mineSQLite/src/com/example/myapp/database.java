package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
public class database {
    public static final String MYDATABASE_NAME = "MY_DATABASE";
    public static final int MYDATABASE_VERSION = 1;


    public static final String MYDATABASE_TABLE = "Master";
    public static final String KEY_ID = "_id";
    public static final String CATEGORY = "Category";

    public static final String MYDATABASE_TABLE1 = "Items";
    public static final String KEY_ID1 = "_id";
    public static final String TYPE= "Type";
    public static final String TITLE= "Title";
    public static final String DESCRIPTION= "Description";
    public static final String PRICE= "Price";


    private static final String SCRIPT_CREATE_DATABASE =
            "create table " + MYDATABASE_TABLE + " ("
                    + KEY_ID + " integer primary key autoincrement, "
                    + CATEGORY+ " text not null);" ;

    private static final String SCRIPT_CREATE_DATABASE1 =
            "create table " + MYDATABASE_TABLE1 + " ("
                    + KEY_ID1 + " integer primary key autoincrement, "
                    + TITLE+ " text not null, "
                    + TYPE + " text not null,"
                    + DESCRIPTION + " text not null,"
                    + PRICE+ " text not null);";
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public database(Context c){
        context = c;
    }

    public database openToRead() throws android.database.SQLException {

        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }

    public database openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        sqLiteHelper.close();
    }

    public long insert(String category){

        ContentValues contentValues = new ContentValues();
        contentValues.put(CATEGORY,category);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);

    }
    public long insert1(String mid, String msid ,String sub,String mark){

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(TITLE, mid);
        contentValues1.put(TYPE,msid);
        contentValues1.put(DESCRIPTION,sub);
        contentValues1.put(PRICE,mark);
        return sqLiteDatabase.insert(MYDATABASE_TABLE1, null, contentValues1);


    }
    //public int update(String table, ContentValues values, String whereClause, String[] whereArgs){
    public long update(String sid, String sname,String sroll,int id){
        ContentValues contentValues = new ContentValues();

        System.out.println(id);

        return sqLiteDatabase.update(MYDATABASE_TABLE, contentValues, KEY_ID+"="+id, null);
    }

    public int deleteAll(){
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
    }

    public void delete_byID(int id){
        sqLiteDatabase.delete(MYDATABASE_TABLE, KEY_ID+"="+id, null);
    }
    public void delete_byID1(int id){
        sqLiteDatabase.delete(MYDATABASE_TABLE1, KEY_ID+"="+id, null);
    }


    public class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context, String name,
                            CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SCRIPT_CREATE_DATABASE);
            db.execSQL(SCRIPT_CREATE_DATABASE1);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
