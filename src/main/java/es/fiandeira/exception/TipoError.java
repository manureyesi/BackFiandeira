package es.fiandeira.exception;

public enum TipoError {

	OK(0, "OK"),
	ERROR(1, "Error Generico"),
	ERROR_HEADER(2, "Error validación de Header"),
	ERROR_PARSER_LONG(3, "Error al transformar datos"),
	ERROR_BODY(4, "Campos body obligatorios vacios"),
	//Token Error
	ERROR_TOKEN_CAMPOS_VACIOS(10, "Faltan campos obligatorios por informar"),
	ERROR_TOKEN_NO_EXISTE(11, "El Token pasado no existe"),
	ERROR_TOKEN_CADUCADO(12, "El Token esta caducado"),
	ERROR_TOKEN_GENERADO(13, "Error al generar Token Usuario"),
	//Usuario Error
	USUARIO_ERROR_REPETIDO(110, "Existe un usuario registrado con el mismo correo"),
	USUARIO_ERROR_GENERAR_PASSWORD(111, "Error al generar contraseña"),
	USUARIO_ERROR_NO_ENCONTRADO(112, "No se ha podido encontrar informacion del Usuario"),
	USUARIO_ERROR(113, "Usuario o contraseña no validos"),
	//Rangos error
	RANGOS_ERROR_NO_ASIGNADO(120, "El usuario no tiene asignado ningun rango");

	private final int codigo;
	private final String descripcion;
	
	private TipoError(final int codigo, final String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	@Override
	public String toString() {
		return codigo + ": " + descripcion;
	}
	
}
