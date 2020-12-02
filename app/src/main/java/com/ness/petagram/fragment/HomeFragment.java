package com.ness.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ness.petagram.db.ConstructorMascotas;
import com.ness.petagram.pojo.Mascotas;
import com.ness.petagram.R;
import com.ness.petagram.adapter.MascotaAdaptador;
import com.ness.petagram.presentador.HomeFragmentPresenter;
import com.ness.petagram.presentador.IHomeFragmentPresenter;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IHomeFragment {
    ArrayList<Mascotas> mascotas;
    private RecyclerView rvPetagram;
    private IHomeFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        rvPetagram = v.findViewById(R.id.rvPetagram);

        presenter = new HomeFragmentPresenter(this, getContext());

        return v;
    }



    @Override
    public void generarLinearLayoutVertical(){
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetagram.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascotas> mascotas){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        rvPetagram.setAdapter(adaptador);
    }


}
