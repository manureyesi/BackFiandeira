package es.fiandeira.usuario.vo;

public class RangoVO {

	private final Long idRango;
	private final String nombre;
	private final String descripcion;
	
	/**
	 * @param idRango
	 * @param nombre
	 * @param descripcion
	 */
	public RangoVO(Long idRango, String nombre, String descripcion) {
		this.idRango = idRango;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	/**
	 * @return the idRango
	 */
	public Long getIdRango() {
		return idRango;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
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
		builder.append("RangoVO [idRango=");
		builder.append(idRango);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append("]");
		return builder.toString();
	}
	
}
