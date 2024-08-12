package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.Estado_PropiedadEntity;
import com.example.Fingeso.Service.Estado_PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado_propiedad")
@CrossOrigin
public class Estado_PropiedadController {

    @Autowired
    Estado_PropiedadService estado_propiedadService;

    @GetMapping
    public List<Estado_PropiedadEntity> getAllEstado_Propiedad(){
        return estado_propiedadService.getAllEstadoPropiedad();
    }

    @PostMapping("/nuevo")
    public Estado_PropiedadEntity crearEstado_Propiedad(@RequestBody Estado_PropiedadEntity nombre){
        return estado_propiedadService.crearEstadoPropiedad(nombre);
    }
}
