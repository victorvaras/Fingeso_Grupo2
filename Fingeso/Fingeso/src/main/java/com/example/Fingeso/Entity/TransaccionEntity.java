package com.example.Fingeso.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Transaccion")
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Transaccion;
    private String usuario_Origen;
    private String usuario_Destino;

    @ManyToOne
    @JoinColumn(name= "rol", nullable = false)
    private PropiedadEntity rol;

    @ManyToOne
    @JoinColumn(name = "id_Boleta", nullable = false)
    private BoletaEntity id_Boleta;


    public TransaccionEntity(String usuario_Origen, String usuario_Destino, PropiedadEntity rol, BoletaEntity id_Boleta) {
        this.usuario_Origen = usuario_Origen;
        this.usuario_Destino = usuario_Destino;
        this.rol = rol;
        this.id_Boleta = id_Boleta;
    }

    public TransaccionEntity() {}

    public int getId_Transaccion() {
        return id_Transaccion;
    }

    public void setId_Transaccion(int id_Transaccion) {
        this.id_Transaccion = id_Transaccion;
    }

    public String getUsuario_Origen() {
        return usuario_Origen;
    }

    public void setUsuario_Origen(String usuario_Origen) {
        this.usuario_Origen = usuario_Origen;
    }

    public String getUsuario_Destino() {
        return usuario_Destino;
    }

    public void setUsuario_Destino(String usuario_Destino) {
        this.usuario_Destino = usuario_Destino;
    }

    public PropiedadEntity getRol() {
        return rol;
    }

    public void setRol(PropiedadEntity rol) {
        this.rol = rol;
    }

    public BoletaEntity getId_Boleta() {
        return id_Boleta;
    }

    public void setId_Boleta(BoletaEntity id_Boleta) {
        this.id_Boleta = id_Boleta;
    }
}
