package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.db), MODE_PRIVATE, null);
        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS alumno " +
                        "(id Integer PRIMARY KEY AUTOINCREMENT," +
                        " nombre VARCHAR(50), " +
                        " grupo VARCHAR(2), " +
                        " sexo VARCHAR(10), " +
                        " edad Integer," +
                        "flexivilidad1 double default -1," +
                        "flexivilidad3 double default -1," +
                        "fuerza1 double default -1," +
                        "fuerza3 double default -1," +
                        "velocidad1 double default -1," +
                        "velocidad3 double default -1," +
                        "resistencia1 double default -1," +
                        "resistencia3 double default -1)"
        );
    }

    public void pulsacionBtnNuevoAlumno(View v) {
        Intent i = new Intent(this, IntroduccionDatosAlumnoActivity.class);
        startActivity(i);
    }

    public void pulsacionBtnIntroducionDatos(View v) {
        Intent i = new Intent(this, ListadoCompletoActivity.class);
        i.putExtra("introduccion",true);
        startActivity(i);
    }

    public void pulsacionBtnVerAlumno(View v) {
        Intent i = new Intent(this, IntroduccionDatosAlumnoActivity.class);
        startActivity(i);
    }

    public void pulsacionBtnverTodosAlumnos(View v) {
        Intent i = new Intent(this, ListadoCompletoActivity.class);
        i.putExtra("introduccion",false);
        startActivity(i);
    }
}