package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Repository.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;


    public List<PropiedadEntity> getAllPropiedad(){
        return propiedadRepository.findAll();
    }

    public PropiedadEntity AgregarPropiedad(PropiedadEntity Propiedad){

        return propiedadRepository.save(Propiedad);
    }


}

/*

PropiedadEntity existe = propiedadRepository.findByRol(rol);

        if(existe != null){
            return null;
        }
        else {
            return propiedadRepository.save(propiedad);
        }
 */