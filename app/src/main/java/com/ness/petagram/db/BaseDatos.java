package com.ness.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ness.petagram.pojo.Mascotas;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    //Constructor
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se crea la estructura de las tablas de la base de datos
        //Donde realmente se crea es cuando se crea un objeto  y crea una bd con este meto
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT " +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID              + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA      + " INTEGER, "  +
                ConstantesBaseDatos.TABLE_LIKES_FOTO            + " TEXT, "     +
                ConstantesBaseDatos.TABLE_LIKES_NOMBRE          + " INTEGER, "  +
                ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES    + " INTEGER, "  +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + "), " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_FOTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + "), " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_NOMBRE + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerTodasMascotas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String          query   = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase  db      = this.getWritableDatabase();
        Cursor registros        = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setImgMascota(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") as likes " +
                    " FROM "  + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +  mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes,null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }
            
            mascotas.add(mascotaActual);
            registrosLikes.close();
        }

        db.close();

        return mascotas;
    }



    public ArrayList<Mascotas> obtenerMascotasFavoritas(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String          query   = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " limit 0,5";
        SQLiteDatabase  db      = this.getWritableDatabase();
        Cursor registros        = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascotas mascotaActual = new Mascotas();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setImgMascota(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            /*String queryLikes   = "SELECT " + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + " AS no_likes"  + ", COUNT(" + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + ") AS id " +
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " JOIN " + ConstantesBaseDatos.TABLE_LIKES + " ON " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " = " + mascotaActual.getId() +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +  mascotaActual.getId() +
                    " GROUP BY no_likes"  +
                    " ORDER BY COUNT(*) DESC";



            String queryLikes   = "SELECT " + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES  + ", COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") AS cnt " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +  mascotaActual.getId() +
                    " GROUP BY " + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES +
                    " ORDER BY cnt DESC";

             */

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") as likes " +
                    " FROM "  + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +  mascotaActual.getId();



            Cursor registrosLikes = db.rawQuery(queryLikes,null);

            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
            registrosLikes.close();
        }

        db.close();

        return mascotas;
    }


/*
    public ArrayList<Mascotas> obtenerFavoritosMascotas(){
        ArrayList<Mascotas> mascotasFavoritas = new ArrayList<>();

        String          query       = "SELECT * FROM " + ConstantesBaseDatos.TABLE_LIKES + " NATURAL JOIN " + ConstantesBaseDatos.TABLE_MASCOTAS + " ORDER BY " +
                                        ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + " ASC" + " limit 0,5";
        SQLiteDatabase  db          = this.getWritableDatabase();
        Cursor          registroFav = db.rawQuery(query,null);

        while (registroFav.moveToNext()){
            Mascotas mascotaFavoritaActual = new Mascotas();
            mascotaFavoritaActual.setId(registroFav.getInt(0));
            //mascotaFavoritaActual.setId(registroFav.getInt(1));
            mascotaFavoritaActual.setImgMascota(registroFav.getInt(2));
            mascotaFavoritaActual.setNombre(registroFav.getString(3));
            mascotaFavoritaActual.setLikes(registroFav.getInt(4));


            //////String queryNombre = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NOMBRE + ") " +
                    " FROM "  + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +  mascotaFavoritaActual.getId();

            Cursor registrosFavNombre = db.rawQuery(queryNombre,null);
            if (registrosFavNombre.moveToNext()){
                mascotaFavoritaActual.setNombre(registrosFavNombre.getString(0));
            }else{
                mascotaFavoritaActual.setNombre("");
            }

             /////


            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") as likes " +
                    " FROM "  + ConstantesBaseDatos.TABLE_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +  mascotaFavoritaActual.getId();

            Cursor registrosFavLikes = db.rawQuery(queryLikes,null);

            if (registrosFavLikes.moveToNext()){
                mascotaFavoritaActual.setLikes(registrosFavLikes.getInt(0));
            }else {
                mascotaFavoritaActual.setLikes(0);
            }

            mascotasFavoritas.add(mascotaFavoritaActual);

        }

        db.close();
        return mascotasFavoritas;
    }

 */

///////////////////////////

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null,contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES,null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascotas mascotas){
        int likes = 0;

        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES + ") " +
                " FROM "  + ConstantesBaseDatos.TABLE_LIKES +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" + mascotas.getId();

        SQLiteDatabase  db        = this.getWritableDatabase();
        Cursor          registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
