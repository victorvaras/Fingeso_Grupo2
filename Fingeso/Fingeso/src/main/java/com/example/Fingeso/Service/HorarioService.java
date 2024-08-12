package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.HorarioEntity;
import com.example.Fingeso.Repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    private final HorarioRepository horarioRepository;

    @Autowired
    public HorarioService(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    public List<HorarioEntity> getAllHorario(){
        return horarioRepository.findAll();
    }

    public HorarioEntity crearHorario(HorarioEntity horario){
        return horarioRepository.save(horario);
    }
}
