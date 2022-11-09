package com.example.practicaut2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmacionAlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_alumno);
        Intent i = getIntent();

        TextView textoNombre = findViewById(R.id.textNickNameConfirmacion);
        textoNombre.setText(i.getStringExtra("nombre"));

        TextView textoGrupo = findViewById(R.id.textGrupoConfrimacion);
        textoGrupo.setText(i.getStringExtra("grupo"));

        TextView textoSexo = findViewById(R.id.textSexoConfirmacion);
        textoSexo.setText(i.getStringExtra("sexo"));

        TextView textoEdad = findViewById(R.id.textEdadConfirmacion);
        textoEdad.setText(i.getStringExtra("edad"));

        TextView textoID = findViewById(R.id.textID);
        textoID.setText(i.getStringExtra("id"));
    }

    public void pulsacionBtnGuardar(View v) {
        //Cogemos los datos de los textView
        TextView textoNombre = findViewById(R.id.textNickNameConfirmacion);
        TextView textoGrupo = findViewById(R.id.textGrupoConfrimacion);
        TextView textoSexo = findViewById(R.id.textSexoConfirmacion);
        TextView textoEdad = findViewById(R.id.textEdadConfirmacion);
        TextView textoID = findViewById(R.id.textID);
        //Guardamos los datos en variables
        String nombre = textoNombre.getText().toString();
        String grupo = textoGrupo.getText().toString();
        String sexo = textoSexo.getText().toString();
        String edad = textoEdad.getText().toString();
        String id = textoID.getText().toString();
        //Creamos un ContentValues, que es lo que guarda los datos para introducir en un BBDD
        ContentValues cv = new ContentValues();
        cv.put("nombre", nombre);
        cv.put("grupo",grupo);
        cv.put("sexo", sexo);
        cv.put("edad", edad);
        //Iniciamos la BBDD
        SQLiteDatabase myDB = openOrCreateDatabase(getResources().getString(R.string.db), MODE_PRIVATE, null);

        long correcto = 0;
        String mensaje = "";
        if(id.equals("")){
            //Insertamos los datos en la BBDD
            correcto = myDB.insert("alumno",null, cv);
            mensaje = "Contacto guardado";
        }else{
            correcto = myDB.update("alumno",cv, "id = ? ", new String[]{id});
            mensaje = "Registro actualizado";
        }
        if(correcto>-1){
            //Creamos un toast que nos confirme que todo esta correcto
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            //Volvemos a la pagina principal
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Se ha producido un error", Toast.LENGTH_SHORT).show();
        }
    }
}