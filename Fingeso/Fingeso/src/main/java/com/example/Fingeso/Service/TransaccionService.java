package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.BoletaEntity;
import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Entity.TransaccionEntity;
import com.example.Fingeso.Repository.TransaccionRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    TransaccionRepository transaccionRepository;

    public List<TransaccionEntity> getAllTransacciones(){
        return transaccionRepository.findAll();
    }


    public TransaccionEntity createTransaccion(TransaccionEntity transaccion){

        return transaccionRepository.save(transaccion);
    }


}
