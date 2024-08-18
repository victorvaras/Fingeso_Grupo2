package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Repository.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;


    public List<PropiedadEntity> getAllPropiedad(){
        return propiedadRepository.findAll();
    }

    public int AgregarPropiedad(PropiedadEntity Propiedad){

        boolean validacion = propiedadRepository.existsByRol(Propiedad.getRol());
        if(validacion){
            return 0;
        }
        else{
            propiedadRepository.save(Propiedad);
            return 1;
        }
    }

    public Optional<PropiedadEntity> findByRol(int rol) {return propiedadRepository.findByRol(rol);}

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