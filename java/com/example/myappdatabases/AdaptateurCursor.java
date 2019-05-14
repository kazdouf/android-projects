package com.example.myappdatabases;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class AdaptateurCursor extends SimpleCursorAdapter {


    public AdaptateurCursor(Context context, Cursor c, String[] from, int[] to) {
        super(context, R.layout.modevuestg, c, from, to, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.modevuestg, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);


        int id = cursor.getInt(cursor.getColumnIndexOrThrow("idStg"));
        String nom = cursor.getString(cursor.getColumnIndexOrThrow("nomStg"));
        String filiere = cursor.getString(cursor.getColumnIndexOrThrow("filiereStg"));

        /*((TextView)(convertView.findViewById(R.id.lblId))).setText(String.valueOf(Stgr.getNumStg()));
        ((TextView)(convertView.findViewById(R.id.lblNom))).setText(Stgr.getNomStg());
        ((TextView)(convertView.findViewById(R.id.lblFiliere))).setText(Stgr.getFiliereStg());*/
    }
}
