package es.fiandeira.token.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TokenVO {

	private final String token;
	private final Long fechaExpiracion;
	private final Long horasValidezToken;
	private final String tokenRefresco;
	private final Long fechaExpiracionTokenRefresco;
	
	/**
	 * TokenVO
	 * @param token
	 * @param fechaExpiracion
	 * @param horasValidezToken
	 * @param tokenRefresco
	 * @param fechaExpiracionTokenRefresco
	 */
	public TokenVO(String token, Long fechaExpiracion, Long horasValidezToken, String tokenRefresco,
			Long fechaExpiracionTokenRefresco) {
		this.token = token;
		this.fechaExpiracion = fechaExpiracion;
		this.horasValidezToken = horasValidezToken;
		this.tokenRefresco = tokenRefresco;
		this.fechaExpiracionTokenRefresco = fechaExpiracionTokenRefresco;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * @return the fechaExpiracion
	 */
	public Long getFechaExpiracion() {
		return fechaExpiracion;
	}

	/**
	 * @return the horasValidezToken
	 */
	public Long getHorasValidezToken() {
		return horasValidezToken;
	}

	/**
	 * @return the tokenRefresco
	 */
	public String getTokenRefresco() {
		return tokenRefresco;
	}

	/**
	 * @return the fechaExpiracionTokenRefresco
	 */
	public Long getFechaExpiracionTokenRefresco() {
		return fechaExpiracionTokenRefresco;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
