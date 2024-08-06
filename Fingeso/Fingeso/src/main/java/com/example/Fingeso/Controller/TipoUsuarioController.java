package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo_usuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    @Autowired
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    //nuevo tipo de usuario
    @PostMapping("/nuevoTipoUsuario")
    public TipoUsuarioEntity nuevoTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuarioNuevo) {
        return tipoUsuarioService.agregarTipoUsuario(tipoUsuarioNuevo.getIdTipoUsuario(),tipoUsuarioNuevo.getTipoUsuario());
    }
}
