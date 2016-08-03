package com.example.pc_.contactos;

import android.app.FragmentManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObtenerContactos listFragment = new ObtenerContactos();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(android.R.id.content, listFragment).commit();


    }
}
