package com.ness.petagram.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.fragment.HomeFragment;
import com.ness.petagram.pojo.Mascotas;
import com.ness.petagram.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascotas> mascotas;
    Activity            activity;



    public MascotaAdaptador(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petagram, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascotas mascota = mascotas.get(position);
        final ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);

        mascotaViewHolder.imgMascota.setImageResource(mascota.getImgMascota());
        mascotaViewHolder.txtvnombre.setText(mascota.getNombre());
        mascotaViewHolder.txtvVotos.setText(String.valueOf(mascota.getLikes()));


        mascotaViewHolder.imgbtnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Votaste por " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.txtvVotos.setText(String.valueOf(constructorMascotas.obtenerLikeMascota(mascota)));
            }
        });


    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView   imgMascota;
        private TextView    txtvnombre;
        private ImageButton imgbtnHueso;
        private TextView    txtvVotos;

        public MascotaViewHolder(@NonNull View itemView){
            super(itemView);

            imgMascota  = (ImageView)   itemView.findViewById(R.id.imgMascota);
            txtvnombre  = (TextView)    itemView.findViewById(R.id.txtvNombre);
            imgbtnHueso = (ImageButton) itemView.findViewById(R.id.imgbtnHueso);
            txtvVotos   = (TextView)    itemView.findViewById(R.id.textvVotos);

        }
    }
}
