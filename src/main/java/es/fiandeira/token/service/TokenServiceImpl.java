package es.fiandeira.token.service;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.exception.TipoError;
import es.fiandeira.rangos.models.Rangos;
import es.fiandeira.rangos.repository.RangosRepository;
import es.fiandeira.token.body.TokenBody;
import es.fiandeira.token.mapper.TokenMapper;
import es.fiandeira.token.models.Token;
import es.fiandeira.token.repository.TokenRepository;
import es.fiandeira.token.vo.TokenRespuestaVO;
import es.fiandeira.usuario.mapper.UsuarioMapper;
import es.fiandeira.usuario.models.Usuario;
import es.fiandeira.usuario.repository.UsuarioRepository;
import es.fiandeira.usuario.utiles.IContrasenaUtiles;
import es.fiandeira.utiles.Constantes;

@Service
public class TokenServiceImpl implements ITokenService {
	
	private static final Logger LOG = Logger.getLogger(TokenServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RangosRepository rangosRepository;
	
	@Autowired
	private IContrasenaUtiles contrasenaUtiles;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TokenRespuestaVO crearToken(final TokenBody tokenBody, final String ip) throws ErrorFiandeiraException {
		
		LOG.info("crearToken: Peparando creacion token usuario ".concat(tokenBody.getCorreo()));
		
		//Buscar Usuario en DB
		Usuario usuariosAux = 
				usuarioRepository.buscarUsuarioPorCorreo(tokenBody.getCorreo());
		
		if (usuariosAux==null) {
			LOG.error("crearToken: El usuario con correo ".concat(tokenBody.getCorreo()).concat(" no existe."));
			throw new ErrorFiandeiraException(TipoError.USUARIO_ERROR);
		}
		
		//Comprobar si el usuario tiene asignado rango
		List<Rangos> rangosUsuario = 
				rangosRepository.buscarRangosPorIdUsuario(usuariosAux.getId());
		
		if (CollectionUtils.isEmpty(rangosUsuario)) {
			LOG.error("crearToken: El usuario no pertenece a ningun grupo ".concat(tokenBody.getCorreo()).concat(" no puede crear token."));
			throw new ErrorFiandeiraException(TipoError.RANGOS_ERROR_NO_ASIGNADO);
		}
		
		LOG.info("crearToken: Usuario ".concat(tokenBody.getCorreo()).concat(" encontrando, comprobando contraseña"));
		
		//Comprobar contrasena
		String contrasena = contrasenaUtiles.cifrarContrasenaBase64(
				tokenBody.getContrasena(),
				usuariosAux.getSalt());
		
		if (!contrasena.equals(usuariosAux.getPaswordSalt())) {
			LOG.error("crearToken: La contrasena no es correcta ".concat(tokenBody.getCorreo()).concat(" no puede crear token."));
			throw new ErrorFiandeiraException(TipoError.USUARIO_ERROR);
		}
		
		String token = generarTokenAleatorio();
		String tokenRefresco = generarTokenRefrescoAleatorio();
				
		//Horas validez token
		Integer horasValidez = tokenBody.getHorasValidez()==null?Constantes.DURACION_TOKEN_DEFECTO : tokenBody.getHorasValidez();
		
		//Fecha actual
		Calendar fechaActual = Calendar.getInstance();
		
		//Fecha Caducidad Token
		Calendar fechaCaducidadToken = Calendar.getInstance();
		fechaCaducidadToken.add(Calendar.HOUR, horasValidez);
		
		//Fecha Caducidad Token refresco
		Calendar fechaCaducidadTokenRefresco = Calendar.getInstance();
		fechaCaducidadTokenRefresco.add(Calendar.MONTH, Constantes.DURACION_TOKEN_REFRESCO_DEFECTO);
		
		//Crear token
		Token tokenDto = new Token(token,
				tokenRefresco,
				fechaActual.getTime(),
				fechaCaducidadToken.getTime(),
				fechaCaducidadTokenRefresco.getTime(),
				tokenBody.getIdApp(),
				usuariosAux.getId(),
				Constantes.INVALIDADO_TOKEN_DEFECTO,
				ip,
				Constantes.REFRESCABLE_TOKEN_DEFECTO,
				horasValidez);
		
		//Guardar Token
		tokenRepository.save(tokenDto);
		
		Token tokenUsuario = tokenRepository.buscarTokenPorToken(token);
		
		//Comprobar si existe Token
		if (tokenUsuario==null) {
			LOG.error("crearToken: El token no fue creado correctamente para ".concat(tokenBody.getCorreo()));
			throw new ErrorFiandeiraException(TipoError.ERROR_TOKEN_GENERADO);
		}
		
		return new TokenRespuestaVO(
				UsuarioMapper.mapperUsuarioToUsuarioVO(usuariosAux, rangosUsuario),
				TokenMapper.mapperUsuarioToUsuarioVO(tokenUsuario));
	}

	/**
	    * Generar Token Aleatorio
	    * @return String Token
	    */
		private String generarTokenAleatorio () {
			
			String caracteres = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
	        int numero;
	        StringBuilder token = new StringBuilder();
	        
	        for (int i = 0; i < 32 ; i++) {
	        	numero = (int) (Math.random() * caracteres.length()) + 1;
	        	token.append(caracteres.charAt(numero-1));
	        	if(i == 8 || i == 12 || i == 16 || i == 20) {
	        		token.append('-');
	        	}
	        }
			
	        LOG.debug("generarTokenAleatorio: Generado Token aleatorio: "+token.toString());
	        
	        return token.toString();
		}
		
		/**
	    * Generar Token refresco Aleatorio
	    * @return String Token Refresco
	    */
		private String generarTokenRefrescoAleatorio () {
			
			String caracteres = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
	        int numero;
	        StringBuilder token = new StringBuilder();
	        
	        for (int i = 0; i < 34 ; i++) {
	        	numero = (int) (Math.random() * caracteres.length()) + 1;
	        	token.append(caracteres.charAt(numero-1));
	        	if(i == 8 || i == 12 || i == 16 || i == 20) {
	        		token.append('-');
	        	}
	        }
			
	        LOG.debug("generarTokenRefrescoAleatorio: Generado Token refresco aleatorio: "+token.toString());
	        
	        return token.toString();
		}
	
}
