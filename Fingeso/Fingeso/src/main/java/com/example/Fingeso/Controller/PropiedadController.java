package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Service.PropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propiedad")
@CrossOrigin
public class PropiedadController {

    @Autowired
    private PropiedadService propiedadService;

    @GetMapping
    public List<PropiedadEntity> getPropiedades() {
        return propiedadService.getAllPropiedad();
    }


    //Nueva propiedad
    @PostMapping("/nueva")
    public PropiedadEntity nuevaPropiedad(@RequestBody PropiedadEntity nuevo) {

        return propiedadService.AgregarPropiedad(nuevo);
    }


}