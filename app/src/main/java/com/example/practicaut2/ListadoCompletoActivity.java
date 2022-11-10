package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ListadoCompletoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_completo);
        ArrayList<Alumno> lista = new ArrayList<>();

        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.db), MODE_PRIVATE, null);
        Cursor cursor = myDB.rawQuery("select * from alumno",null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String grupo = cursor.getString(2);
            String sexo = cursor.getString(3);
            String edad = cursor.getString(4);
            Log.v("alumno", id + nombre + " " + grupo + " " + edad + " " + sexo);
            lista.add(new Alumno(id,nombre,grupo,sexo,edad));
        }
        RecyclerView rv = findViewById(R.id.lista_Alumnos);
        rv.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        MiAdaptador adaptador = new MiAdaptador(lista);
        rv.setAdapter(adaptador);

    }
}