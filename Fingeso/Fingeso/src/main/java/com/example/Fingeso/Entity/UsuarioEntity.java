package com.example.Fingeso.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class UsuarioEntity {
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

}
