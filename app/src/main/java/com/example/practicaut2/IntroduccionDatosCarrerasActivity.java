package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class IntroduccionDatosCarrerasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_datos_carreras);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.SeleccionarTrimestre, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Spinner selectorTrimestre = (Spinner)findViewById(R.id.spinnerTrimestre);
        selectorTrimestre.setSelection(0);

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        TextView nombreET = findViewById(R.id.textViewNombreAlumno);
        nombreET.setText(nombre);
        String id = i.getStringExtra("id");
        TextView idET = findViewById(R.id.editTextIDAlumnoCarreras);
        idET.setText(id);
        String grupo = i.getStringExtra("grupo");
        String sexo = i.getStringExtra("sexo");
        String edad = i.getStringExtra("edad");

    }
    public void pulsacionBtnAceptar(View v) {
        int n = 0;
        String tIdentificador = "";
        String tNickName = "";
        String tFlex = "";
        String tFuer = "";
        String tVel = "";
        String tRes = "";
        String tTrimestre = "";

        EditText tid = findViewById(R.id.editTextIDAlumnoCarreras);
        TextView tNom = findViewById(R.id.textViewNombreAlumno);
        Spinner selectorTrimestre = (Spinner)findViewById(R.id.spinnerTrimestre);
        EditText tFlexivilidad = findViewById(R.id.editTextFlexibilidad);
        EditText tFuerza = findViewById(R.id.editTextFuerza);
        EditText tVelocidad = findViewById(R.id.editTextVelocidad);
        EditText tResistencia = findViewById(R.id.editTextResistencia);

        if (comprobarVacios(tFlexivilidad)) {
            tFlex = tFlexivilidad.getText().toString();
            n++;
        }
        if (comprobarVacios(tFuerza)) {
            tFuer = tFuerza.getText().toString();
            n++;
        }
        if (comprobarVacios(tVelocidad)) {
            tVel = tVelocidad.getText().toString();
            n++;
        }
        if (comprobarVacios(tResistencia)) {
            tRes = tResistencia.getText().toString();
            n++;
        }
        tTrimestre =(String) selectorTrimestre.getSelectedItem();

        if (n == 4) {
            tIdentificador = tid.getText().toString();
            tNickName = tNom.getText().toString();
            Intent i = new Intent(this, ConfirmacionDatosCarrerasActivity.class);
            i.putExtra("nombre", tNickName);
            i.putExtra("Flexivilidad", tFlex);
            i.putExtra("Fuerza", tFuer);
            i.putExtra("Velocidad", tVel);
            i.putExtra("Resistencia", tRes);
            i.putExtra("Trimestre", tTrimestre);
            i.putExtra("id",tIdentificador);
            startActivity(i);
        } else {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean comprobarVacios(EditText x) {
        if (x.getText().toString().equals("")) {
            x.requestFocus();
            x.setBackgroundTintList(getColorStateList(R.color.purple_200));
            return false;
        } else {
            x.setBackgroundTintList(getColorStateList(R.color.teal_700));
            return true;
        }
    }
}