package com.example.myappfacture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

public class AdapterProduit extends ArrayAdapter<Produit> implements ListAdapter {

    //ListView lstv;
    //CatalogProduit ctgP;
    Context ctx;



    public AdapterProduit(Context context,List<Produit> objects) {
        super(context, 0, objects);

        ctx = context;
    }


    public View getView(int Position, View convertView, ViewGroup Parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.modeleitemproduit,
                    Parent,false);
        }

        Produit p = getItem(Position);
        ((TextView)convertView.findViewById(R.id.lblidProd)).setText(p.getIdProd());
        ((TextView)convertView.findViewById(R.id.lblnomProd)).setText(p.getNomProd());
        String nomPackage = ctx.getPackageName();
        int idph = ctx.getResources().getIdentifier(p.getPhotoProd(),"drawable",nomPackage);
        ((ImageView)convertView.findViewById(R.id.photoProd)).setImageResource(idph);

        return convertView;
    }

}
