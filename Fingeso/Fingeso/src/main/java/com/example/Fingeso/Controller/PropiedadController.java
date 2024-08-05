package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propiedad")
@CrossOrigin
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    //Nueva propiedad
    @PostMapping("/nueva")
    public PropiedadEntity nuevaPropiedad(@RequestBody PropiedadEntity nuevo) {

        return propiedadService.AgregarPropiedad(nuevo.getRol(), nuevo.getTipo(), nuevo.getTamano(), nuevo.getUbicacion(), nuevo.getPrecio(), nuevo.getImagenes(), nuevo.getValoracion(), nuevo.getContrato());
    }


}