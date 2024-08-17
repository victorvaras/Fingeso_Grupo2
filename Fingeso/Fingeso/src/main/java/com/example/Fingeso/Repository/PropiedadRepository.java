package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.PropiedadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropiedadRepository extends JpaRepository<PropiedadEntity, Integer> {
    PropiedadEntity findByRol(int rol);


    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM PropiedadEntity p WHERE p.rol = :rol")
    boolean existsByRol(@Param("rol") int rol);


}
