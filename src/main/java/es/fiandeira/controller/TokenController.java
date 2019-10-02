package es.fiandeira.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fiandeira.configuration.filters.HeaderFilterCustom;
import es.fiandeira.exception.BodyValidationException;
import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.exception.TipoError;
import es.fiandeira.token.body.TokenBody;
import es.fiandeira.token.service.ITokenService;
import es.fiandeira.token.vo.TokenRespuestaVO;
import es.fiandeira.vo.ResultadoVO;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TokenController {

	private static final Logger LOG = Logger.getLogger(TokenController.class);
	
	@Autowired
	private ITokenService tokenService;
	
	@ApiOperation(
        value = "Crear Token Usuario",
        notes = "Crear Token usuario"
    )
	@HeaderFilterCustom
	@RequestMapping(value = "/auth/token", method = RequestMethod.POST)
	public TokenRespuestaVO crearToken (
			HttpServletRequest request,
			@RequestHeader("app-consumidor") final String appConsumidor,
			@RequestBody final TokenBody body) {
			
		LOG.info("[POST] /auth/token appConsumidor: ".concat(appConsumidor));
	
		TokenRespuestaVO respuestaToken = new TokenRespuestaVO();
		
		try {
			body.comprobarCamposObligatorios();
			respuestaToken = tokenService.crearToken(body, request.getRemoteAddr());
			respuestaToken.setResultado(new ResultadoVO(appConsumidor, TipoError.OK.getCodigo() , TipoError.OK.getDescripcion()));
		} catch (BodyValidationException e) {
			LOG.error("Error Body y Header", e);
			respuestaToken.setResultado(new ResultadoVO(appConsumidor, e.getCodigoError(), e.getDescripcionError()));
		} catch (ErrorFiandeiraException e) {
			LOG.error("Error al añadir usuario", e);
			respuestaToken.setResultado(new ResultadoVO(appConsumidor, e.getCodigoError(), e.getDescripcionError()));
		}
		
		return respuestaToken;
	}
	
}
