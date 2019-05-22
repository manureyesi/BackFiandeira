package es.fiandeira.token.vo;

public class TokenVO {

	private final String token;
	private final Long fechaExpiracion;
	private final Long horasValidezToken;
	private final String tokenRefresco;
	private final Long fechaExpiracionTokenRefresco;
	
	public TokenVO(String token, Long fechaExpiracion, Long horasValidezToken, String tokenRefresco, Long fechaExpiracionTokenRefresco) {
		this.token = token;
		this.fechaExpiracion = fechaExpiracion;
		this.horasValidezToken = horasValidezToken;
		this.tokenRefresco = tokenRefresco;
		this.fechaExpiracionTokenRefresco = fechaExpiracionTokenRefresco;
	}

	public String getToken() {
		return token;
	}

	public Long getFechaExpiracion() {
		return fechaExpiracion;
	}
	
	public Long getHorasValidezToken() {
		return horasValidezToken;
	}

	public String getTokenRefresco() {
		return tokenRefresco;
	}

	public Long getFechaExpiracionTokenRefresco() {
		return fechaExpiracionTokenRefresco;
	}
	
}
