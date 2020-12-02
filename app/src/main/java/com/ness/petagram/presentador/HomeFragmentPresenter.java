package com.ness.petagram.presentador;

import android.content.Context;

import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.fragment.IHomeFragment;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {
    private IHomeFragment       iHomeFragment;
    private Context             context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;



    //constructor
    public HomeFragmentPresenter(IHomeFragment iHomeFragment, Context context){
        this.iHomeFragment  = iHomeFragment;
        this.context        = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas            = constructorMascotas.obtenerDatos();
        mostrarMascotasRecyclerView();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iHomeFragment.inicializarAdaptador(iHomeFragment.crearAdaptador(mascotas));
        iHomeFragment.generarLinearLayoutVertical();
    }
}
