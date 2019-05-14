package com.example.myappdatabases;

public class Stagiaire {

    private int numStg;
    private String nomStg;
    private String filiereStg;

    public Stagiaire(){}
    public Stagiaire(int num,String nom,String fil){
        numStg = num;
        nomStg = nom;
        filiereStg = fil;
    }

    public int getNumStg() {
        return numStg;
    }

    public String getNomStg() {
        return nomStg;
    }

    public String getFiliereStg() {
        return filiereStg;
    }

    public void setNumStg(int numStg) {
        this.numStg = numStg;
    }

    public void setNomStg(String nomStg) {
        this.nomStg = nomStg;
    }

    public void setFiliereStg(String filiereStg) {
        this.filiereStg = filiereStg;
    }
}
