package boulangerie.exception;

public class LigneCommandeException extends RuntimeException {
	public LigneCommandeException() {
		
	}
	
	public LigneCommandeException(String message) {
		super(message);
	}
}
