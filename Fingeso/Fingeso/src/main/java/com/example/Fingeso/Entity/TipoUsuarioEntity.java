package com.example.Fingeso.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipoUsuario")
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int idTipoUsuario;
    private String tipoUsuario;
    //INTENTO DE FK
    //@OneToMany (targetEntity = UsuarioEntity.class)
    //private List usuario;


    public TipoUsuarioEntity(int idTipoUsuario, String tipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuarioEntity() {}

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
