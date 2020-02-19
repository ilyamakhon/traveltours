package by.epam.traveltours.services;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.dao.internaldao.LocalTourDAO;
import by.epam.traveltours.validator.TourCriteriaValidator;

import java.util.List;

public class TourServiceImpl implements TourService {

    private static final TourServiceImpl INSTANCE = new TourServiceImpl();

    public static TourServiceImpl getInstance() {
        return INSTANCE;
    }

    private LocalTourDAO localTourDAO = LocalTourDAO.getInstance();
    private TourCriteriaValidator criteriaValidator = TourCriteriaValidator.getInstance();

    private TourServiceImpl() {
    }

    @Override
    public List<Tour> findTours(TourCriteria tourCriteria) {
        if (tourCriteria == null) {
            tourCriteria = new TourCriteria();
        }

        criteriaValidator.validate(tourCriteria);

        return localTourDAO.findTours(tourCriteria);
    }
}
