package com.example.Fingeso.Repository;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Integer> {
    //siempre hay posibilidad de que entregue un nulo
    //si quiero hacer algo extra:
    // @Query("SELECT * FROM a WHERE a.name = ?1 AND a.password = ?2
    // ?1 ES EL PRIMER ARGUMENTO, ?2 ES ELL SEGUNDO ARGUMENTO, BLABLABLA
    // EN EL FIND BY ID ?1 SERÍA ID

    TipoUsuarioEntity findById(int idTipoUsuario);


}
