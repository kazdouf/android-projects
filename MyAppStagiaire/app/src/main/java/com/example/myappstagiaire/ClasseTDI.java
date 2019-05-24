package com.example.myappstagiaire;

import java.util.ArrayList;

public class ClasseTDI {

    private static ArrayList<Stagiaire> lstStg = new ArrayList<Stagiaire>();

    public static ArrayList<Stagiaire> getLstStg() {
        return lstStg;
    }

    public static void setLstStg(ArrayList<Stagiaire> lstStg) {
        lstStg = lstStg;
    }

    public static void AjouterStg(Stagiaire stg){
        lstStg.add(stg);
    }
}
