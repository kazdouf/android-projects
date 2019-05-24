package com.example.myappfacture;

import java.io.Serializable;

public class Produit implements Serializable {

    private String idProd;
    private String nomProd;
    private String photoProd;
    private double prix;

    public Produit(){}
    public Produit(String id,String nom,String ph,double pr){
        this.idProd=id;
        this.nomProd=nom;
        this.photoProd=ph;
        this.prix = pr;
    }

    public String getIdProd(){
        return this.idProd;
    }
    public String getNomProd(){
        return this.nomProd;
    }
    public String getPhotoProd(){
        return this.photoProd;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setIdProd(String id){
        this.idProd=id;
    }
    public void setNomProd(String nom){
        this.nomProd=nom;
    }
    public void setPhotoProd(String ph){
        this.photoProd=ph;
    }

    public String toString(){
        String ch = "";
        ch+="id Produit : " + this.idProd;
        ch+=" nom Produit : " + this.nomProd;
        ch+=" photo Produit : " + this.photoProd;
        return ch;
    }
}
