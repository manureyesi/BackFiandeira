package es.fiandeira.token.service;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.token.body.TokenBody;
import es.fiandeira.token.vo.TokenRespuestaVO;

public interface ITokenService {

	/**
	 * Crear Token para un usuario
	 *
	 * @param tokenBody
	 * @throws ErrorFiandeiraException
	 */
	public TokenRespuestaVO crearToken (final TokenBody tokenBody) throws ErrorFiandeiraException;
	
}
