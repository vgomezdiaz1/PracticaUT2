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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alumno);
        ArrayList<Alumno> lista = new ArrayList<>();

        Intent i = getIntent();

        String tNom = i.getStringExtra("nombre");

        String seleccionGrupo = i.getStringExtra("grupo");

        String seleccionSexo = i.getStringExtra("sexo");

        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.db), MODE_PRIVATE, null);
        Cursor cursor = null;
        if (seleccionGrupo.equals("Todos") && seleccionSexo.equals("Todos")) {
            cursor = myDB.rawQuery("select * from alumno where nombre = ? ", new String[]{tNom});
        } else if (seleccionGrupo.equals("Todos") && tNom.equals("")) {
            cursor = myDB.rawQuery("select * from alumno where sexo = ? ", new String[]{seleccionSexo});
        } else if (seleccionSexo.equals("Todos") && tNom.equals("")) {
            cursor = myDB.rawQuery("select * from alumno where grupo = ? ", new String[]{seleccionGrupo});
        } else if (seleccionGrupo.equals("Todos")) {
            cursor = myDB.rawQuery("select * from alumno where sexo = ? and nombre = ? ", new String[]{seleccionSexo, tNom});
        } else if (seleccionSexo.equals("Todos")) {
            cursor = myDB.rawQuery("select * from alumno where grupo = ? and nombre = ? ", new String[]{seleccionGrupo, tNom});
        } else if (tNom.equals("")) {
            cursor = myDB.rawQuery("select * from alumno where grupo = ? and sexo = ? ", new String[]{seleccionGrupo, seleccionSexo});
        } else {
            cursor = myDB.rawQuery("select * from alumno where nombre = ? and grupo = ? and sexo = ? ", new String[]{tNom, seleccionGrupo, seleccionSexo});
        }
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String grupo = cursor.getString(2);
            String sexo = cursor.getString(3);
            String edad = cursor.getString(4);
            double flexibilidad1 = cursor.getDouble(5);
            double flexibilidad3 = cursor.getDouble(6);
            double fuerza1 = cursor.getDouble(7);
            double fuerza3 = cursor.getDouble(8);
            double velocidad1 = cursor.getDouble(9);
            double velocidad3 = cursor.getDouble(10);
            double resistencia1 = cursor.getDouble(11);
            double resistencia3 = cursor.getDouble(12);
            Log.v("alumno", id + " " + nombre + " " + grupo + " " + edad + " " + sexo + " " + flexibilidad1
                    + " " + flexibilidad3 + " " + fuerza1 + " " + fuerza3 + " " + velocidad1 + " " + velocidad3
                    + " " + resistencia1 + " " + resistencia3);
            lista.add(new Alumno(id, nombre, grupo, sexo, edad, flexibilidad1, flexibilidad3, fuerza1, fuerza3,
                    velocidad1, velocidad3, resistencia1, resistencia3));
        }
        RecyclerView rv = findViewById(R.id.lista_Alumnos);
        rv.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        MiAdaptadorListadoAlumnosCompleto adaptador = new MiAdaptadorListadoAlumnosCompleto(lista);
        rv.setAdapter(adaptador);
    }
}
