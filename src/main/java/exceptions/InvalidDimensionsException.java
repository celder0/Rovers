package exceptions;

public class InvalidDimensionsException extends Exception{
    public InvalidDimensionsException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }
}
