package com.example.pakraden.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.pakraden.FoodDetail;
import com.example.pakraden.Model.Order;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    private DatabaseAccess(Context context){
        this.openHelper=new Database(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public String getAddress(String name){
        c=db.rawQuery("select ProductId from OrderDetail where ProductName = 'Ayam'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()){
            String address = c.getString(0);
            buffer.append(""+address);
        }
        return buffer.toString();
    }
}
