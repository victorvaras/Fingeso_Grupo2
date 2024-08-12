package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipousuario")
@CrossOrigin
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @GetMapping("/tipousuario")
    public List<TipoUsuarioEntity> getAllTipoUsuarios() {
        return tipoUsuarioService.getAllTipoUsuario();
    }

    //nuevo tipo de usuario
    @PostMapping("/nuevo")
    public TipoUsuarioEntity nuevoTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuarioNuevo) {
        return tipoUsuarioService.crearTipoUsuario(tipoUsuarioNuevo.getTipoUsuario());
    }


}
