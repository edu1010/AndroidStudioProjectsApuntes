package com.example.edu10.pruebafirebase;

public class Usuarios {
    private String nombre;
    private int Edad;

    public Usuarios() {
    }

    public Usuarios(String nombre, int edad) {
        this.nombre = nombre;
        Edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
