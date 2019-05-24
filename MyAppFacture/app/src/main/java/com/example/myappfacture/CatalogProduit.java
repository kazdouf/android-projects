package com.example.myappfacture;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CatalogProduit extends ArrayList<Produit> {

    private List<Produit> lstProd;
    private int nbrProd = 0;

    public CatalogProduit(){
        lstProd = new ArrayList<Produit>();
    }

    public int getNbrProd() {
        return this.nbrProd;
    }

    public List<Produit> getLstProd() {
        return lstProd;
    }

    public void setLstProd(List<Produit> lstP) {
        this.lstProd = lstP;
        this.nbrProd+=lstP.size();
    }
    public void ajouterProd (Produit p){
        if(!rechercheProd(p.getIdProd())){
            //Toast.makeText(getApplicationContext(),"se Produit deja exist",Toast.LENGTH_LONG).show();
        //}else{
            lstProd.add(p);
            nbrProd++;
        }
    }
    public boolean rechercheProd(String id){
        boolean exist = false;
        for(int i=0;i<lstProd.size();i++){
            if(lstProd.get(i).getIdProd().equals(id)){
                exist = true; break;
            }
        }
        return exist;
    }
}
