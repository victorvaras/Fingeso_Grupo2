package com.example.Fingeso.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Boleta")
public class BoletaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Boleta;
    private int monto;
    private Date fecha;
    private String medio_Pasarela;


    public BoletaEntity(int monto, Date fecha, String medio_Pasarela) {
        this.id_Boleta = id_Boleta;
        this.monto = monto;
        this.fecha = fecha;
        this.medio_Pasarela = medio_Pasarela;
    }
    public BoletaEntity() {}


    public int getId_Boleta() {
        return id_Boleta;
    }

    public void setId_Boleta(int id_Boleta) {
        this.id_Boleta = id_Boleta;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMedio_Pasarela() {
        return medio_Pasarela;
    }

    public void setMedio_Pasarela(String medio_Pasarela) {
        this.medio_Pasarela = medio_Pasarela;
    }
}
