package com.example.pruebasfirebase;

import android.os.Parcel;
import android.os.Parcelable;

public class CEmpleado implements Parcelable{

    String nombre;
    String dni;
    String profesion;

    public CEmpleado(String nombre, String dni, String profesion) {
        this.nombre = nombre;
        this.dni = dni;
        this.profesion = profesion;
    }

    public CEmpleado() {
    }

    protected CEmpleado(Parcel p) {
        readFromParcel(p);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(dni);
        dest.writeString(profesion);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CEmpleado> CREATOR = new Creator<CEmpleado>() {
        @Override
        public CEmpleado createFromParcel(Parcel in) {
            return new CEmpleado(in);
        }

        @Override
        public CEmpleado[] newArray(int size) {
            return new CEmpleado[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    private void readFromParcel (Parcel p) {

        this.nombre = p.readString();
        this.dni = p.readString();
        this.profesion = p.readString();

    }



}