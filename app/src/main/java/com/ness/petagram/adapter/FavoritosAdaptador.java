package com.ness.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ness.petagram.MainActivity;
import com.ness.petagram.R;
import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.pojo.Favoritos;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;
import java.util.Arrays;

public class FavoritosAdaptador extends RecyclerView.Adapter<FavoritosAdaptador.FavoritosViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity            activity;

    public FavoritosAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public FavoritosAdaptador.FavoritosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petagram, parent, false);
        return new FavoritosAdaptador.FavoritosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavoritosAdaptador.FavoritosViewHolder favoritosViewHolder, final int position) {
        final Mascotas mascota = mascotas.get(position);

        favoritosViewHolder.imgMascota.setImageResource(mascota.getImgMascota());
        favoritosViewHolder.txtvnombre.setText(mascota.getNombre());
        favoritosViewHolder.txtvVotos.setText((String.valueOf(mascota.getLikes())));

    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class FavoritosViewHolder extends RecyclerView.ViewHolder{
        private ImageView   imgMascota;
        private TextView    txtvnombre;
        private ImageButton imgbtnHueso;
        public  TextView    txtvVotos;

        public FavoritosViewHolder(@NonNull View itemView){
            super(itemView);

            imgMascota  = (ImageView)   itemView.findViewById(R.id.imgMascota);
            txtvnombre  = (TextView)    itemView.findViewById(R.id.txtvNombre);
            imgbtnHueso = (ImageButton) itemView.findViewById(R.id.imgbtnHueso);
            txtvVotos   = (TextView)    itemView.findViewById(R.id.textvVotos);

        }

    }

}
