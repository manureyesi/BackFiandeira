package es.fiandeira.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResultadoRespuestaVO {

	private ResultadoVO resultado;

	/**
	 * ResultadoRespuestaVO
	 */
	public ResultadoRespuestaVO() {
	}

	/**
	 * ResultadoRespuestaVO
	 * @param resultado
	 */
	public ResultadoRespuestaVO(ResultadoVO resultado) {
		this.resultado = resultado;
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
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}
