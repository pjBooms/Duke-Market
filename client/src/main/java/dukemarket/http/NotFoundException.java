package dukemarket.http;

import org.restler.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    public final HttpStatus status;

    public NotFoundException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }
}
