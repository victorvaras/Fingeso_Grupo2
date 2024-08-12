package com.example.Fingeso.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Boleta")
public class BoletaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoleta;
    private int monto;
    private Date fecha;
    private String medio_Pasarela;


    public BoletaEntity(int monto, Date fecha, String medio_Pasarela) {
        this.idBoleta = idBoleta;
        this.monto = monto;
        this.fecha = fecha;
        this.medio_Pasarela = medio_Pasarela;
    }
    public BoletaEntity() {}


    public int getIdBoleta() {
        return idBoleta;
    }

    public void setIdBoleta(int id_Boleta) {
        this.idBoleta = id_Boleta;
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


/*
{
  "monto": 3000,
  "fecha": "2024-08-05T12:34:56",
  "medio_Pasarela": "Debito"
}
 */
