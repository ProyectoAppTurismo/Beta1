package com.example.fyh;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;
import static android.widget.Toast.LENGTH_LONG;

public class Resultados extends ListActivity {

    private String v_compañia;
    private String v_tipo;
    private String v_precio;
    private String v_afluencia;
    private String[]Botones;

    private DestinoDbAdapter dbAdapter;
    private Cursor cursor;
    private DestinoCursorAdapter destinoAdapter ;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        lista = (ListView) findViewById(android.R.id.list);

        dbAdapter = new DestinoDbAdapter(this);
        dbAdapter.abrir();

        v_compañia= getIntent().getExtras().getString("b_compañia");
        v_tipo= getIntent().getExtras().getString("b_tipo");
        v_precio= getIntent().getExtras().getString("b_precio");
        v_afluencia= getIntent().getExtras().getString("b_afluencia");
        //Botones=getIntent().getExtras().getStringArray("botones");
        consultar(v_compañia, v_tipo, v_precio,v_afluencia);

        /*
         * Declaramos el controlador de la BBDD y accedemos en modo escritura
         */
        DestinoDbHelper dbHelper = new DestinoDbHelper(getBaseContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Base de datos preparada", LENGTH_LONG).show();

    }




    private void consultar( String com, String tip, String pre, String afl)
    {
        cursor = dbAdapter.getCursor(com, tip, pre, afl);
        startManagingCursor(cursor);
        destinoAdapter = new DestinoCursorAdapter(this, cursor);
        lista.setAdapter(destinoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.destino, menu);
        return true;
    }
}

