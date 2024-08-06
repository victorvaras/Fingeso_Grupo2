package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.Tipo_TransaccionEntity;
import com.example.Fingeso.Repository.Tipo_TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_TransaccionService {

    @Autowired
    Tipo_TransaccionRepository tipo_transaccion;

    public List<Tipo_TransaccionEntity> getAllTipo_Transaccion() {
        return tipo_transaccion.findAll();
    }


    public Tipo_TransaccionEntity save(int id_Tipo_Transaccion, String Tipo_Transaccion){

        Tipo_TransaccionEntity tipo_transaccionEntity = new Tipo_TransaccionEntity(id_Tipo_Transaccion, Tipo_Transaccion);

        if(tipo_transaccion.existsById(id_Tipo_Transaccion)){
            return null;
        }
        else{
            return tipo_transaccion.save(tipo_transaccionEntity);
        }
    }

}
