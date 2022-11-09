package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class creacionAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_alumno);
        Spinner selectorGrupo = findViewById(R.id.spinnerSeleccionGrupo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.GrupoClase, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

    }
}