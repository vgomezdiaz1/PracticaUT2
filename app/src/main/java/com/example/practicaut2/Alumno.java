package com.example.practicaut2;

public class Alumno {
    int id;
    String nombre;
    String grupo;
    String sexo;
    String edad;
    NotasCarreras nc;

    public Alumno(int id, String nombre, String grupo, String sexo, String edad) {
        this.id =id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.sexo = sexo;
        this.edad = edad;
        this.nc = null;
    }
    public Alumno(int id, String nombre, String grupo, String sexo, String edad, NotasCarreras nc) {
        this.id =id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.sexo = sexo;
        this.edad = edad;
        this.nc = nc;
    }
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public NotasCarreras getNc() {
        return nc;
    }

    public void setNc(NotasCarreras nc) {
        this.nc = nc;
    }
}
