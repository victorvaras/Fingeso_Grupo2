package com.example.Fingeso.Repository;
import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
    UsuarioEntity findByRut(String rut);

    UsuarioEntity findByCorreo(String email);
}
