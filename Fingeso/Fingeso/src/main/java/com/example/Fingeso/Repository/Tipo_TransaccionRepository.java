package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.Tipo_TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Tipo_TransaccionRepository extends JpaRepository<Tipo_TransaccionEntity, Integer> {

    boolean existsById(Integer id);
}
