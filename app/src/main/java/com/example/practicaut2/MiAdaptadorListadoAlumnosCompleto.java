package com.example.practicaut2;

import static com.example.practicaut2.R.color.green;
import static com.example.practicaut2.R.color.red;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptadorListadoAlumnosCompleto extends RecyclerView.Adapter<MiAdaptadorListadoAlumnosCompleto.MyViewHolder> {

    ArrayList<Alumno> lista;

    public MiAdaptadorListadoAlumnosCompleto(ArrayList<Alumno> lista) {
        this.lista = lista;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtid, txtNombre, txtGrupo, txtSexo, txtEdad, txtFlex1, txtFlex3, txtF1,txtF3, txtV1,txtV3,txtRes1,txtRes3, txtFlexTotal,txtFuTotal, txtVelTotal, txtResistenciaTotal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.txtIDNotasCompleto);
            txtNombre = itemView.findViewById(R.id.txtNombreAlumno);
            txtGrupo = itemView.findViewById(R.id.txtGrupoAlumno);
            txtSexo = itemView.findViewById(R.id.txtSexoAlumno);
            txtEdad = itemView.findViewById(R.id.txtNotas);
            txtFlex1 = itemView.findViewById(R.id.txtFlex1);
            txtFlex3 = itemView.findViewById(R.id.txtFlex3);
            txtF1 = itemView.findViewById(R.id.txtFu1);
            txtF3 = itemView.findViewById(R.id.txtFu3);
            txtV1 = itemView.findViewById(R.id.txtVel1);
            txtV3 = itemView.findViewById(R.id.txtVel3);
            txtRes1 = itemView.findViewById(R.id.txtResistencia1);
            txtRes3 = itemView.findViewById(R.id.txtResistencia3);
            txtFlexTotal = itemView.findViewById(R.id.txtFlexTotal);
            txtFuTotal = itemView.findViewById(R.id.txtFuTotal);
            txtVelTotal = itemView.findViewById(R.id.txtVelTotal);
            txtResistenciaTotal = itemView.findViewById(R.id.txtResistenciaTotal);

            Button btnPrimer = itemView.findViewById(R.id.btnPrimerTrimestre);
            btnPrimer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(itemView.getContext(), IntroduccionDatosCarrerasActivity.class);
                    i.putExtra("trimestre", "1ºTRIMESTRE");
                    i.putExtra("id",txtid.getText().toString());
                    i.putExtra("nombre",txtNombre.getText().toString());
                    i.putExtra("Flex",txtF1.getText().toString());
                    i.putExtra("Fuerza",txtF1.getText().toString());
                    i.putExtra("Vel",txtV1.getText().toString());
                    i.putExtra("Res",txtRes1.getText().toString());
                    itemView.getContext().startActivity(i);
                }
            });
            Button btnTercer = itemView.findViewById(R.id.btnTercerTrimestre);
            btnTercer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(itemView.getContext(), IntroduccionDatosCarrerasActivity.class);
                    i.putExtra("trimestre", "3ºTRIMESTRE");
                    i.putExtra("id",txtid.getText().toString());
                    i.putExtra("nombre",txtNombre.getText().toString());
                    i.putExtra("Flex",txtF3.getText().toString());
                    i.putExtra("Fuerza",txtF3.getText().toString());
                    i.putExtra("Vel",txtV3.getText().toString());
                    i.putExtra("Res",txtRes3.getText().toString());
                    itemView.getContext().startActivity(i);
                }
            });

            Button btnModificar = itemView.findViewById(R.id.btnModificarAlumno);
            btnModificar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(itemView.getContext(), IntroduccionDatosAlumnoActivity.class);
                    i.putExtra("id",txtid.getText().toString());
                    i.putExtra("nombre",txtNombre.getText().toString());
                    i.putExtra("grupo", txtGrupo.getText().toString());
                    i.putExtra("sexo", txtSexo.getText().toString());
                    i.putExtra("edad", txtEdad.getText().toString());
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

        View v = inflador.inflate(R.layout.elemento_vista_alumnos_notas,parent, false);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtid.setText("" + (lista.get(position).getId()));
        holder.txtEdad.setText("" + (lista.get(position).getEdad()));
        holder.txtNombre.setText(lista.get(position).getNombre());
        holder.txtGrupo.setText(lista.get(position).getGrupo());
        holder.txtSexo.setText(lista.get(position).getSexo());
        if(lista.get(position).getFlexibilidad1()==-1){
            holder.txtFlex1.setText("ND");
        }else{
            holder.txtFlex1.setText("" +lista.get(position).getFlexibilidad1() + " cm");
        }
        if(lista.get(position).getFlexibilidad3()==-1){
            holder.txtFlex3.setText("ND");
        }else{
            holder.txtFlex3.setText("" +lista.get(position).getFlexibilidad3() + " cm");
        }
        if(lista.get(position).getFlexibilidad1()==-1 || lista.get(position).getFlexibilidad3()==-1){
            holder.txtFlexTotal.setText("ND");
        }else{
            holder.txtFlexTotal.setText("" + (lista.get(position).getFlexibilidad3() - lista.get(position).getFlexibilidad1()) + " cm");
            if((lista.get(position).getFlexibilidad3() - lista.get(position).getFlexibilidad1())<=0){
                holder.txtFlexTotal.setBackgroundResource(red);
            }else{
                holder.txtFlexTotal.setBackgroundResource(green);
            }
        }

        if(lista.get(position).getFuerza1()==-1){
            holder.txtF1.setText("ND");
        }else{
            holder.txtF1.setText("" +lista.get(position).getFuerza1() + " m");
        }
        if(lista.get(position).getFuerza3()==-1){
            holder.txtF3.setText("ND");
        }else{
            holder.txtF3.setText("" +lista.get(position).getFuerza3() + " m");
        }
        if(lista.get(position).getFuerza1()==-1 || lista.get(position).getFuerza3()==-1){
            holder.txtFuTotal.setText("ND");
        }else{
            holder.txtFuTotal.setText("" + (lista.get(position).getFuerza3() - lista.get(position).getFuerza1()) + " m");
            if((lista.get(position).getFuerza3() - lista.get(position).getFuerza1())<=0){
                holder.txtFuTotal.setBackgroundResource(red);
            }else{
                holder.txtFuTotal.setBackgroundResource(green);
            }
        }

        if(lista.get(position).getVelocidad1()==-1){
            holder.txtV1.setText("ND");
        }else {
            holder.txtV1.setText("" + lista.get(position).getVelocidad1() + " s");
        }
        if(lista.get(position).getVelocidad3()==-1){
            holder.txtV3.setText("ND");
        }else{
            holder.txtV3.setText("" +lista.get(position).getVelocidad3() + " s");
        }
        if(lista.get(position).getVelocidad1()==-1 || lista.get(position).getVelocidad3()==-1){
            holder.txtVelTotal.setText("ND");
        }else{
            holder.txtVelTotal.setText("" + (lista.get(position).getVelocidad3() - lista.get(position).getVelocidad1()) + " s");
            if((lista.get(position).getVelocidad3() - lista.get(position).getVelocidad1())<=0){
                holder.txtVelTotal.setBackgroundResource(red);
            }else{
                holder.txtVelTotal.setBackgroundResource(green);
            }
        }

        if(lista.get(position).getResistencia1()==-1){
            holder.txtRes1.setText("ND");
        }else{
            holder.txtRes1.setText("" +lista.get(position).getResistencia1() + " m");
        }
        if(lista.get(position).getResistencia3()==-1){
            holder.txtRes3.setText("ND");
        }else{
            holder.txtRes3.setText("" +lista.get(position).getResistencia3() + " m");
        }
        if(lista.get(position).getResistencia1()==-1 || lista.get(position).getResistencia3()==-1){
            holder.txtResistenciaTotal.setText("ND");
        }else{
            holder.txtResistenciaTotal.setText("" + (lista.get(position).getResistencia3() - lista.get(position).getResistencia1()) + " m");
            if((lista.get(position).getResistencia3() - lista.get(position).getResistencia1())<=0){
                holder.txtResistenciaTotal.setBackgroundResource(red);
            }else{
                holder.txtResistenciaTotal.setBackgroundResource(green);
            }
        }
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }
}
