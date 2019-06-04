package com.example.myappdblearn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnection extends SQLiteOpenHelper {

    private static final String Name = "MyProducts.db";
    private static final int Version = 1;

    public DBConnection(Context context) {
        super(context, Name,null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists Admins (id INTEGER PRIMARY KEY ASC,name TEXT,email TEXT)");

        db.execSQL("create table if not exists adminProducts (adminId INTEGER PRIMARY KEY, PrdName TEXT," +
                "   FOREIGN KEY ('adminId') REFERENCES 'Admins'('id'))");

        db.execSQL("CREATE VIEW IF NOT EXISTS AdminsProducts AS " +
                " SELECT id,name,email,PrdName FROM Admins A,adminProducts Ap" +
                " WHERE A.id = Ap.adminId");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Admins");
        db.execSQL("drop table if exists adminProducts");
        onCreate(db);
    }

    public void insertAdmin(String n,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put("name",n);
        CV.put("email",email);
        db.insert("Admins",null,CV);
    }

    public void insertProduct(String n,int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put("PrdName",n);
        CV.put("adminId",id);
        db.insert("adminProducts",null,CV);
    }

    /*public void dropTable(SQLiteDatabase db) {
        db.execSQL("drop table if exists Admins ");
    }*/

    public ArrayList getAllRecords(){
        ArrayList lstAdmins = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(" select * from Admins ",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            lstAdmins.add(res.getString(res.getColumnIndex("id"))+
                    "  Name : " +res.getString(res.getColumnIndex("name"))+
                    " - Email : "+res.getString(res.getColumnIndex("email"))
            );
            res.moveToNext();
        }
        return lstAdmins;
    }

    public ArrayList getAdminsSpin(){
        ArrayList lstAdmins = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(" select * from Admins ",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            lstAdmins.add(res.getString(res.getColumnIndex("id"))+
                    " : " +res.getString(res.getColumnIndex("name"))
            );
            res.moveToNext();
        }
        return lstAdmins;
    }

    public ArrayList getAllRecordsPrds(){
        ArrayList lstAdmins = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(" select * from AdminsProducts ",null);
        res.moveToFirst();
        while (res.isAfterLast() == false){
            lstAdmins.add(res.getString(res.getColumnIndex("id"))+
                        "  Name : " +res.getString(res.getColumnIndex("name"))+
                        " - Email : "+res.getString(res.getColumnIndex("email"))+
                    " - Product Name : "+res.getString(res.getColumnIndex("PrdName"))
            );
            res.moveToNext();
        }
        return lstAdmins;
    }

    public void deleteAdmin(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Admins WHERE id="+Integer.toString(id));
        //db.delete("Admin","id=?,name=",new String[]{Integer.toString(id),"someNmae"});
    }

    public void updateAdmin(Integer id,String n,String e){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Admins set name='"+n+"',email='"+e+"' WHERE id="+Integer.toString(id));

        /*ContentValues CV = new ContentValues();
        CV.put("name",n);
        CV.put("email",e);
        db.update("Admins",CV,"id=?,name=?",new String[]{id.toString(),"someName"});*/
    }
}
