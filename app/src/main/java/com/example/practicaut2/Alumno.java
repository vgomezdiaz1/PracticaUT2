package com.example.practicaut2;

public class Alumno {
    int id;
    String nombre;
    String grupo;
    String sexo;
    String edad;
    double flexibilidad1;
    double flexibilidad3;
    double fuerza1;
    double fuerza3;
    double velocidad1;
    double velocidad3;
    double resistencia1;
    double resistencia3;

    public Alumno(int id, String nombre, String grupo, String sexo, String edad, double flexibilidad1, double flexibilidad3, double fuerza1, double fuerza3, double velocidad1, double velocidad3, double resistencia1, double resistencia3) {
        this.id = id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.sexo = sexo;
        this.edad = edad;
        this.flexibilidad1 = flexibilidad1;
        this.flexibilidad3 = flexibilidad3;
        this.fuerza1 = fuerza1;
        this.fuerza3 = fuerza3;
        this.velocidad1 = velocidad1;
        this.velocidad3 = velocidad3;
        this.resistencia1 = resistencia1;
        this.resistencia3 = resistencia3;
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

    public double getFlexibilidad1() {
        return flexibilidad1;
    }

    public void setFlexibilidad1(double flexibilidad1) {
        this.flexibilidad1 = flexibilidad1;
    }

    public double getFuerza1() {
        return fuerza1;
    }

    public void setFuerza1(double fuerza1) {
        this.fuerza1 = fuerza1;
    }

    public double getVelocidad1() {
        return velocidad1;
    }

    public void setVelocidad1(double velocidad1) {
        this.velocidad1 = velocidad1;
    }

    public double getResistencia1() {
        return resistencia1;
    }

    public void setResistencia1(double resistencia1) {
        this.resistencia1 = resistencia1;
    }

    public double getFlexibilidad3() {
        return flexibilidad3;
    }

    public void setFlexibilidad3(double flexibilidad3) {
        this.flexibilidad3 = flexibilidad3;
    }

    public double getFuerza3() {
        return fuerza3;
    }

    public void setFuerza3(double fuerza3) {
        this.fuerza3 = fuerza3;
    }

    public double getVelocidad3() {
        return velocidad3;
    }

    public void setVelocidad3(double velocidad3) {
        this.velocidad3 = velocidad3;
    }

    public double getResistencia3() {
        return resistencia3;
    }

    public void setResistencia3(double resistencia3) {
        this.resistencia3 = resistencia3;
    }
}
