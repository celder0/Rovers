package exceptions;

import java.io.FileNotFoundException;

public class ApplicationLoadException extends Exception {

    public ApplicationLoadException(FileNotFoundException e) {
        super(e);
    }
}
