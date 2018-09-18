package by.epam.traveltours.validator;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class TourCriteriaValidatorImpl implements TourCriteriaValidator {

    private static final TourCriteriaValidatorImpl INSTANCE = new TourCriteriaValidatorImpl();

    public static TourCriteriaValidatorImpl getInstance() {
        return INSTANCE;
    }

    private TourCriteriaValidatorImpl() {
    }

    @Override
    public void validate(TourCriteria tourCriteria) {
        List<ValidationError> validationErrors = new ArrayList<>();

        Float minTourPrice = tourCriteria.getMinPrice();
        if (minTourPrice != null && minTourPrice < 0.0F) {
            validationErrors.add(ValidationError.MIN_PRICE_LESS_THAN_ZERO);
        }


        Float maxTourPrice = tourCriteria.getMaxPrice();
        if (maxTourPrice != null && maxTourPrice < 0.0F) {
            validationErrors.add(ValidationError.MAX_PRICE_LESS_THAN_ZERO);
        }
        if (minTourPrice != null && maxTourPrice != null) {
            if (minTourPrice > maxTourPrice) {
                validationErrors.add(ValidationError.MIN_PRICE_GREATER_THAN_MAX_PRICE);
            }
        }

        Integer minAmountOfDays = tourCriteria.getMinAmountOfDays();
        if (minAmountOfDays != null && minAmountOfDays < 0 ) {
            validationErrors.add(ValidationError.MIN_DAYS_LESS_THAN_ZERO);
        }

        Integer maxAmountOfDays = tourCriteria.getMaxAmountOfDays();
        if (maxAmountOfDays != null && maxAmountOfDays < 0) {
            validationErrors.add(ValidationError.MAX_DAYS_LESS_THAN_ZERO);
        }

        if (minAmountOfDays != null && maxAmountOfDays != null){
            if (minAmountOfDays > maxAmountOfDays) {
                validationErrors.add(ValidationError.MIN_DAYS_GREATER_THAN_MAX_DAYS);
            }
        }

        if (!validationErrors.isEmpty()) {
            throw new ValidationException(validationErrors);
        }
    }
}
