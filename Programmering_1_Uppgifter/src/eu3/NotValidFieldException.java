package eu3;

public class NotValidFieldException extends RuntimeException {
	public NotValidFieldException() {
		super();
	}
	
	public NotValidFieldException(String message) {
		super(message);
	}
}