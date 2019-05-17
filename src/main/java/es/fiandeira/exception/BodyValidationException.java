package es.fiandeira.exception;

public class BodyValidationException extends ErrorFiandeiraException {

	private static final long serialVersionUID = 1L;
	
	final TipoError tipoError;
	
	public BodyValidationException(final String message, final TipoError tipoError){
        super(tipoError);
        this.tipoError = tipoError;
    }
		
	public String getMensaje() {
		return super.getMessage();
	}
	
	public int getCodigoError() {
		return this.tipoError.getCodigo();
	}
	
}
