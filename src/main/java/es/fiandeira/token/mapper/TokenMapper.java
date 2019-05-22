package es.fiandeira.token.mapper;

import es.fiandeira.token.models.Token;
import es.fiandeira.token.vo.TokenVO;

public class TokenMapper {

	/**
	 * Mappear Token DB to Token VO
	 *
	 * @param token
	 * @return TokenVO
	 */
	public static TokenVO mapperUsuarioToUsuarioVO (final Token token) {
		return new TokenVO(
				token.getToken(),
				token.getFechaExpiracion().getTime(),
				Long.valueOf(token.getHorasValidez()),
				token.getTokenRefresco(),
				token.getFechaExpiracionTokenRefresco().getTime());
	}
	
}
