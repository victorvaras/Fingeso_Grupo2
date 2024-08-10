package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<TipoUsuarioEntity> getAllTipoUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuarioEntity crearTipoUsuario(int idTipoUsuario, String tipoUsuario) {
        TipoUsuarioEntity newtipoUsuario = new TipoUsuarioEntity(idTipoUsuario, tipoUsuario);
        Optional<TipoUsuarioEntity> existe = tipoUsuarioRepository.findById(idTipoUsuario);
        if (existe.isEmpty()) {
            return null;
        }else{
            return tipoUsuarioRepository.save(newtipoUsuario);
        }
    }
}
