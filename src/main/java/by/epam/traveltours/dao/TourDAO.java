package by.epam.traveltours.dao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;

import java.util.List;

public interface TourDAO {

    static TourDAO getInstance() {
        return TourDAOImpl.getInstance();
    }

    List<Tour> findTours(TourCriteria criteria);
}
