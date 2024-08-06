package com.example.Fingeso.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipo_Transaccion")
public class Tipo_TransaccionEntity {

    @Id
    private int id_Tipo_usuario;
    private String tipo_Transaccion;

    public Tipo_TransaccionEntity(int id_Tipo_usuario, String tipo_Transaccion) {
        this.id_Tipo_usuario = id_Tipo_usuario;
        this.tipo_Transaccion = tipo_Transaccion;
    }

    public Tipo_TransaccionEntity() {}


    public int getId_Tipo_usuario() {
        return id_Tipo_usuario;
    }

    public void setId_Tipo_usuario(int id_Tipo_usuario) {
        this.id_Tipo_usuario = id_Tipo_usuario;
    }

    public String getTipo_Transaccion() {
        return tipo_Transaccion;
    }

    public void setTipo_Transaccion(String tipo_Transaccion) {
        this.tipo_Transaccion = tipo_Transaccion;
    }
}
