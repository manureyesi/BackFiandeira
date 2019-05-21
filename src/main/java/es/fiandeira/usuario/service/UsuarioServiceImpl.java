package es.fiandeira.usuario.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.exception.TipoError;
import es.fiandeira.rangos.models.Rangos;
import es.fiandeira.rangos.models.RangosPK;
import es.fiandeira.rangos.repository.RangosRepository;
import es.fiandeira.usuario.body.UsuarioBody;
import es.fiandeira.usuario.models.Usuario;
import es.fiandeira.usuario.repository.UsuarioRepository;
import es.fiandeira.usuario.utiles.IContrasenaUtiles;
import es.fiandeira.usuario.vo.UsuarioVO;
import es.fiandeira.utiles.Constantes;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private static final Logger LOG = Logger.getLogger(UsuarioServiceImpl.class);
		
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RangosRepository rangosRepository;
	
	@Autowired
	private IContrasenaUtiles contrasenaUtiles;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioVO crearUsuario(final UsuarioBody usuarioBody) throws ErrorFiandeiraException {

		LOG.info("crearUsuario: Preparando creacion usuario ".concat(usuarioBody.getCorreo()));
		
		//Comprobar Usuario repetido
		Usuario usuariosAux = 
				usuarioRepository.buscarUsuarioPorCorreo(usuarioBody.getCorreo());
		
		if (usuariosAux!=null) {
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
		
		//Buscar Datos Usuario
		usuariosAux = usuarioRepository.buscarUsuarioPorCorreo(usuarioBody.getCorreo());
		
		LOG.info("crearUsuario: Usuaio creado con id ".concat(usuariosAux.getId().toString()).concat(" correo ").concat(usuariosAux.getCorreo()));
		
		Rangos rango = new Rangos(new RangosPK(
				usuariosAux.getId(),
				Constantes.ID_RANGO_GENERAL));
		
		//Guardar Rango
		rangosRepository.save(rango);
		
		LOG.info("crearUsuario: Añadido usuario ".concat(usuariosAux.getId().toString()).concat(" a rango General ").concat(rango.toString()));
		
		return new UsuarioVO(
				usuariosAux.getId(),
				usuariosAux.getCorreo(),
				usuariosAux.getNombre(),
				usuariosAux.getApellidos());
		
	}

}
