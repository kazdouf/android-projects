package com.example.myappdialogpers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mi=new MenuInflater(MenuActivity.this);
        mi=this.getMenuInflater();
        mi.inflate(R.menu.contenumenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
       /* switch(id){
            case R.id.infos:fonction1();
            break;or return;
            case R.id.params:fonction2();
            break;
        }*/
        Toast.makeText(getApplicationContext(), item.getTitle().toString(), Toast.LENGTH_LONG).show();
        return true;
    }
}
