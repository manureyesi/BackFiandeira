package es.fiandeira.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResultadoVO {

	private final String appConsumidor;
	private final Integer codError;
	private final String descripcion;
	
	/**
	 * @param appConsumidor
	 * @param codError
	 * @param descripcion
	 */
	public ResultadoVO(String appConsumidor, Integer codError, String descripcion) {
		this.appConsumidor = appConsumidor;
		this.codError = codError;
		this.descripcion = descripcion;
	}

	/**
	 * @return the appConsumidor
	 */
	public String getAppConsumidor() {
		return appConsumidor;
	}

	/**
	 * @return the codError
	 */
	public Integer getCodError() {
		return codError;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
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
