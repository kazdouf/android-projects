package com.example.myappstagiaire;

public class Stagiaire {

    private int NumStg;
    private String NomStg;
    private String PhotoStg;

    public Stagiaire(){}
    public Stagiaire(int Num,String Nom,String Ph){
        NumStg = Num;
        NomStg = Nom;
        PhotoStg = Ph;
    }

    public int getNumStg() {
        return NumStg;
    }

    public void setNumStg(int numStg) {
        NumStg = numStg;
    }

    public String getNomStg() {
        return NomStg;
    }

    public void setNomStg(String nomStg) {
        NomStg = nomStg;
    }

    public String getPhotoStg() {
        return PhotoStg;
    }

    public void setPhotoStg(String photoStg) {
        PhotoStg = photoStg;
    }
}
