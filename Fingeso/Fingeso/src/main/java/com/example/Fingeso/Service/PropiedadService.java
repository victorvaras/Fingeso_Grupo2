package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Repository.PropiedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropiedadService {

    @Autowired
    private PropiedadRepository propiedadRepository;

    public PropiedadEntity AgregarPropiedad(int Rol, String Tipo, String Tamanio, String Ubicacion, int Precio, String Imagenes, int Valoracion, String Contrato ){
        PropiedadEntity propiedad = new PropiedadEntity(Rol,Tipo, Tamanio,Ubicacion,Precio,Imagenes,Valoracion,Contrato);

        return propiedadRepository.save(propiedad);

    }


}
