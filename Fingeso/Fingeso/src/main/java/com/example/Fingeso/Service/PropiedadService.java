package com.example.Fingeso.Service;

import com.example.Fingeso.Entity.Estado_PropiedadEntity;
import com.example.Fingeso.Entity.PropiedadEntity;
import com.example.Fingeso.Entity.UsuarioEntity;
import com.example.Fingeso.Repository.Estado_PropiedadRepository;
import com.example.Fingeso.Repository.PropiedadRepository;
import com.example.Fingeso.Repository.UsuarioRepository;
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



    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    Estado_PropiedadRepository estadoPropiedadRepository;
    public void cargarDataPropiedades(){
        List<PropiedadEntity> propiedades = propiedadRepository.findAll();
        if(propiedades.size()>0){
            return;
        }
        else{
            UsuarioEntity usuario1 = usuarioRepository.findByRut("19800734-K");
            UsuarioEntity usuario2 = usuarioRepository.findByRut("21091719-5");
            Estado_PropiedadEntity estadoVenta =  estadoPropiedadRepository.findByEstado("Venta");
            Estado_PropiedadEntity estadoArriendo =  estadoPropiedadRepository.findByEstado("Arriendo");

            PropiedadEntity propiedad1 = new PropiedadEntity(1010,"Casa", "150", "Avenida principal 1454",120000000,"https://i.pinimg.com/736x/55/fb/91/55fb91d699b6ab99d42cadd2f849b2fc.jpg","Hermosa casa en el centro de Springfield con 3 habitaciones y 2 baños.",4,"", usuario1, estadoArriendo);
            PropiedadEntity propiedad2 = new PropiedadEntity(1011, "Departamento", "80", "Avenida Siempre Viva 742, Springfield", 85000000, "https://elcomercio.pe/resizer/sVxY-0w1wkqDRbFu7lhiJukoNsA=/1200x800/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/3MFMMWE3PRCWNNIV3ZS26AIG7U.jpg", "Moderno departamento de 2 habitaciones y 1 baño, cerca de centros comerciales.",4,"",usuario1, estadoArriendo);
            PropiedadEntity propiedad3 = new PropiedadEntity(1013, "Terreno", "10000", "Calle Principal s/n, Shelbyville", 20000,"https://eldiamantepropiedades.cl/wp-content/uploads/2023/10/2-4-scaled.jpg","Amplio terreno en Shelbyville, ideal para construcción de vivienda o comercio.",3,"", usuario1, estadoArriendo);
            PropiedadEntity propiedad4 = new PropiedadEntity(1040, "Casa de Campo", "200", "Ruta 66 km 25, Springfield", 160000000, "https://images.adsttc.com/media/images/509d/860e/b3fc/4b56/c100/02c5/large_jpg/PANORAMICO.jpg?1375801431", "Encantadora casa de campo con 4 habitaciones, 3 baños y amplio jardín.",5,"",usuario2,estadoVenta);
            PropiedadEntity propiedad5 = new PropiedadEntity(1050, "Casa", "180", "Calle Los Pinos 23, Springfield",140000000,"https://i.pinimg.com/originals/d4/f7/4f/d4f74fca0a12d6c4676d1332e0bd9d6a.jpg","Espaciosa casa de 4 habitaciones y 3 baños, con jardín y garaje para dos autos.",5,"", usuario2, estadoVenta);
            PropiedadEntity propiedad6 = new PropiedadEntity(1060, "Departamento", "100", "Calle Las Flores 89, Springfield", 110000000,"https://imganuncios.mitula.net/departamento_en_venta_en_%C3%B1u%C3%B1oa_santiago_100_m2_4_hab_5820125693419127855.jpg", "Departamento moderno de 3 habitaciones y 2 baños, con balcón y vista al parque.",3,"", usuario2, estadoVenta);

            PropiedadEntity propiedad7 = new PropiedadEntity(1070, "Departamento", "45", "Calle Pequeña 2, Springfield", 60000000,"https://a0.muscache.com/im/pictures/miso/Hosting-887341667082407916/original/124c89f0-3364-4bce-ac5d-70cb5431077a.jpeg?im_w=720", "Departamento compacto de 1 habitación y 1 baño, cerca de transporte público.",3,"", usuario2, estadoVenta);
            PropiedadEntity propiedad8 = new PropiedadEntity(1080, "Penthouse", "250","Avenida Central 100, Springfield", 300000000,"https://http2.mlstatic.com/D_NQ_NP_839828-MLC50432468761_062022-O.webp", "Lujoso penthouse de 4 habitaciones y 3 baños, con terraza privada y vistas panorámicas.", 5,"", usuario2, estadoVenta);
            PropiedadEntity propiedad9 = new PropiedadEntity(1090, "Mansión", "1000", "Calle de los Ricos 1, Beverly Hills", 1000000000, "https://media.vrbo.com/lodging/34000000/33550000/33549100/33549035/a7aa6523.jpg?impolicy=resizecrop&rw=575&rh=575&ra=fill", "Majestuosa mansión de 8 habitaciones y 10 baños, con piscina, cine privado y cancha de tenis.", 5,"", usuario2, estadoVenta);

            PropiedadEntity propiedad10 = new PropiedadEntity(2010,"Casa en la Playa", "200", "Playa Bonita 4079", 130000000, "https://cf.bstatic.com/xdata/images/hotel/max1024x768/406600223.jpg?k=960fbcf17b52369ff244c021d4b822f7c403bbc738777f97bf462de251dd1452&o=&hp=1", "Encantadora casa en la playa con 3 habitaciones, 2 baños, y una amplia terraza con vista al mar.", 3,"", usuario2, estadoVenta);

            propiedadRepository.save(propiedad1);
            propiedadRepository.save(propiedad2);
            propiedadRepository.save(propiedad3);
            propiedadRepository.save(propiedad4);
            propiedadRepository.save(propiedad5);
            propiedadRepository.save(propiedad6);
            propiedadRepository.save(propiedad7);
            propiedadRepository.save(propiedad8);
            propiedadRepository.save(propiedad9);
            propiedadRepository.save(propiedad10);
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