package com.ness.petagram.presentador;

import android.content.Context;
import android.content.Intent;

import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.fragment.IPerfilFragment;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public class PerfilPresenter implements IPerfilPresenter {

    private IPerfilFragment     iPerfilFragment;
    private Context             context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    //Constructor
    public PerfilPresenter(IPerfilFragment iPerfilFragment, Context context){
        this.iPerfilFragment = iPerfilFragment;
        this.context         = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas            = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilFragment.inicializarAdaptador(iPerfilFragment.crearAdaptador(mascotas));
        iPerfilFragment.gridLayout();
    }
}
