package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.BoletaEntity;
import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Entity.TransaccionEntity;
import com.example.Fingeso.Repository.TransaccionRepository;
import com.example.Fingeso.Service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
@CrossOrigin
public class TransaccionController {

    @Autowired
    TransaccionService transaccionService;

    @GetMapping
    public List<TransaccionEntity> getAllTransaccion(){
        return transaccionService.getAllTransacciones();
    }

    @PostMapping("/nueva")
    public TransaccionEntity createTransaccion(@RequestBody TransaccionEntity transaccion){

        return transaccionService.createTransaccion(transaccion);
    }
}
