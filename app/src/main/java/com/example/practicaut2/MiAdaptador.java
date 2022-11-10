package com.example.practicaut2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder> {

    ArrayList<Alumno> lista;

    public MiAdaptador(ArrayList<Alumno> lista) {
        this.lista = lista;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtid, txtNombre, txtGrupo, textSexo, txtEdad, txtLinea;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.txt_id);
            txtNombre = itemView.findViewById(R.id.ViewNombre);
            txtGrupo = itemView.findViewById(R.id.ViewGrupo);
            textSexo = itemView.findViewById(R.id.ViewEdad);
            txtEdad = itemView.findViewById(R.id.ViewSexo);
            txtLinea = itemView.findViewById(R.id.viewPasarLinea);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(itemView.getContext(),creacionAlumnoActivity.class);
                    i.putExtra("nombre",txtNombre.getText().toString());
                    i.putExtra("grupo",txtGrupo.getText().toString());
                    i.putExtra("sexo",textSexo.getText().toString());
                    i.putExtra("edad",txtEdad.getText().toString());
                    i.putExtra("id",txtid.getText().toString());

                    itemView.getContext().startActivity(i);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder ab = new AlertDialog.Builder(itemView.getContext());
                    ab.setTitle("Borrar alumno");
                    ab.setMessage("¿Seguro que desea borrar el alumno " + txtNombre.getText().toString() + "?");
                    ab.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SQLiteDatabase myDB = itemView.getContext().openOrCreateDatabase(itemView.getContext().getResources().getString(R.string.db), itemView.getContext().MODE_PRIVATE, null);
                            myDB.execSQL("DELETE FROM alumno WHERE ID = " + txtid.getText().toString());
                            ((Activity)itemView.getContext()).recreate();
                        }
                    });
                    ab.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(itemView.getContext(), "Alumno no borrado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    ab.show();
                    return false;
                }
            });
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflador = LayoutInflater.from(parent.getContext());

        View v = inflador.inflate(R.layout.elemento,parent, false);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }


    //Esta funcion es para hacer cada elemento de la lista que hemos creado en MyViewHolder
    //y mostrarlo
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtid.setText("" + (lista.get(position).getId()));
        holder.txtNombre.setText(lista.get(position).getNombre());
        holder.txtGrupo.setText(lista.get(position).getGrupo());
        holder.textSexo.setText(lista.get(position).getSexo());
        holder.txtEdad.setText(lista.get(position).getEdad());
        holder.txtLinea.setText("-----------------------------------------------");
    }
    @Override
    public int getItemCount() {

        return lista.size();
    }
}
