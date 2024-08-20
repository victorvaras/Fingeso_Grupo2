package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.Estado_PropiedadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Estado_PropiedadRepository extends JpaRepository<Estado_PropiedadEntity, Integer> {

    Estado_PropiedadEntity findByEstado(String nombre);
}
