package dukemarket.storage;

public class InvalidBundleException extends RuntimeException {

    public InvalidBundleException(String message) {
        super(message);
    }

    public InvalidBundleException(String message, Throwable cause) {
        super(message, cause);
    }
}
