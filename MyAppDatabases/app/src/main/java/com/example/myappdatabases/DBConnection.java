package com.example.myappdatabases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnection extends SQLiteOpenHelper {

    final static String DbName = "BDGestStg.db";
    final static String TableName = "Stagiaires";
    final public static String ChampId = "idStg";
    final public static String ChampNom = "nomStg";
    final public static String ChampFiliere = "filiereStg";
    final static int Vertion = 1;
    final static String reqCreationTableStg = "CREATE TABLE "+TableName+" ("+ChampId+" INTIGER PRIMARY KEY," +
            ChampNom+" STRING,"+ChampFiliere+" STRING)";

    public DBConnection(Context context) {
        super(context, DbName, null, Vertion);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(reqCreationTableStg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table "+TableName);
    }

    public void AjouterStagiaire(Stagiaire stg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues Ligne = new ContentValues();
        Ligne.put(ChampId,stg.getNumStg());
        Ligne.put(ChampNom,stg.getNomStg());
        Ligne.put(ChampFiliere,stg.getFiliereStg());
        db.insert(TableName,null,Ligne);
    }

    public ArrayList<Stagiaire> ListeStagiaire(){
        ArrayList<Stagiaire> listeStg = new ArrayList<Stagiaire>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor crStg = db.rawQuery("select * from "+TableName,null);
        crStg.moveToFirst();
        while (!crStg.isAfterLast()){
            Stagiaire stg = new Stagiaire();
            stg.setNumStg(crStg.getInt(crStg.getColumnIndex(ChampId)));
            stg.setNomStg(crStg.getString(crStg.getColumnIndex(ChampNom)));
            stg.setFiliereStg(crStg.getString(crStg.getColumnIndex(ChampFiliere)));
            listeStg.add(stg);
            crStg.moveToNext();
        }
        return listeStg;
    }

    public Cursor ListeStagiairesCursor(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] colu = new String[]{"rowid _id",ChampId,ChampNom,ChampFiliere};
        Cursor crStgs = db.query(TableName,colu,null,null,
                null,null,null );
        //Cursor crStgs = db.rawQuery("select * from "+TableName,null);
        return crStgs;
    }

    public Cursor RechercheStagiaire(ArrayList<String> Vals,String Selection){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] colu = new String[]{"rowid _id",ChampId,ChampNom,ChampFiliere};
        String Valeurs[] = new String[Vals.size()];
        Valeurs = Vals.toArray(Valeurs);
        Cursor crStgs=db.query(TableName,colu,Selection,Valeurs,null,null,null );
        return crStgs;
    }

    public void modifierStagiaire(String id,String nom,String fil){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+TableName+" SET "+ChampNom+"='"+nom+"', "+ChampFiliere+"='"+fil+"' WHERE "+ChampId+"="+id);
        //return "UPDATE "+TableName+" SET "+ChampNom+"='"+nom+"', "+ChampFiliere+"='"+fil+"' WHERE "+ChampId+"="+id;
    }

    public void supprimerStagiaire(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TableName+" WHERE "+ChampId+"="+id);
    }
}
