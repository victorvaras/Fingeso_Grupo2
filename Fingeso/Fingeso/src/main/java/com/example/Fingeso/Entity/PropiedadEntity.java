package com.example.Fingeso.Entity;

import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "rut")
    private UsuarioEntity propietario;

    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado_PropiedadEntity estadoPropiedad;


    public PropiedadEntity(int rol, String tipo, String tamano, String ubicacion, int precio, String imagenes, int valoracion, String contrato, UsuarioEntity propietario, Estado_PropiedadEntity estadoPropiedad) {
        this.rol = rol;
        this.tipo = tipo;
        this.tamano = tamano;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.imagenes = imagenes;
        this.valoracion = valoracion;
        this.contrato = contrato;
        this.propietario = propietario;
        this.estadoPropiedad = estadoPropiedad;
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

    public UsuarioEntity getPropietario() {
        return propietario;
    }

    public void setPropietario(UsuarioEntity propietario) {
        this.propietario = propietario;
    }

    public Estado_PropiedadEntity getEstadoPropiedad() {
        return estadoPropiedad;
    }

    public void setEstadoPropiedad(Estado_PropiedadEntity estadoPropiedad) {
        this.estadoPropiedad = estadoPropiedad;
    }
}

/*
{
  "rol": 1,
  "tipo": "residencial",
  "tamano": "100m2",
  "ubicacion": "Centro",
  "precio": 500000,
  "imagenes": "imagen.jpg",
  "valoracion": 4,
  "contrato": "alquiler.dox",
  "propietario": {
        rut: "10"},



}
 @ManyToOne
    @JoinColumn(name = "rut")
    private UsuarioEntity propietario;

    @ManyToOne
    @JoinColumn(name = "idEstado")
    private Estado_PropiedadEntity estadoPropiedad;
 */