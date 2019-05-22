package es.fiandeira.usuario.vo;

import java.util.List;

public class UsuarioVO {

	private final Long id;
	private final String correo;
	private final String nombre;
	private final String apellidos;
	private final List<RangoVO> listaRangos;
	
	/**
	 * @param id
	 * @param correo
	 * @param nombre
	 * @param apellidos
	 * @param listaRangos
	 */
	public UsuarioVO(Long id, String correo, String nombre, String apellidos, List<RangoVO> listaRangos) {
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.listaRangos = listaRangos;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return the listaRangos
	 */
	public List<RangoVO> getListaRangos() {
		return listaRangos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioVO [id=");
		builder.append(id);
		builder.append(", correo=");
		builder.append(correo);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", listaRangos=");
		builder.append(listaRangos);
		builder.append("]");
		return builder.toString();
	}
		
}
