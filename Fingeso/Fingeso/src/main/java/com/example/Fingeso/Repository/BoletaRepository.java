package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.BoletaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoletaRepository extends JpaRepository<BoletaEntity,Integer> {


    //BoletaEntity findById_Boleta(int idBoleta);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM BoletaEntity p WHERE p.idBoleta = :id_Boleta")
    boolean existsBoleta(@Param("id_Boleta") Integer id_Boleta);
}

