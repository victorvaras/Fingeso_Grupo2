package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo_usuario")
@CrossOrigin
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    //nuevo tipo de usuario
    @PostMapping("/nuevoTipoUsuario")
    public TipoUsuarioEntity nuevoTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuarioNuevo) {
        return tipoUsuarioService.agregarTipoUsuario(tipoUsuarioNuevo.getIdTipoUsuario(),tipoUsuarioNuevo.getTipoUsuario());
    }
}
