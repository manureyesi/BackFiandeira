package es.fiandeira.token.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import es.fiandeira.usuario.vo.UsuarioVO;
import es.fiandeira.vo.ResultadoRespuestaVO;

public class TokenRespuestaVO extends ResultadoRespuestaVO {

	private UsuarioVO usuario;
	private TokenVO token;
	
	/**
	 * TokenRespuestaVO
	 */
	public TokenRespuestaVO() {
	}

	/**
	 * TokenRespuestaVO
	 * @param usuario
	 * @param token
	 */
	public TokenRespuestaVO(UsuarioVO usuario, TokenVO token) {
		this.usuario = usuario;
		this.token = token;
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
