package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.PropiedadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PropiedadRepository extends JpaRepository<PropiedadEntity, Integer> {

    PropiedadEntity findByRol(int rol);
}
