package by.epam.traveltours.validator;

public enum ValidationError {
    MIN_PRICE_LESS_THAN_ZERO(1, "Min tour price less than zero"),
    MAX_PRICE_LESS_THAN_ZERO(2, "Max tour price less than zero"),
    MIN_PRICE_GREATER_THAN_MAX_PRICE(3, "Min price greater than max price"),
    MIN_DAYS_LESS_THAN_ZERO(4, "Min tour days less than zero"),
    MAX_DAYS_LESS_THAN_ZERO(5, "Max tour days less than zero"),
    MIN_DAYS_GREATER_THAN_MAX_DAYS(6, "Min days greater than max days");

    private int errorCode;
    private String message;

    ValidationError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
