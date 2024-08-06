package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioEntity agregarTipoUsuario(int idTipoUsuario, String tipoUsuario) {
        TipoUsuarioEntity newtipoUsuario = new TipoUsuarioEntity(idTipoUsuario, tipoUsuario);
        TipoUsuarioEntity existe = tipoUsuarioRepository.findbyId(idTipoUsuario);
        if (existe != null) {
            return null;
        }else{
            return tipoUsuarioRepository.save(newtipoUsuario);
        }
    }
}
