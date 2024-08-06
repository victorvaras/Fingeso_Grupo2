package com.example.Fingeso.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Propiedad")
public class PropiedadEntity {

    //Atributos
    @Id
    private int rol;
    private String tipo;
    private String tamano;
    private String ubicacion;
    private int precio;
    private String imagenes;
    private int valoracion;
    private String contrato;

    public PropiedadEntity(int rol, String tipo, String tamanio, String ubicacion, int precio, String imagenes, int valoracion, String contrato) {
        this.rol = rol;
        this.tipo = tipo;
        this.tamano = tamanio;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.imagenes = imagenes;
        this.valoracion = valoracion;
        this.contrato = contrato;
    }
    public PropiedadEntity() {}



    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
}
