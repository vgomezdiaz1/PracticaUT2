package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmacionDatosCarrerasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos_carreras);
        Intent i = getIntent();

        TextView textoNombre = findViewById(R.id.textViewAlumno);
        textoNombre.setText(i.getStringExtra("nombre"));

        TextView textoFlex = findViewById(R.id.textViewFlex);
        textoFlex.setText(i.getStringExtra("Flexivilidad"));

        TextView textoFuer = findViewById(R.id.textViewFuer);
        textoFuer.setText(i.getStringExtra("Fuerza"));

        TextView textoVel = findViewById(R.id.textViewVel);
        textoVel.setText(i.getStringExtra("Velocidad"));

        TextView textoRes = findViewById(R.id.textViewRes);
        textoRes.setText(i.getStringExtra("Resistencia"));

        TextView textoTrimestre = findViewById(R.id.textViewTrimestre);
        textoTrimestre.setText(i.getStringExtra("Trimestre"));

        TextView textoID = findViewById(R.id.textViewID);
        textoID.setText(i.getStringExtra("id"));
    }
    public void pulsacionBtnGuardar(View v) {
        TextView textoFlex = findViewById(R.id.textViewFlex);
        TextView textoFuer = findViewById(R.id.textViewFuer);
        TextView textoVel = findViewById(R.id.textViewVel);
        TextView textoRes = findViewById(R.id.textViewRes);
        TextView textoTrimestre = findViewById(R.id.textViewTrimestre);
        TextView textoID = findViewById(R.id.textViewID);
        //Guardamos los datos en variables
        String Flexivilidad = textoFlex.getText().toString();
        String Fuerza = textoFuer.getText().toString();
        String Velocidad = textoVel.getText().toString();
        String Resistencia = textoRes.getText().toString();
        String Trimestre = textoTrimestre.getText().toString();
        String id = textoID.getText().toString();
        //Creamos un ContentValues, que es lo que guarda los datos para introducir en un BBDD
        ContentValues cv = new ContentValues();
        if(Trimestre.equals("1ºTrimestre")){
            cv.put("flexivilidad1",Flexivilidad);
            cv.put("fuerza1", Fuerza);
            cv.put("velocidad1", Velocidad);
            cv.put("resistencia1", Resistencia);
        }else {
            cv.put("flexivilidad3", Flexivilidad);
            cv.put("fuerza3", Fuerza);
            cv.put("velocidad3", Velocidad);
            cv.put("resistencia3", Resistencia);
        }
        Log.v("alumno", id + " " + Flexivilidad + " " + Fuerza + " " + Velocidad + " " + Resistencia);
        //Iniciamos la BBDD
        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.db), MODE_PRIVATE, null);
        long correcto = 0;
        String mensaje = "";
        correcto = myDB.update(" alumno ",cv, " id = ? ", new String[]{id});
        mensaje = "Datos guardados";
        if(correcto>-1){
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Se ha producido un error", Toast.LENGTH_SHORT).show();
        }
    }
}