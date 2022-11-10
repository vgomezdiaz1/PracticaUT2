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
                        " edad Integer)"
        );
        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS prueba " +
                        "(idPrueba Integer PRIMARY KEY AUTOINCREMENT, " +
                        " idAlumno Integer, " +
                        " trimestre Integer, " +
                        " flexivilidad double," +
                        " fuerza double, " +
                        " velocidad double, " +
                        " resistencia double," +
                        " FOREIGN KEY (idAlumno) REFERENCES alumno(id))"
        );
    }

    public void pulsacionBtnNuevoAlumno(View v) {
        Intent i = new Intent(this, CreacionAlumnoActivity.class);
        startActivity(i);
    }

    public void pulsacionBtnIntroducionDatos(View v) {
        Intent i = new Intent(this, ListadoCompletoActivity.class);
        i.putExtra("introduccion",true);
        startActivity(i);
    }

    public void pulsacionBtnVerAlumno(View v) {
        Intent i = new Intent(this, CreacionAlumnoActivity.class);
        startActivity(i);
    }

    public void pulsacionBtnverTodosAlumnos(View v) {
        Intent i = new Intent(this, ListadoCompletoActivity.class);
        i.putExtra("introduccion",false);
        startActivity(i);
    }
}