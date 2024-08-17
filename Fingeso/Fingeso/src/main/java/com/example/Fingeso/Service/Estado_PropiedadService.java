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


    public void cargarDataEstadoPropiedad() {
        List<Estado_PropiedadEntity> estadoPropiedad = estadoPropiedadRepository.findAll();
        if(estadoPropiedad.size()>0){
            return;
        }
        else{
            Estado_PropiedadEntity newEstado_Venta = new Estado_PropiedadEntity(1,"Venta");
            Estado_PropiedadEntity newEstado_Arriendo = new Estado_PropiedadEntity(2,"Arriendo");
            Estado_PropiedadEntity newEstado_Finalizada = new Estado_PropiedadEntity(3,"Finalizada");
        }
    }

}
