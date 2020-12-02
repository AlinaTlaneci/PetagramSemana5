package com.ness.petagram.db;

public class ConstantesBaseDatos {

    public static final String  DATABASE_NAME       = "Mascotas";
    public static final int     DATABASE_VERSION    = 1;

    public static final String  TABLE_MASCOTAS          = "mascota";
    public static final String  TABLE_MASCOTAS_ID       = "id";
    public static final String  TABLE_MASCOTAS_FOTO     = "foto";
    public static final String  TABLE_MASCOTAS_NOMBRE   = "nombre";

    public static final String  TABLE_LIKES     = "mascota_likes";
    public static final String  TABLE_LIKES_ID  = "id";
    public static final String  TABLE_LIKES_ID_MASCOTA      = "id_mascota";
    public static final String  TABLE_LIKES_NUMERO_LIKES    = "numero_likes";
    public static final String TABLE_LIKES_NOMBRE           = "nombre_likes";
    public static final String TABLE_LIKES_FOTO             = "foto_likes";
    public static final String TABLE_MASCOTAS_LIKES = "likes_tal_vez ";
}
