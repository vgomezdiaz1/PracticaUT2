package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultarAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_alumno);
    }

    public void pulsacionBtnAceptar(View v) {
        ArrayList<Alumno> lista = new ArrayList<>();
        EditText tNom = findViewById(R.id.editTextNickName2);
        Spinner selectorGrupo = (Spinner) findViewById(R.id.spinnerSeleccionGrupo2);
        Spinner selectorSexo = (Spinner) findViewById(R.id.spinnerSexo2);
        String seleccionSexo =(String)  selectorSexo.getSelectedItem();
        String seleccionGrupo =(String)  selectorGrupo.getSelectedItem();
        if(tNom.equals("") && seleccionGrupo.equals("Todos") && seleccionSexo.equals("Todos")){
            Toast.makeText(this, "Tienes que meter algun criterio de busqueda", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(this, ListarAlumnoActivity.class);
            i.putExtra("nombre", tNom.getText().toString());
            i.putExtra("grupo", seleccionGrupo);
            i.putExtra("sexo", seleccionSexo);
            startActivity(i);
        }
    }
}