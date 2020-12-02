package com.ness.petagram.presentador;

import android.content.Context;

import com.ness.petagram.adapter.FavoritosAdaptador;
import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.pojo.IFavoritos;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public class FavoritosPresenter implements IFavoritosPresenter{
    private IFavoritos iFavoritos;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    //Constructor
    public FavoritosPresenter (IFavoritos iFavoritos, Context context){
        this.iFavoritos = iFavoritos;
        this.context    = context;
        obtenerMascotasFavoritasBaseDatos();
    }

    @Override
    public void obtenerMascotasFavoritasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas            = constructorMascotas.obtenerDatosFavoritos();
        mostrarMascotasFavoritasRV();
    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iFavoritos.inicializarAdaptador(iFavoritos.crearAdaptador(mascotas));
        iFavoritos.generarLinearLayout();
    }
}
