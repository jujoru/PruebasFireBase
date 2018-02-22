package com.example.pruebasfirebase;

/**
 * Created by Nino Ruano on 21/02/2018.
 */

public class CJugador {

    String nombre;
    int dorsal;


    String posicion;
    double sueldo;

    public CJugador() {
        //Es obligatorio incluir constructor por defecto
    }
    public CJugador(int dorsal,String nombre,  String posicion, double sueldo) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    @Override
    public String toString() {
        return "CJugador{" +
                "nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", posicion='" + posicion + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
