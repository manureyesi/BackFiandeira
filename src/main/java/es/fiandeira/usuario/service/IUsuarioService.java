package es.fiandeira.usuario.service;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.usuario.body.UsuarioBody;
import es.fiandeira.usuario.vo.UsuarioVO;

public interface IUsuarioService {

	/**
	 * Crear Usuario
	 *
	 * @param usuarioBody
	 * @return UsuarioVO
	 * @throws ErrorFiandeiraException
	 */
	public UsuarioVO crearUsuario (final UsuarioBody usuarioBody) throws ErrorFiandeiraException;
	
}
