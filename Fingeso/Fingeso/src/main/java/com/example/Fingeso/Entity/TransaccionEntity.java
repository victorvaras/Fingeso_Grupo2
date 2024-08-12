package com.example.Fingeso.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaccion")
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransaccion;


    @ManyToOne
    @JoinColumn(name = "rut")
    private UsuarioEntity usuarioOrigen;


    @ManyToOne
    @JoinColumn(name= "rol")
    private PropiedadEntity propiedad;

    @ManyToOne
    @JoinColumn(name = "idBoleta")
    private BoletaEntity boleta;

    public TransaccionEntity(UsuarioEntity usuarioOrigen, PropiedadEntity propiedad, BoletaEntity boleta) {
        this.idTransaccion = idTransaccion;
        this.usuarioOrigen = usuarioOrigen;
        this.propiedad = propiedad;
        this.boleta = boleta;
    }

    public TransaccionEntity() {}

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public UsuarioEntity getUsuarioOrigen() {
        return usuarioOrigen;
    }

    public void setUsuarioOrigen(UsuarioEntity usuarioOrigen) {
        this.usuarioOrigen = usuarioOrigen;
    }

    public PropiedadEntity getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(PropiedadEntity propiedad) {
        this.propiedad = propiedad;
    }

    public BoletaEntity getBoleta() {
        return boleta;
    }

    public void setBoleta(BoletaEntity boleta) {
        this.boleta = boleta;
    }
}

/*
{
  "usuarioOrigen": "Usuario1",
  "usuarioDestino": "Usuario2",
  "propiedad": {
    "rol": 1
  },
  "boleta": {
    "idBoleta": 1
  }
}
 */
