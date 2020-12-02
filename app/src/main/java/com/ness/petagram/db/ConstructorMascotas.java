package com.ness.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.ness.petagram.R;
import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascotas> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarVariasMascotas(db);
        return db.obtenerTodasMascotas();
    }

    public void insertarVariasMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matiflor);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati en su florecita");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matilindo);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati súper lindo");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matibanado);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati bañadito");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matiacostado);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati con flojera");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.maticoche);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati feliz");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matiasoleado);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati tomando el sol");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.maticaricias);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati pidiendo caricias");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.maticomida);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati pidiendo comida");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matiperfil);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati con chalequito");
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.matitrono);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mati en su trono");
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascotas mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES, LIKE );

        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikeMascota(Mascotas mascota){
        BaseDatos   db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public ArrayList<Mascotas> obtenerDatosFavoritos(){
        BaseDatos db = new BaseDatos(context);
        insertarVariasMascotas(db);
        return db.obtenerMascotasFavoritas();
    }

/*
    public ArrayList<Mascotas> obtenerDatosFavoritos(){
        BaseDatos db = new BaseDatos(context);
        //insertarVariasMascotas(db);
        return db.obtenerFavoritosMascotas();
    }

*/

}
