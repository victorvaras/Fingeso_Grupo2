package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.BoletaEntity;
import com.example.Fingeso.Repository.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BoletaService {

    @Autowired
    BoletaRepository boletaRepository;

    public List<BoletaEntity> getAllBoleta (){
        return boletaRepository.findAll();
    }

    public BoletaEntity createBoleta( int monto, Date fecha, String medioPasarela ){

        BoletaEntity boleta = new BoletaEntity( monto, fecha, medioPasarela);
        if(boletaRepository.existsBoleta(boleta.getId_Boleta())){
            return null;
        }
        else {
            return boletaRepository.save(boleta);
        }

    }


}
