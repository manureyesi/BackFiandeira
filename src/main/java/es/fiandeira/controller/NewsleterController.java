package es.fiandeira.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.fiandeira.exception.TipoError;
import es.fiandeira.token.body.TokenBody;
import es.fiandeira.vo.ResultadoVO;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewsleterController {

	private static final Logger LOG = Logger.getLogger(NewsleterController.class);
	
	@ApiOperation(
        value = "Añadir a Newsletter",
        notes = "Añadir correo para recivir nuestra newsletter"
    )
	@RequestMapping(value = "/newsletter/anadir", method = RequestMethod.POST)
	public ResponseEntity<ResultadoVO> anadirNewsletter (
			@RequestHeader("app-consumidor") final String appConsumidor,
			@RequestHeader(value = "ip", required = false) final String ip,
			@RequestBody final TokenBody body) {
			
		LOG.info("[POST] /newsletter/anadir appConsumidor: ".concat(appConsumidor));
	
		ResponseEntity<ResultadoVO> resulEntity = null;
		ResultadoVO respuesta = null;
		
		//try {
			respuesta = new ResultadoVO(appConsumidor, TipoError.OK.getCodigo() , TipoError.OK.getDescripcion());
			resulEntity = new ResponseEntity<ResultadoVO>(respuesta, HttpStatus.OK);
		/*} catch (BodyValidationException e) {
			LOG.error("Error Body y Header", e);
			resulEntity = new ResponseEntity<ResultadoVO>(new ResultadoVO(appConsumidor, e.getCodigoError(), e.getDescripcionError()), HttpStatus.OK);
		} catch (ErrorFiandeiraException e) {
			LOG.error("Error al añadir usuario", e);
			resulEntity = new ResponseEntity<ResultadoVO>(new ResultadoVO(appConsumidor, e.getCodigoError(), e.getDescripcionError()), HttpStatus.OK);
		}*/
		
		return resulEntity;
	}
	
}
