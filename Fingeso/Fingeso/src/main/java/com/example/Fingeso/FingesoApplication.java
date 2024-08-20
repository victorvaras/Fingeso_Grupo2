package com.example.Fingeso;

import com.example.Fingeso.Service.Estado_PropiedadService;
import com.example.Fingeso.Service.PropiedadService;
import com.example.Fingeso.Service.TipoUsuarioService;
import com.example.Fingeso.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Fingeso.Repository")
@EntityScan(basePackages = "com.example.Fingeso.Entity")
public class FingesoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FingesoApplication.class, args);
	}




	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	@Autowired
	private Estado_PropiedadService estado_PropiedadService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PropiedadService propiedadService;


	@Override
	public void run(String... args) throws Exception {
		tipoUsuarioService.cargarDataTipoUsuario();
		estado_PropiedadService.cargarDataEstadoPropiedad();
		usuarioService.cargaData();
		propiedadService.cargarDataPropiedades();
	}


}
