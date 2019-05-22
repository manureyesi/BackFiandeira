package es.fiandeira.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fiandeira.exception.BodyValidationException;
import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.exception.HeaderValidationException;
import es.fiandeira.exception.TipoError;
import es.fiandeira.token.body.TokenBody;
import es.fiandeira.usuario.body.UsuarioBody;
import es.fiandeira.usuario.vo.ResultadoCreacionUsuarioVO;
import es.fiandeira.usuario.vo.UsuarioVO;
import es.fiandeira.vo.ResultadoVO;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TokenController {

	private static final Logger LOG = Logger.getLogger(TokenController.class);
	
	@ApiOperation(
        value = "Crear Token Usuario",
        notes = "Crear Token usuario"
    )
	@RequestMapping(value = "/auth/token", method = RequestMethod.POST)
	public ResultadoCreacionUsuarioVO crearToken (
			@RequestHeader("app-consumidor") final String appConsumidor,
			@RequestHeader(value = "ip", required = false) final String ip,
			@RequestBody final TokenBody body) {
			
		LOG.info("[POST] /auth/token appConsumidor: ".concat(appConsumidor));
	
		ResultadoVO resultado = null;
		UsuarioVO usuario = null;
		
		try {
			body.comprobarCamposObligatorios();
			resultado = new ResultadoVO(appConsumidor, TipoError.OK.getCodigo() , TipoError.OK.getDescripcion());
		} catch (BodyValidationException e) {
			LOG.error("Error Body y Header", e);
			resultado = new ResultadoVO(appConsumidor, e.getCodigoError(), e.getDescripcionError());
		} catch (ErrorFiandeiraException e) {
			LOG.error("Error al añadir usuario", e);
			resultado = new ResultadoVO(appConsumidor, e.getCodigoError(), e.getDescripcionError());
		}
		
		return new ResultadoCreacionUsuarioVO(
				usuario,
				resultado);
	}
	
}
