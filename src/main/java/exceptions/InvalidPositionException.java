package exceptions;

public class InvalidPositionException extends Exception {
    public InvalidPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPositionException(String message) {
        super(message);
    }
}
