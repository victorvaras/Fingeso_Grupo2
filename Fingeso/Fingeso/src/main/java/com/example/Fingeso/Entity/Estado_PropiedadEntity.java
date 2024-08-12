package com.example.Fingeso.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Estado_PropiedadEntity {

    @Id
    private int idEstado;
    private String estado;

    public Estado_PropiedadEntity(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }
    public Estado_PropiedadEntity() {}

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
