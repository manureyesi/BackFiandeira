package es.fiandeira.vo;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResultadoVO [appConsumidor=");
		builder.append(appConsumidor);
		builder.append(", codError=");
		builder.append(codError);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}
	
}
