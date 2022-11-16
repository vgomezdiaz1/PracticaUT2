package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class IntroduccionDatosAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduccion_datos_alumno);

        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        EditText nombreET = findViewById(R.id.editTextNickName);
        nombreET.setText(nombre);
        String grupo = i.getStringExtra("grupo");
        String[] grupoArray = getResources().getStringArray(R.array.GrupoClase);
        int x = 0;
        for (int j = 0; j < grupoArray.length; j++) {
            if(grupoArray[j].equals(grupo)){
                x = j;
                break;
            }
        }
        Spinner selectorGrupo = (Spinner)findViewById(R.id.spinnerSeleccionGrupo);
        selectorGrupo.setSelection(x);
        String sexo = i.getStringExtra("sexo");
        String[] sexoArray = getResources().getStringArray(R.array.SeleccionarSexoAlumno);
        x = 0;
        for (int j = 0; j < sexoArray.length; j++) {
            if(sexoArray[j].equals(sexo)){
                x = j;
                break;
            }
        }
        Spinner selectorSexo = (Spinner) findViewById(R.id.spinnerSexo);
        selectorSexo.setSelection(x);

        String edad = i.getStringExtra("edad");
        EditText edadET = findViewById(R.id.editTextEdad);
        edadET.setText(edad);
        String id = i.getStringExtra("id");
        EditText idET = findViewById(R.id.editTextID);
        idET.setText(id);
    }

    public void pulsacionBtnAceptar(View v) {
        int n = 0;
        String tNickName = "";
        String tGrupo = "";
        String tSexo = "";
        String tEdad = "";
        String tIdentificador = "";

        EditText tNom = findViewById(R.id.editTextNickName);
        Spinner selectorGrupo = (Spinner)findViewById(R.id.spinnerSeleccionGrupo);
        Spinner selectorSexo = (Spinner) findViewById(R.id.spinnerSexo);
        EditText tEd = findViewById(R.id.editTextEdad);
        EditText tid = findViewById(R.id.editTextID);

        if (comprobarVacios(tEd)) {
            tEdad = tEd.getText().toString();
            n++;
        }
        if (comprobarVacios(tNom)) {
            tNickName = tNom.getText().toString();
            n++;
        }
        tGrupo =(String) selectorGrupo.getSelectedItem();
        tSexo =(String) selectorSexo.getSelectedItem();
        if(!tGrupo.equals("Seleccionar") && !tSexo.equals("Seleccionar")){
            n++;
        }
        if (n == 3) {
            //Si todos los campos estan llenos pasamos todos, incluido el id
            tIdentificador = tid.getText().toString();
            Intent i = new Intent(this, ConfirmacionAlumnoActivity.class);
            i.putExtra("nombre", tNickName);
            i.putExtra("grupo", tGrupo);
            i.putExtra("sexo", tSexo);
            i.putExtra("edad", tEdad);
            i.putExtra("id",tIdentificador);
            startActivity(i);
        } else {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean comprobarVacios(EditText x) {
        if (x.getText().toString().equals("")) {
            x.requestFocus();
            x.setBackgroundTintList(getColorStateList(R.color.red));
            return false;
        } else {
            x.setBackgroundTintList(getColorStateList(R.color.teal_700));
            return true;
        }
    }
}