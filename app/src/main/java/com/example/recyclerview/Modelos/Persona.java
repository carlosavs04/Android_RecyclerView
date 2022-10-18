package com.example.recyclerview.Modelos;

public class Persona {
    private String Nombre;
    private String Telefono;

    public Persona(String nombre, String telefono) {
        Nombre = nombre;
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
