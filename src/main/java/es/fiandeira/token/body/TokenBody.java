package es.fiandeira.token.body;

import org.apache.commons.lang3.StringUtils;

import es.fiandeira.exception.BodyValidationException;
import es.fiandeira.exception.TipoError;

public class TokenBody {

	private final String correo;
	private final String contrasena;
	private final String idApp;
	private final String ip;
	private final Integer horasValidez;
	
	/**
	 * @param correo
	 * @param contrasena
	 * @param idApp
	 * @param ip
	 * @param horasValidez
	 */
	public TokenBody(String correo, String contrasena, String idApp, String ip, Integer horasValidez) {
		this.correo = correo;
		this.contrasena = contrasena;
		this.idApp = idApp;
		this.ip = ip;
		this.horasValidez = horasValidez;
	}
	
	/**
	 * Comprobar campos obligatorios llamada servicio
	 * @throws BodyValidationException 
	 */
	public void comprobarCamposObligatorios () throws BodyValidationException {
		if (StringUtils.isBlank(this.correo) || StringUtils.isBlank(this.contrasena) 
				|| StringUtils.isBlank(this.ip) || StringUtils.isBlank(this.idApp)) {
			throw new BodyValidationException("Error, campos obligatorios Body", TipoError.ERROR_BODY);
		}
	}
	
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @return the idApp
	 */
	public String getIdApp() {
		return idApp;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @return the horasValidez
	 */
	public Integer getHorasValidez() {
		return horasValidez;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenBody [correo=");
		builder.append(correo);
		builder.append(", contrasena=");
		builder.append(contrasena);
		builder.append(", idApp=");
		builder.append(idApp);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", horasValidez=");
		builder.append(horasValidez);
		builder.append("]");
		return builder.toString();
	}
	
}
