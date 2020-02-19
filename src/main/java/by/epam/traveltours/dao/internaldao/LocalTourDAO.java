package by.epam.traveltours.dao.internaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;

import java.util.List;

public interface LocalTourDAO {

    static LocalTourDAO getInstance() {
        return LocalTourDAOImpl.getInstance();
    }

    List<Tour> findTours(TourCriteria criteria);
}
