package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.Tipo_TransaccionEntity;
import com.example.Fingeso.Service.Tipo_TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_transaccion")
@CrossOrigin
public class Tipo_TransaccionController {

    @Autowired
    Tipo_TransaccionService tipo_transaccionService;


    @GetMapping
    public List<Tipo_TransaccionEntity> getAllTipo_Transaccion(){
        return tipo_transaccionService.getAllTipo_Transaccion();
    }


    @PostMapping("/nuevo")
    public Tipo_TransaccionEntity createTipo_Transaccion(@RequestBody Tipo_TransaccionEntity tipo_transaccion){
        return tipo_transaccionService.save(tipo_transaccion.getId_Tipo_usuario(), tipo_transaccion.getTipo_Transaccion());
    }
}
