package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.HorarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HorarioRepository extends JpaRepository<HorarioEntity, Integer> {
    Optional<HorarioEntity> findById(int id);
}
