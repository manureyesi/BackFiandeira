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
	        value = "Envia correo contacto",
	        notes = "Envio correo contacto a la comunidad y una confirmación al usuario"
	    )
		@RequestMapping(value = "/contacto", method = RequestMethod.POST)
		public String loginUsuario(
				@RequestHeader("app-consumidor") String appConsumidor,
				@RequestHeader("api-key") String apiKey,
				@RequestHeader(value = "ip", required = false) String ip) {
				
			LOG.info("Pruebas");
		
					return "Hola";
		}
	
}
