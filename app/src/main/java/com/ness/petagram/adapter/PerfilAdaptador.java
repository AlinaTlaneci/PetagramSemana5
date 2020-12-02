package com.ness.petagram.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ness.petagram.R;
import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;
import java.util.Arrays;


public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{
    ArrayList<Mascotas> mascotas;
    Activity activity;
    private String txtvVotos;
    private int[] contadorNuevo;

    public PerfilAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilAdaptador.PerfilViewHolder perfilViewHolder, final int position) {
        final Mascotas mascota = mascotas.get(position);

        perfilViewHolder.imgMascota.setImageResource(mascota.getImgMascota());
        perfilViewHolder.txtvVotos.setText(String.valueOf(mascota.getLikes()));

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        //private TextView txtvnombre;
        //private ImageButton imgbtnHueso;
        public TextView    txtvVotos;

        public PerfilViewHolder(@NonNull View itemView){
            super(itemView);

            imgMascota  = (ImageView)   itemView.findViewById(R.id.imgMascota);
            //txtvnombre  = (TextView)    itemView.findViewById(R.id.txtvNombre);
            //imgbtnHueso = (ImageButton) itemView.findViewById(R.id.imgbtnHueso);
            txtvVotos   = (TextView)    itemView.findViewById(R.id.textvVotos);

        }

    }

}
