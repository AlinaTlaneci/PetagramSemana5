package com.ness.petagram.pojo;

public class Mascotas {
    private int    id;
    private String nombre;
    private int    imgMascota;
    private int    txtvVotos;
    private int    likes;

    public Mascotas (){
    }

    public Mascotas(int imgMascota, String nombre){
        this.imgMascota = imgMascota;
        this.nombre     = nombre;
    }
    
    public Mascotas(int imgMascota, String nombre, int txtvVotos){
        this.imgMascota = imgMascota;
        this.nombre     = nombre;
        this.txtvVotos  = txtvVotos;
    }

    public Mascotas(int id, int imgMascota, String nombre, int txtvVotos){
        this.id         = id;
        this.imgMascota = imgMascota;
        this.nombre     = nombre;
        this.txtvVotos  = txtvVotos;
    }

    public Mascotas(int id, int imgMascota, String nombre, int txtvVotos, int likes){
        this.id         = id;
        this.imgMascota = imgMascota;
        this.nombre     = nombre;
        this.txtvVotos  = txtvVotos;
        this.likes      = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImgMascota() {
        return imgMascota;
    }

    public void setImgMascota(int imgMascota) {
        this.imgMascota = imgMascota;
    }
    public int getTxtvVotos() {
        return txtvVotos;
    }

    public void setTxtvVotos(int txtvVotos) {
        this.txtvVotos = txtvVotos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}
