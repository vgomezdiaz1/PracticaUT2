package com.example.practicaut2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptadorListadoAlumnosCompleto extends RecyclerView.Adapter<MiAdaptadorListadoAlumnosCompleto.MyViewHolder> {

    ArrayList<Alumno> lista;

    public MiAdaptadorListadoAlumnosCompleto(ArrayList<Alumno> lista) {
        this.lista = lista;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtid, txtNombre, txtFlex1, txtFlex3, txtF1,txtF3, txtV1,txtV3,txtRes1,txtRes3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.txtIDNotasCompleto);
            txtNombre = itemView.findViewById(R.id.txtNombreAlumno);
            txtFlex1 = itemView.findViewById(R.id.txtFlex1);
            txtFlex3 = itemView.findViewById(R.id.txtFlex3);
            txtF1 = itemView.findViewById(R.id.txtFu1);
            txtF3 = itemView.findViewById(R.id.txtFu3);
            txtV1 = itemView.findViewById(R.id.txtVel1);
            txtV3 = itemView.findViewById(R.id.txtVel3);
            txtRes1 = itemView.findViewById(R.id.txtResistencia1);
            txtRes3 = itemView.findViewById(R.id.txtResistencia3);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder ab = new AlertDialog.Builder(itemView.getContext());
                    ab.setTitle("Seleccionar Trimestre a modificar");
                    ab.setPositiveButton("1ºTri.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(itemView.getContext(), IntroduccionDatosCarrerasActivity.class);
                            intent.putExtra("id",txtid.getText().toString());
                            intent.putExtra("nombre",txtNombre.getText().toString());
                            intent.putExtra("Flex",txtF1.getText().toString());
                            intent.putExtra("Fuerza",txtF1.getText().toString());
                            intent.putExtra("Vel",txtV1.getText().toString());
                            intent.putExtra("Res",txtRes1.getText().toString());
                            itemView.getContext().startActivity(intent);
                        }
                    });
                    ab.setNegativeButton("3ºTri.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(itemView.getContext(), IntroduccionDatosCarrerasActivity.class);
                            intent.putExtra("id",txtid.getText().toString());
                            intent.putExtra("nombre",txtNombre.getText().toString());
                            intent.putExtra("Flex",txtF3.getText().toString());
                            intent.putExtra("Fuerza",txtF3.getText().toString());
                            intent.putExtra("Vel",txtV3.getText().toString());
                            intent.putExtra("Res",txtRes3.getText().toString());
                            itemView.getContext().startActivity(intent);
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

        View v = inflador.inflate(R.layout.elemento_vista_alumnos_notas,parent, false);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtid.setText("" + (lista.get(position).getId()));
        holder.txtNombre.setText(lista.get(position).getNombre());
        holder.txtFlex1.setText("" +lista.get(position).getFlexibilidad1());
        holder.txtFlex3.setText("" +lista.get(position).getFlexibilidad3());
        holder.txtF1.setText("" +lista.get(position).getFuerza1());
        holder.txtF3.setText("" +lista.get(position).getFuerza3());
        holder.txtV1.setText("" +lista.get(position).getVelocidad1());
        holder.txtV3.setText("" +lista.get(position).getVelocidad3());
        holder.txtRes1.setText("" +lista.get(position).getResistencia1());
        holder.txtRes3.setText("" +lista.get(position).getResistencia3());
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
