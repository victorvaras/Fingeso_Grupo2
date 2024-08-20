package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Entity.UsuarioEntity;
import com.example.Fingeso.Repository.TipoUsuarioRepository;
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


    public String getRutUsuario(String correo) {
        UsuarioEntity usuario = usuarioRepository.findByCorreo(correo);
        return usuario.getRut();
    }

    @Autowired
    TipoUsuarioService tipoUsuarioService;
    public void cargaData(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        if(usuarios.size() > 0){
            return;
        }
        else{

            TipoUsuarioEntity tipoUsuario1 = tipoUsuarioService.buscarById(1);
            TipoUsuarioEntity tipoUsuario2 = tipoUsuarioService.buscarById(2);
            TipoUsuarioEntity tipoUsuario3 = tipoUsuarioService.buscarById(3);
            TipoUsuarioEntity tipoUsuario4 = tipoUsuarioService.buscarById(4);
            TipoUsuarioEntity tipoUsuario5 = tipoUsuarioService.buscarById(5);

            UsuarioEntity usuario1 = new UsuarioEntity("21159364-4", "Patricio Briseño", "patricio.briceno@usach.cl", "patricio","","",0,0,tipoUsuario1);
            UsuarioEntity usuario2 = new UsuarioEntity("21060190-2", "Aylin Castillo", "aylin.castillo@usach.cl", "aylin","","",0,0,tipoUsuario2);
            UsuarioEntity usuario3 = new UsuarioEntity("19800734-K", "Cristian Romero", "cristian.romero.m@usach.cl", "cristian","","",0,0,tipoUsuario3);
            UsuarioEntity usuario4 = new UsuarioEntity("21091719-5", "Victor Varas", "victor.varas@usach.cl", "victor","","",0,0,tipoUsuario4);
            UsuarioEntity usuario5 = new UsuarioEntity("21065666-9", "Agustin Vera", "agustin.vera@usach.cl", "agustin","","",0,0,tipoUsuario5);

            usuarioRepository.save(usuario1);
            usuarioRepository.save(usuario2);
            usuarioRepository.save(usuario3);
            usuarioRepository.save(usuario4);
            usuarioRepository.save(usuario5);
        }
    }

}
