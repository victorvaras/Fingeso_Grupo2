package com.example.Fingeso.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Propiedad")
public class PropiedadEntity {

    //Atributos
    @Id
    private int Rol;
    private String Tipo;
    private String Tamanio;
    private String Ubicacion;
    private int Precio;
    private String Imagenes;
    private int Valoracion;
    private String Contrato;

    public PropiedadEntity(int rol, String tipo, String tamanio, String ubicacion, int precio, String imagenes, int valoracion, String contrato) {
        Rol = rol;
        Tipo = tipo;
        Tamanio = tamanio;
        Ubicacion = ubicacion;
        Precio = precio;
        Imagenes = imagenes;
        Valoracion = valoracion;
        Contrato = contrato;
    }
    public PropiedadEntity() {}



    public int getRol() {
        return Rol;
    }

    public void setRol(int rol) {
        Rol = rol;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getTamanio() {
        return Tamanio;
    }

    public void setTamanio(String tamanio) {
        Tamanio = tamanio;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public String getImagenes() {
        return Imagenes;
    }

    public void setImagenes(String imagenes) {
        Imagenes = imagenes;
    }

    public int getValoracion() {
        return Valoracion;
    }

    public void setValoracion(int valoracion) {
        Valoracion = valoracion;
    }

    public String getContrato() {
        return Contrato;
    }

    public void setContrato(String contrato) {
        Contrato = contrato;
    }
}
