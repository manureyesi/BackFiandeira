package es.fiandeira.usuario.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.exception.TipoError;
import es.fiandeira.usuario.body.UsuarioBody;
import es.fiandeira.usuario.models.Usuario;
import es.fiandeira.usuario.repository.UsuarioRepository;
import es.fiandeira.usuario.utiles.IContrasenaUtiles;

public class UsuarioServiceImpl implements IUsuarioService {

	private static final Logger LOG = Logger.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IContrasenaUtiles contrasenaUtiles;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void crearUsuario(final UsuarioBody usuarioBody) throws ErrorFiandeiraException {

		//Comprobar Usuario repetido
		List<Usuario> listaUsuariosAux = 
				usuarioRepository.buscarUsuarioPorCorreo(usuarioBody.getCorreo());
		
		if (!CollectionUtils.isEmpty(listaUsuariosAux)) {
			LOG.error("crearUsuario: El usuario con correo ".concat(usuarioBody.getCorreo()).concat(" ya existe."));
			throw new ErrorFiandeiraException(TipoError.USUARIO_ERROR_REPETIDO);
		}
		
		String salt = contrasenaUtiles.generarSaltAleatorio();
		
		Usuario user = new Usuario(
				usuarioBody.getNombre(),
				usuarioBody.getApellidos(),
				usuarioBody.getCorreo(),
				salt,
				contrasenaUtiles.cifrarContrasenaBase64(
						usuarioBody.getContrasena(),
						salt));
		
		//Guardar Usuario
		usuarioRepository.save(user);
		
	}

}
