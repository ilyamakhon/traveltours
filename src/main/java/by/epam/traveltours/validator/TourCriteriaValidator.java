package by.epam.traveltours.validator;

import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.exception.TourValidationException;

public interface TourCriteriaValidator {

    static TourCriteriaValidator getInstance() {
        return TourCriteriaValidatorImpl.getInstance();
    }

    void validate(TourCriteria tourCriteria) throws TourValidationException;
}
