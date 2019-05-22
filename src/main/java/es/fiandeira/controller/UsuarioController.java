package es.fiandeira.controller;

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
import es.fiandeira.exception.HeaderValidationException;
import es.fiandeira.exception.TipoError;
import es.fiandeira.usuario.body.UsuarioBody;
import es.fiandeira.usuario.service.IUsuarioService;
import es.fiandeira.usuario.vo.ResultadoCreacionUsuarioVO;
import es.fiandeira.usuario.vo.UsuarioVO;
import es.fiandeira.vo.ResultadoVO;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UsuarioController {

	private static final Logger LOG = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@ApiOperation(
        value = "Crear Usuario",
        notes = "Crear usuario con Rango por defecto"
    )
	@HeaderFilterCustom
	@RequestMapping(value = "/usuario/crearUsuario", method = RequestMethod.POST)
	public ResultadoCreacionUsuarioVO crearUsuario (
			@RequestHeader("app-consumidor") final String appConsumidor,
			@RequestHeader(value = "ip", required = false) final String ip,
			@RequestBody final UsuarioBody body) {
			
		LOG.info("[POST] /usuario/crearUsuario appConsumidor: ".concat(appConsumidor));
	
		ResultadoVO resultado = null;
		UsuarioVO usuario = null;
		
		try {
			usuario = usuarioService.crearUsuario(body);
			resultado = new ResultadoVO(appConsumidor, TipoError.OK.getCodigo() , TipoError.OK.getDescripcion());
		} catch (BodyValidationException | HeaderValidationException e) {
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
