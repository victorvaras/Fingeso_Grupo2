package com.example.Fingeso.Controller;

import com.example.Fingeso.Entity.HorarioEntity;
import com.example.Fingeso.Service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horario")
@CrossOrigin
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    @GetMapping
    public List<HorarioEntity> getAllHorario() {
        return horarioService.getAllHorario();
    }

    @PostMapping("/nuevo")
    public HorarioEntity crearHorario(@RequestBody HorarioEntity horario) {
        return horarioService.crearHorario(horario);
    }
}
