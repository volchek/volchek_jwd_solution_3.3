package by.tr.web.service.exceptions;


public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
		
	
	public ServiceException() { }

	
	public ServiceException(String message) {
		super(message);
	}
	
	
	public ServiceException(Exception exception) {
		super(exception);
	}
	
	
	public ServiceException(String message, Exception exception) {
		super(message, exception);
	}
	
}
