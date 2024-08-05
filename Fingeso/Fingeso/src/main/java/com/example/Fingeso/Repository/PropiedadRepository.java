package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.PropiedadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropiedadRepository extends JpaRepository<PropiedadEntity, Integer> {

    PropiedadEntity findByRol(int rol);
}
