package by.epam.traveltours.exception;

import by.epam.traveltours.validator.ValidationError;

import java.util.List;

public class TourValidationException extends RuntimeException {

    private List<ValidationError> validationErrors;

    public TourValidationException(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
