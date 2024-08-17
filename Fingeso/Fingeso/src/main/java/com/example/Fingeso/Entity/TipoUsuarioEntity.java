package com.example.Fingeso.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipoUsuario")
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoUsuario;
    private String tipoUsuario;


    public TipoUsuarioEntity(String tipoUsuario) {
        this.idTipoUsuario=idTipoUsuario;
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

/*
{
  "idTipoUsuario" : 1,
  "tipoUsuario" : "Comprador"
}
{
  "idTipoUsuario" : 2,
  "tipoUsuario" : "Arrendador"
}

*/