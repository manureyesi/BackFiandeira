package es.fiandeira.exception;

public class ErrorFiandeiraException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final TipoError tipoError;

	public ErrorFiandeiraException(final TipoError tipoError){
        this.tipoError = tipoError;
    }
	
	public ErrorFiandeiraException(final String message, final TipoError tipoError){
        super(message);
        this.tipoError = tipoError;
    }

	public ErrorFiandeiraException(final Exception e, final TipoError tipoError){
        super(e);
        this.tipoError = tipoError;
    }

	public ErrorFiandeiraException(final String message, final Exception e, final TipoError codError){
        super(message, e);
        this.tipoError = codError;
    }

	public int getCodigoError() {
		return this.tipoError.getCodigo();
	}

	public String getDescripcionError() {
		return this.tipoError.getDescripcion();
	}
	
}
