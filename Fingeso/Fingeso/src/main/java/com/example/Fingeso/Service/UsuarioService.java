package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Entity.UsuarioEntity;
import com.example.Fingeso.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity crearUsuario(UsuarioEntity usuario) {
       // UsuarioEntity newUsuario = new UsuarioEntity(usuario);
        //no es necesario poner todos los atributos como en tipo usuario
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity usuarioByEmail(String email) {
        return usuarioRepository.findByCorreo(email);
    }


    public UsuarioEntity loginUsuario(UsuarioEntity usuario) {

        UsuarioEntity usuarioValidar = usuarioRepository.findByCorreo(usuario.getCorreo());

        if (usuarioValidar != null) {
            String correoValidar = usuario.getCorreo();



            if (usuarioValidar.getCorreo().equals(correoValidar) && usuarioValidar.getContrasena().equals(usuario.getContrasena())) {
                return usuarioValidar;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
}
