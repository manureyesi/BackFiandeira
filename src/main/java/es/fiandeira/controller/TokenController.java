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
public class TokenController {

	private static final Logger LOG = Logger.getLogger(TokenController.class);
	
		@ApiOperation(
	        value = "Autentificacion Uusario",
	        notes = "Autentifica el usuario generando un Token de autorizacion con sus permisos"
	    )
		@RequestMapping(value = "/auth/token", method = RequestMethod.POST)
		public String autentificacionUsuario (
				@RequestHeader("app-consumidor") String appConsumidor,
				@RequestHeader("api-key") String apiKey,
				@RequestHeader(value = "ip", required = false) String ip) {
				
			LOG.info("[POST] /auth/token V: ");
		
			return "Hola";
		}
	
}
