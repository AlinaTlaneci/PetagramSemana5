package com.ness.petagram.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ness.petagram.MainActivity;
import com.ness.petagram.R;
import com.ness.petagram.adapter.MascotaAdaptador;
import com.ness.petagram.adapter.PerfilAdaptador;
import com.ness.petagram.pojo.Mascotas;
import com.ness.petagram.presentador.IFavoritosPresenter;
import com.ness.petagram.presentador.IPerfilPresenter;
import com.ness.petagram.presentador.PerfilPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment  implements IPerfilFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Mascotas>         mascotas;
    private RecyclerView        rvFragmentPerfil;
    private IPerfilPresenter    presenter;
    private SwipeRefreshLayout  swipeRefreshLayout;

    public PerfilFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);


        rvFragmentPerfil = v.findViewById(R.id.rvFragmentPerfil);


        presenter = new PerfilPresenter(this, getContext());

        return v;
    }



/*
    private void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascotas>();

        mascotas.add(new Mascotas(R.drawable.matiflor, "Mati en su florecita"));
        mascotas.add(new Mascotas(R.drawable.matilindo, "Mati súper lindo" ));
        mascotas.add(new Mascotas(R.drawable.matibanado, "Mati bañadito"));
        mascotas.add(new Mascotas(R.drawable.matiacostado, "Mati con flojera"));
        mascotas.add(new Mascotas(R.drawable.maticoche, "Mati feliz"));
        mascotas.add(new Mascotas(R.drawable.matiasoleado, "Mati tomando el sol"));
        mascotas.add(new Mascotas(R.drawable.maticaricias, "Mati pidiendo caricias"));
        mascotas.add(new Mascotas(R.drawable.maticomida, "Mati pidiendo comida"));
        mascotas.add(new Mascotas(R.drawable.matiperfil, "Mati con chalequito"));
        mascotas.add(new Mascotas(R.drawable.matitrono, "Mati en su trono"));


    }
*/

    @Override
    public void gridLayout() {
        rvFragmentPerfil.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }

    @Override
    public PerfilAdaptador crearAdaptador(ArrayList<Mascotas> mascotas) {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(PerfilAdaptador adaptador) {
        rvFragmentPerfil.setAdapter(adaptador);
    }


}