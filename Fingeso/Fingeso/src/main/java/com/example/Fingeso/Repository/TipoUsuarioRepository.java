package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Integer> {

    TipoUsuarioEntity findbyId(int id);
}
