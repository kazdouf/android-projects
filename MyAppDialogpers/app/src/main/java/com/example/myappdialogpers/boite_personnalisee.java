package com.example.myappdialogpers;


import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class boite_personnalisee extends Dialog {
    private String strtitreBoite,strMessageBoite;
    private TextView titreTxtView, messageTxtView;
    private EditText saisieEditText;
    private Button btonOk, btonNon;
    private ImageView icone;

    public boite_personnalisee( Context context) {
        super(context);
        this.setContentView(R.layout.modele_boite);
        strtitreBoite="titre par defaut";
        strMessageBoite="Message par defaut";

        this.titreTxtView = findViewById(R.id.lblTitreBoite);
        this.messageTxtView=findViewById(R.id.lblMsgBoite);
        this.saisieEditText=findViewById(R.id.txtSaisieBoite);
        this.btonOk=findViewById(R.id.btn_ok);
        this.btonNon=findViewById(R.id.btn_non);
        this.icone = findViewById(R.id.iconeBoite);
    }

    public  void setStrtitreBoite(String tr)
    {
        this.strtitreBoite=tr;
    }
    public void setStrMessageBoite(String ms)
    {
        this.strMessageBoite=ms;
    }
    public  void setTitreTxtView(TextView txtVw)
    {
        this.titreTxtView=txtVw;
    }
    public void setSaisieEditText(EditText edtSaisi)
    {
        this.saisieEditText=edtSaisi;
    }
    public EditText getSaisieEditText()
    {
        return this.saisieEditText;
    }

    public void setBtonOk(Button btOk){this.btonOk=btOk;}
    public Button getBtonOk(){return  this.btonOk;}

    public void setBtonNon(Button btNn){this.btonNon=btNn;}
    public Button getBtonNon(){return  this.btonNon;}

    public void setIcone(ImageView img){this.icone=img;}
    public ImageView getIcone(){return this.icone;}

    public void AfficherBoite()
    {
        this.show();
        this.titreTxtView.setText(strtitreBoite);
        this.messageTxtView.setText(strMessageBoite);
    }

}

