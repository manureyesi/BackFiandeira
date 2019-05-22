package es.fiandeira.token.vo;

import es.fiandeira.usuario.vo.UsuarioVO;
import es.fiandeira.vo.ResultadoVO;

public class TokenRespuestaVO {

	private ResultadoVO resultado;
	private UsuarioVO usuario;
	private TokenVO token;
	
	
	
	/**
	 * 
	 */
	public TokenRespuestaVO() {
	}

	/**
	 * @param usuario
	 * @param token
	 */
	public TokenRespuestaVO(UsuarioVO usuario, TokenVO token) {
		this.usuario = usuario;
		this.token = token;
	}

	/**
	 * @param resultado
	 * @param usuario
	 * @param token
	 */
	public TokenRespuestaVO(ResultadoVO resultado, UsuarioVO usuario, TokenVO token) {
		this.resultado = resultado;
		this.usuario = usuario;
		this.token = token;
	}

	/**
	 * @return the resultado
	 */
	public ResultadoVO getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(ResultadoVO resultado) {
		this.resultado = resultado;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioVO getUsuario() {
		return usuario;
	}

	/**
	 * @return the token
	 */
	public TokenVO getToken() {
		return token;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenRespuestaVO [resultado=");
		builder.append(resultado);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}
	
}
