package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.TipoUsuarioEntity;
import com.example.Fingeso.Entity.UsuarioEntity;
import com.example.Fingeso.Repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public List<TipoUsuarioEntity> getAllTipoUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuarioEntity crearTipoUsuario(String tipoUsuario) {
        TipoUsuarioEntity newtipoUsuario = new TipoUsuarioEntity(tipoUsuario);
        return tipoUsuarioRepository.save(newtipoUsuario);

    }

    public TipoUsuarioEntity buscarById(int id) {
        return tipoUsuarioRepository.findById(id);
    }


    public void cargarDataTipoUsuario() {
        List<TipoUsuarioEntity> tipoUsuario = tipoUsuarioRepository.findAll();
        if (tipoUsuario.size() > 0) {
            return;
        }
        else{
            TipoUsuarioEntity tipoUsuaroAdmin = new TipoUsuarioEntity("Administrador");
            TipoUsuarioEntity tipoUsuarioComprador = new TipoUsuarioEntity("Comprador");
            TipoUsuarioEntity tipoUsuarioVendedor = new TipoUsuarioEntity("Vendedor");
            TipoUsuarioEntity tipoUsuarioArrendador = new TipoUsuarioEntity("Arrendador");
            TipoUsuarioEntity tipoUsuarioArrendatario = new TipoUsuarioEntity("Arrendatario");
            tipoUsuarioRepository.save(tipoUsuaroAdmin);
            tipoUsuarioRepository.save(tipoUsuarioComprador);
            tipoUsuarioRepository.save(tipoUsuarioVendedor);
            tipoUsuarioRepository.save(tipoUsuarioArrendador);
            tipoUsuarioRepository.save(tipoUsuarioArrendatario);
            return;
        }
    }
}
