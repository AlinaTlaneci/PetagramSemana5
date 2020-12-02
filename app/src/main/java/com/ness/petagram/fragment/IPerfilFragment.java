package com.ness.petagram.fragment;

import com.ness.petagram.adapter.PerfilAdaptador;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public interface IPerfilFragment {

    public void gridLayout();
    public PerfilAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptador(PerfilAdaptador adaptador);


}
