package com.example.Fingeso.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Usuario")
public class UsuarioEntity {
    //quizá no sea necesario el @Id
    @Id
    private String rut;
    private String nombreApellidos;
    private String correo;
    private String contrasena;
    private String nombreAgencia;
    private String documentacionOperacion;
    private int valoracion;
    private int cuotasArriendo;
    //fk tipo usuario
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuarioEntity tipoUsuario;


   /** public UsuarioEntity(String rut, String nombreApellidos, String correo, String contrasena, String nombreAgencia, String documentacionOperacion, int valoracion, int cuotasArriendo, TipoUsuarioEntity tipoUsuario) {
        this.rut = rut;
        this.nombreApellidos = nombreApellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombreAgencia = nombreAgencia;
        this.documentacionOperacion = documentacionOperacion;
        this.valoracion = valoracion;
        this.cuotasArriendo = cuotasArriendo;
        this.tipoUsuario = tipoUsuario;
    }**/

    public UsuarioEntity(String rut, String nombreApellidos, String correo, String contrasena, String nombreAgencia, String documentacionOperacion, int valoracion, int cuotasArriendo, TipoUsuarioEntity tipoUsuario) {
        this.rut = rut;
        this.nombreApellidos = nombreApellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombreAgencia = nombreAgencia;
        this.documentacionOperacion = documentacionOperacion;
        this.valoracion = valoracion;
        this.cuotasArriendo = cuotasArriendo;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioEntity() {}

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getDocumentacionOperacion() {
        return documentacionOperacion;
    }

    public void setDocumentacionOperacion(String documentacionOperacion) {
        this.documentacionOperacion = documentacionOperacion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public int getCuotasArriendo() {
        return cuotasArriendo;
    }

    public void setCuotasArriendo(int cuotasArriendo) {
        this.cuotasArriendo = cuotasArriendo;
    }

    public TipoUsuarioEntity getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
/*
{
        "rut": "10",
        "nombreApellidos": "Pablito",
        "correo": "pablo32@hotmail.com",
        "contrasena": "123",
        "nombreAgencia": "",
        "documentacionOperacion": "",
        "valoracion": 4,
        "cuotasArriendo": 0,
        "tipoUsuario": {
        "idTipoUsuario": 2}
        }


        {
        "rut": "10",
        "nombreApellidos": "Pablito",
        "correo": "pablo32@hotmail.com",
        "contrasena": "123",
        "valoracion": 4,
        "cuotasArriendo": 0,
        "tipoUsuario": {
        "idTipoUsuario": 2}
        }
        */