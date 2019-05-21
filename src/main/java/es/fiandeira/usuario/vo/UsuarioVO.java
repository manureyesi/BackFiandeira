package es.fiandeira.usuario.vo;

public class UsuarioVO {

	private final Long id;
	private final String correo;
	private final String nombre;
	private final String apellidos;
	
	/**
	 * @param id
	 * @param correo
	 * @param nombre
	 * @param apellidos
	 */
	public UsuarioVO(Long id, String correo, String nombre, String apellidos) {
		this.id = id;
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
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
		builder.append("]");
		return builder.toString();
	}
	
}
