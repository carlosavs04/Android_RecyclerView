package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.recyclerview.Adaptadores.PersonaAdaptador;
import com.example.recyclerview.Modelos.Persona;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Persona> p = new ArrayList<>();

        p.add(new Persona("Carlos", "8713321257"));
        p.add(new Persona("RamiGOD", "8713331257"));
        p.add(new Persona("Luis", "8713312257"));

        PersonaAdaptador adPersona = new PersonaAdaptador(p);
        LinearLayoutManager linearManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setAdapter(adPersona);
        recycler.setLayoutManager(linearManager);
        recycler.setHasFixedSize(true);
    }
}