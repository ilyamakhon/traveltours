package by.epam.traveltours.services;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.dao.internaldao.LocalTourDAO;
import by.epam.traveltours.exception.TourCriteriaNotFoundException;
import by.epam.traveltours.validator.TourCriteriaValidator;

import java.util.Collections;
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

    @Override
    public TourCriteria getCriteriaByType(String criteriaType) {

        switch (criteriaType) {
            case "plane":
                return TourCriteria.Builder
                        .create()
                        .withTransportType(Collections.singletonList(Tour.TransportType.PLANE))
                        .build();
            case "train":
                return TourCriteria.Builder
                        .create()
                        .withTransportType(Collections.singletonList(Tour.TransportType.TRAIN))
                        .build();
            case "bus":
                return TourCriteria.Builder
                        .create()
                        .withTransportType(Collections.singletonList(Tour.TransportType.BUS))
                        .build();
        }

        throw new TourCriteriaNotFoundException("Wrong type for tour criteria : " + criteriaType + "\nPlease review application.properties file to find correct criteria types!");
    }
}
