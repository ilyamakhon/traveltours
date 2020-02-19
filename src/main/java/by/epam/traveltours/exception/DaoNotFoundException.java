package by.epam.traveltours.exception;

public class DaoNotFoundException extends RuntimeException {

    public DaoNotFoundException() {}

    public DaoNotFoundException(String message) {
        super(message);
    }
}
