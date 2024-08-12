package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TransaccionRepository extends JpaRepository<TransaccionEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM TransaccionEntity p WHERE p.idTransaccion = :id_Transaccion")
    boolean existsTransaccion(@Param("id_Transaccion") Integer id_Transaccion);
}
