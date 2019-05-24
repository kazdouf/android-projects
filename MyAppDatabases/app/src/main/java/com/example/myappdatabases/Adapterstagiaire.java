package com.example.myappdatabases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapterstagiaire extends ArrayAdapter<Stagiaire> {


    public Adapterstagiaire(Context context, List<Stagiaire> objects) {
        super(context, 0, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.modevuestg,parent,false);
        }
        Stagiaire Stgr = getItem(position);
        ((TextView)(convertView.findViewById(R.id.lblId))).setText(String.valueOf(Stgr.getNumStg()));
        ((TextView)(convertView.findViewById(R.id.lblNom))).setText(Stgr.getNomStg());
        ((TextView)(convertView.findViewById(R.id.lblFiliere))).setText(Stgr.getFiliereStg());
        return convertView;
    }
}
