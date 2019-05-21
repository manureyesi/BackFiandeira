package es.fiandeira.usuario.service;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.usuario.body.UsuarioBody;

public interface IUsuarioService {

	/**
	 * Crear Usuario
	 *
	 * @param usuarioBody
	 * @return
	 * @throws ErrorFiandeiraException
	 */
	public void crearUsuario (final UsuarioBody usuarioBody) throws ErrorFiandeiraException;
	
}
