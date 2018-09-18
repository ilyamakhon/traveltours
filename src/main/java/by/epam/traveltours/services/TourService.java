package by.epam.traveltours.services;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;

import java.util.List;

public interface TourService {

    static TourService getInstance() {
        return TourServiceImpl.getInstance();
    }

    List<Tour> findTours(TourCriteria tourCriteria);
}
