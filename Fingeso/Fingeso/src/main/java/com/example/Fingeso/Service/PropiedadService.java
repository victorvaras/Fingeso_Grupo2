package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Repository.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;


    public PropiedadEntity AgregarPropiedad(Integer rol, String Tipo, String Tamanio, String Ubicacion, int Precio, String Imagenes, int Valoracion, String Contrato ){

        PropiedadEntity propiedad = new PropiedadEntity(rol,Tipo, Tamanio,Ubicacion,Precio,Imagenes,Valoracion,Contrato);

        if(propiedadRepository.existsByRol(rol)){
            return null;
        }
        else {
            return propiedadRepository.save(propiedad);
        }

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