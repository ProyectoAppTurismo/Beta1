package com.example.fyh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class prueba2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba2);

        Button btn = (Button) findViewById(R.id.siguiente);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //String botones[]=new String[]{BotonesCompañia(),BotonesTipo(),BotonesPrecio(),BotonesAfluencia()};
                Intent intent = new Intent(view.getContext(), Resultados.class);
                intent.putExtra("b_compañia", BotonesCompañia() );
                intent.putExtra("b_tipo", BotonesTipo() );
                intent.putExtra("b_precio", BotonesPrecio() );
                intent.putExtra("b_afluencia", BotonesAfluencia() );
                startActivityForResult(intent, 0);

            }
        });



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {
             //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
          //  }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public String BotonesCompañia(){
        String compañia="";
        RadioButton solo= (RadioButton) findViewById(R.id.solo);
        RadioButton amigos= (RadioButton) findViewById(R.id.amigos);
        RadioButton pareja= (RadioButton) findViewById(R.id.pareja);
        RadioButton familia= (RadioButton) findViewById(R.id.familia);
        if (solo.isChecked())
            compañia= "solo";
        if (pareja.isChecked())
            compañia= "pareja";
        if (familia.isChecked())
            compañia= "familia";
        if (amigos.isChecked())
            compañia= "amigos";
        return compañia;
    }

    public String BotonesTipo(){
        String tipo="";
        RadioButton costa= (RadioButton) findViewById(R.id.costa);
        RadioButton interior = (RadioButton) findViewById(R.id.interior);

        if (costa.isChecked())
            tipo= "costa";
        if (interior.isChecked())
            tipo= "interior";

        return tipo;
    }
    public String BotonesPrecio(){
        String precio ="";
        RadioButton bajo = (RadioButton) findViewById(R.id.precio_bajo);
        RadioButton medio = (RadioButton) findViewById(R.id.precio_medio);
        RadioButton alto = (RadioButton) findViewById(R.id.precio_alto);


            if (bajo.isChecked()) {
                precio = "€";
            }
            if (medio.isChecked()) {
                precio = "€€";
            }
            if (alto.isChecked()) {
                precio = "€€€";
            }


           // Toast.makeText(getBaseContext(), "SELECCIONA UN PRECIO", LENGTH_LONG).show();;

        return precio;
    }

    public String BotonesAfluencia(){
        String afluencia ="";
        RadioButton baja = (RadioButton) findViewById(R.id.baja);
        RadioButton media = (RadioButton) findViewById(R.id.media);
        RadioButton alta = (RadioButton) findViewById(R.id.alta);

        if (baja.isChecked())
            afluencia= "baja";
        if (media.isChecked())
            afluencia= "media";
        if (alta.isChecked())
            afluencia= "alta";
        return afluencia;
    }
}