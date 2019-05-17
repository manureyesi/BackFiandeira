package es.fiandeira.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UsuarioController {

	private static final Logger LOG = Logger.getLogger(UsuarioController.class);
	
	@ApiOperation(
        value = "Crear Usuario",
        notes = "Crear usuario con Rango por defecto"
    )
	@RequestMapping(value = "/usuario/crearUsuario", method = RequestMethod.POST)
	public String autentificacionUsuario (
			@RequestHeader("app-consumidor") String appConsumidor,
			@RequestHeader(value = "ip", required = false) String ip) {
			
		LOG.info("[POST] /usuario/crearUsuario appConsumidor: ".concat(appConsumidor).concat(" ip: ").concat(ip));
	
		
		return "Hola";
	}
	
}
