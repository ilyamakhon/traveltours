package by.epam.traveltours.exception;

import by.epam.traveltours.validator.ValidationError;

import java.util.List;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = -366831447885873292L;

    private List<ValidationError> validationErrors;

    public ValidationException(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
