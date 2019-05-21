package es.fiandeira.usuario.body;

public class UsuarioBody {

	private final String nombre;
	private final String apellidos;
	private final String correo;
	private final String contrasena;
	
	/**
	 * UsuarioBody
	 * @param nombre
	 * @param apellidos
	 * @param correo
	 * @param contrasena
	 */
	public UsuarioBody(String nombre, String apellidos, String correo, String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioBody [nombre=");
		builder.append(nombre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", correo=");
		builder.append(correo);
		builder.append(", contrasena=");
		builder.append(contrasena);
		builder.append("]");
		return builder.toString();
	}
	
}
