package com.example.Fingeso.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Horario")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHorario;
    private LocalDateTime horaDisponible;
    //fk usuario
    @ManyToOne
    @JoinColumn(name = "rut")
    private UsuarioEntity usuario;

    public HorarioEntity(LocalDateTime horaDisponible, UsuarioEntity usuario) {
        this.idHorario = idHorario;
        this.horaDisponible = horaDisponible;
        this.usuario = usuario;
    }

    public HorarioEntity() {}

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public LocalDateTime getHoraDisponible() {
        return horaDisponible;
    }

    public void setHoraDisponible(LocalDateTime horaDisponible) {
        this.horaDisponible = horaDisponible;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
