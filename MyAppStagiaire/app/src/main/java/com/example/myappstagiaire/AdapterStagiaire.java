package com.example.myappstagiaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterStagiaire extends ArrayAdapter<Stagiaire> {

    Context ctx;

    public AdapterStagiaire( Context context, List<Stagiaire> objects) {
        super(context, 0, objects);
        ctx = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.modelstg,parent,false);
        }
        Stagiaire stg = getItem(position);
        ((TextView)convertView.findViewById(R.id.txtNumStg)).setText(stg.getNumStg());
        ((TextView)convertView.findViewById(R.id.txtNomStg)).setText(stg.getNomStg());
        int idimg = ctx.getResources().getIdentifier(stg.getPhotoStg(),"drawable",ctx.getPackageName());
        ((ImageView)convertView.findViewById(R.id.imgStagiaire)).setImageResource(idimg);
        return convertView;
    }
}
