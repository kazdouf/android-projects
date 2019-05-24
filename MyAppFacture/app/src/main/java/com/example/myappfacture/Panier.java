package com.example.myappfacture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Panier implements Serializable {

    private static List<Produit> Pan = new ArrayList<>();
    private static int qte = 1;
    private static double TotalPan = 0;

    public static void ajouterProdPan (Produit p){
        if(!rechercheProd(p.getIdProd())){
            Pan.add(p);
         //   TotalPan+=p.getPrix();
        }
    }

   /* public static double getTotalPan() {
        return TotalPan;
    }*/

    public static List<Produit> getPan() {
        return Pan;
    }

    public static boolean rechercheProd(String id){
        boolean exist = false;
        for(int i=0;i<Pan.size();i++){
            if(Pan.get(i).getIdProd().equals(id)){
                exist = true; break;
            }
        }
        return exist;
    }
}
