package com.ness.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.ness.petagram.R;
import com.ness.petagram.adapter.PagerAdapter;
import com.ness.petagram.fragment.HomeFragment;
import com.ness.petagram.fragment.PerfilFragment;
import com.ness.petagram.pojo.AcercaDeActivity;
import com.ness.petagram.pojo.ContactoActivity;
import com.ness.petagram.pojo.Favoritos;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar     toolbar;
    private TabLayout   tabLayout;
    private ViewPager   viewPager;


    ArrayList<Mascotas>  mascotas;
    private RecyclerView rvPetagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SE HA HECHO UNA NUECVA?????????
        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        toolbar     = findViewById(R.id.toolbar);
        tabLayout   = findViewById(R.id.tabLayout);
        viewPager   = findViewById(R.id.viewPager);

        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager(), agregarFragment()));

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home_foreground);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_perfil_foreground);


        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    //EMPIEZA MENÚ DE OPCIONES

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAcercaDe:
                Intent intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent intent2 = new Intent(this, ContactoActivity.class);
                startActivity(intent2);
                break;
            case R.id.mFavoritos:
                Toast.makeText(this, "(:", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Favoritos.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}