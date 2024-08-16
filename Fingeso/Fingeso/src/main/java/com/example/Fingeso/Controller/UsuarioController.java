package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.UsuarioEntity;
import com.example.Fingeso.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //http://localhost:8080/usuario
    @GetMapping()
    public List<UsuarioEntity> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    //http://localhost:8080/usuario/nuevo
    @PostMapping("/nuevo")
    public UsuarioEntity nuevoUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.crearUsuario(usuario);

    }
    

    @PostMapping("/login")
    public int loginUsuario(@RequestBody UsuarioEntity usuario){

        UsuarioEntity usuarioValidar = usuarioService.loginUsuario(usuario);

        if( usuarioValidar != null){
            return usuarioValidar.getTipoUsuario().getIdTipoUsuario();
        }
        else{
            return 0;
        }
    }


}
