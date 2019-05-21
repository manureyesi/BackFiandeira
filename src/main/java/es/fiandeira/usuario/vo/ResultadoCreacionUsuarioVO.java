package es.fiandeira.usuario.vo;

import es.fiandeira.vo.ResultadoVO;

public class ResultadoCreacionUsuarioVO {

	private final UsuarioVO usuario;
	private final ResultadoVO resultado;
	
	/**
	 * @param usuario
	 * @param resultado
	 */
	public ResultadoCreacionUsuarioVO(UsuarioVO usuario, ResultadoVO resultado) {
		this.usuario = usuario;
		this.resultado = resultado;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioVO getUsuario() {
		return usuario;
	}

	/**
	 * @return the resultado
	 */
	public ResultadoVO getResultado() {
		return resultado;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResultadoCreacionUsuarioVO [usuario=");
		builder.append(usuario);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append("]");
		return builder.toString();
	}

}
