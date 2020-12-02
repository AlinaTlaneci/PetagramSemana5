package com.ness.petagram.pojo;

import com.ness.petagram.adapter.FavoritosAdaptador;

import java.util.ArrayList;

public interface IFavoritos {

    public void generarLinearLayout();
    public FavoritosAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptador(FavoritosAdaptador adaptador);
}
