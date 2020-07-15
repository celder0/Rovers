package exceptions;

import java.io.FileNotFoundException;

public class ApplicationLoadException extends Exception {

    public ApplicationLoadException(Exception e) {
        super(e);
    }
}
