package pl.jakubtrzcinski.garminconnect.exception;

/**
 * @author Jakub Trzcinski kuba@valueadd.pl
 * @since 26-12-2020
 */
public class AccountLockedGarminConnectException extends GarminConnectException {
    public AccountLockedGarminConnectException(String message) {
        super(message);
    }
}
