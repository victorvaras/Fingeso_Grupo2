package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.Estado_PropiedadEntity;
import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Repository.Estado_PropiedadRepository;
import com.example.Fingeso.Repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Estado_PropiedadService {

    @Autowired
    Estado_PropiedadRepository estadoPropiedadRepository;

    public List<Estado_PropiedadEntity> getAllEstadoPropiedad() {
        return estadoPropiedadRepository.findAll();
    }

    public Estado_PropiedadEntity crearEstadoPropiedad(Estado_PropiedadEntity estadoPropiedad) {
        return estadoPropiedadRepository.save(estadoPropiedad);
    }

}
