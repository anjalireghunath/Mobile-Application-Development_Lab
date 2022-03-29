package com.example.enquiryperson;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper {
    static String DbName="Enquiry.db";
    static String TableName="Search";
    static String Col1="Id";
    static String Col2="Name";
    static String Col3="PersonId";
    static String Col4="EmailId";
    static String Col5="Number";
    static String Col6="Place";
    public DatabaseHelper( Context context) {
        super(context, DbName, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String command="create table "+TableName+"("+
                Col1+" integer primary key autoincrement,"+
                Col2+" text,"+
                Col3+" text,"+
                Col4+" text,"+
                Col5+" text,"+
                Col6+" text)";
        db.execSQL(command);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean InsertData(String Name,String PersonId,String EmailId,String Number,String Place)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col2,Name);
        cv.put(Col3,PersonId);

        cv.put(Col4,EmailId);
        cv.put(Col5,Number);
        cv.put(Col6,Place);
        long query=db.insert(TableName,null,cv);
        if(query==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
    public Cursor searchData(String PersonId)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String retrieve="select * from "+TableName+" where "+Col3+"='"+PersonId+"'";
        Cursor cu=db.rawQuery(retrieve,null);
        return cu;
    }
    public void deleteData(String PersonId)
    {
        SQLiteDatabase db=this.getWritableDatabase();
       db.delete(TableName,"Col3=?",new String[]{PersonId});
        db.close();
        }
    }
