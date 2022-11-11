package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;

public class ListadoCompletoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_completo);
        ArrayList<Alumno> lista = new ArrayList<>();

        Intent i = getIntent();
        Boolean introduccion = i.getBooleanExtra("introduccion",false);

        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.db), MODE_PRIVATE, null);
        Cursor cursor = myDB.rawQuery("select * from alumno",null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String grupo = cursor.getString(2);
            String sexo = cursor.getString(3);
            String edad = cursor.getString(4);
            double flexibilidad1 = cursor.getDouble(5);
            double flexibilidad3 = cursor.getDouble(6);
            double fuerza1= cursor.getDouble(7);
            double fuerza3 = cursor.getDouble(8);
            double velocidad1= cursor.getDouble(9);
            double velocidad3 = cursor.getDouble(10);
            double resistencia1 = cursor.getDouble(11);
            double resistencia3 = cursor.getDouble(12);
            Log.v("alumno", id + " " + nombre + " " + grupo + " " + edad + " " + sexo + " " + flexibilidad1
                    + " " + flexibilidad3 + " " + fuerza1 +" " + fuerza3 + " " + velocidad1 + " " + velocidad3
            + " " + resistencia1 + " " + resistencia3);
            lista.add(new Alumno(id,nombre,grupo,sexo,edad,flexibilidad1,flexibilidad3,fuerza1,fuerza3,
                    velocidad1,velocidad3,resistencia1,resistencia3));
        }
        RecyclerView rv = findViewById(R.id.lista_Alumnos);
        rv.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        MiAdaptadorListadoAlumnosCompleto adaptador = new MiAdaptadorListadoAlumnosCompleto(lista);
        rv.setAdapter(adaptador);
    }
}