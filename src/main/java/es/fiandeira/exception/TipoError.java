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
	//Usuario Error
	USUARIO_ERROR_NO_ENCONTRADO(110, "No se ha podido encontrar enformacion del Usuario"),
	USUARIO_ERROR(111, "Usuario o contraseña no validos");

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
