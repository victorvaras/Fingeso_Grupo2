package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.BoletaEntity;
import com.example.Fingeso.Service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boleta")
@CrossOrigin
public class BoletaController {

    @Autowired
    BoletaService boletaService;

    @GetMapping
    public List<BoletaEntity> getAllBoletas(){
        return boletaService.getAllBoleta();
    }

    //Nueva boleta
    @PostMapping("/nueva")
    public BoletaEntity nuevoBoleta(@RequestBody BoletaEntity boleta) {

        return boletaService.createBoleta(boleta.getMonto(), boleta.getFecha(), boleta.getMedio_Pasarela());

    }



}
