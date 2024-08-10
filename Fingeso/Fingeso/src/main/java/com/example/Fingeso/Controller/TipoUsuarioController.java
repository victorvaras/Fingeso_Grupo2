package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    @Autowired
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("/tipousuario")
    public List<TipoUsuarioEntity> getAllTipoUsuarios() {
        return tipoUsuarioService.getAllTipoUsuario();
    }

    //nuevo tipo de usuario
    @PostMapping("/nuevo")
    public TipoUsuarioEntity nuevoTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuarioNuevo) {
        return tipoUsuarioService.crearTipoUsuario(tipoUsuarioNuevo.getIdTipoUsuario(),tipoUsuarioNuevo.getTipoUsuario());
    }


}
