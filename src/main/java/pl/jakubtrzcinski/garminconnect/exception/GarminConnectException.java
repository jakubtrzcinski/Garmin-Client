package pl.jakubtrzcinski.garminconnect.exception;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
public abstract class GarminConnectException extends RuntimeException {
    public GarminConnectException() {
    }

    public GarminConnectException(String message) {
        super(message);
    }

    public GarminConnectException(String message, Throwable cause) {
        super(message, cause);
    }

    public GarminConnectException(Throwable cause) {
        super(cause);
    }

    public GarminConnectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
