package com.ness.petagram.fragment;

import com.ness.petagram.adapter.MascotaAdaptador;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public interface IHomeFragment {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas);
    public void inicializarAdaptador(MascotaAdaptador adaptador);
}
