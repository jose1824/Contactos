package com.example.pc_.contactos;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView recyclerViewLista;
    RecyclerAdapter recyclerAdapter;
    private List<Contacto> listaContactos = new ArrayList<Contacto>();
    Toolbar toolbar;

    static final String[] COLUMNAS_TABLA_CONTACTOS = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.HAS_PHONE_NUMBER,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Contacti del suo telefonino");
        setSupportActionBar(toolbar);


        recyclerViewLista = (RecyclerView) findViewById(R.id.main_recycler);

        agregarLista();

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewLista.setLayoutManager(layoutManager);

        recyclerAdapter = new RecyclerAdapter(listaContactos, MainActivity.this);
        recyclerViewLista.setAdapter(recyclerAdapter);
    }

    public void agregarLista() {
        String nombre;
        String telefono;

        Uri contentUri = ContactsContract.Contacts.CONTENT_URI;

        String query = "";

        Cursor c = getContentResolver().query(contentUri,
                COLUMNAS_TABLA_CONTACTOS,
                null,
                null,
                null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            nombre = c.getString(0);
            telefono = c.getString(1);
            listaContactos.add(new Contacto(nombre, telefono));
            c.moveToNext();
        }
        c.close();

    }
}
