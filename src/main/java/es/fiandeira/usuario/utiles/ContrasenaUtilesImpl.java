/**
 *
 */
package es.fiandeira.usuario.utiles;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.fiandeira.exception.ErrorFiandeiraException;
import es.fiandeira.exception.TipoError;

/**
 * @author mreyesi
 *
 */
@Component
public class ContrasenaUtilesImpl implements IContrasenaUtiles {

	private static final Logger LOG = LoggerFactory.getLogger(ContrasenaUtilesImpl.class);

	private static final Integer NUMERO_ITERACIONES = 1000;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String cifrarContrasenaBase64(final String contrasena, final String salt) throws ErrorFiandeiraException {

		return getHashPassword(contrasena, salt);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarSaltAleatorio() throws ErrorFiandeiraException {

		String salt = null;
		SecureRandom random;

		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			byte[] bSalt = new byte[8];
			random.nextBytes(bSalt);
			salt=Base64.encodeBase64String(bSalt);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("generarSaltAleatorio: Error algoritmo", e);
			throw new ErrorFiandeiraException(e, TipoError.USUARIO_ERROR_GENERAR_PASSWORD);
		}

		return salt;
	}

	/**
    * Con una pass y un salt genera el hash correspondiente en Base64
    * @param password String la contraseña a encriptar en UTF-8
    * @param salt String el salt en base64
    * @return String el hash en base64
    */
	private String getHashPassword(final String password, final String salt) throws ErrorFiandeiraException {

		String hash = null;
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(Base64.decodeBase64(salt));
            byte[] input = digest.digest(password.getBytes("iso-8859-1"));

			for (int i = 0; i < NUMERO_ITERACIONES; i++) {
			    digest.reset();
			    input = digest.digest(input);
			}
			hash = Base64.encodeBase64String(input);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			LOG.error("getHashPassword: ", e);
			throw new ErrorFiandeiraException(e, TipoError.USUARIO_ERROR_GENERAR_PASSWORD);
		}

		return hash;
	}

}
