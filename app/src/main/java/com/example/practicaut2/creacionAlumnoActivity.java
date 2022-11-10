package com.example.practicaut2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class creacionAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_alumno);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.GrupoClase, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.SeleccionarSexoAlumno, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);

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
            if(sexoArray[j].equals(grupo)){
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
        if (n == 2) {
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

    public void pulsacionBtnCargarContacto(View v) {
        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, 34);
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