/**
 * 
 */
package es.fiandeira.usuario.utiles;

import es.fiandeira.exception.ErrorFiandeiraException;

/**
 * @author mreyesi
 *
 */
public interface IContrasenaUtiles {

	/**
    * Con una pass y un salt genera el hash correspondiente en Base64
    * @param contrasena String la contraseña a encriptar en UTF-8
    * @param salt String el salt en base64
    * @return String el hash en base64
    * @throws ErrorFiandeiraException
    */
	public String cifrarContrasenaBase64 (String contrasena, String salt) throws ErrorFiandeiraException;

	/**
	 * Genera un Salt aleatorio
	 * @return String el salt en base64
	 * @throws ErrorFiandeiraException
	 */
	public String generarSaltAleatorio() throws ErrorFiandeiraException;
	
}
