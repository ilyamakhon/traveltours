package by.epam.traveltours;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.dao.externaldao.ExternalTourDAO;
import by.epam.traveltours.propertyloader.PropertyLoader;
import by.epam.traveltours.services.TourService;

import java.util.Collections;
import java.util.List;

public class Main {

    private static final String DAO_TYPE = PropertyLoader.loadProperty("type.of.dao");
    private static final String TRANSPORT_CRITERIA_TYPE = PropertyLoader.loadProperty("search.criteria.type");
    private static TourService TOUR_SERVICE = TourService.getInstance();

    public static void main(String[] args) {

        ExternalTourDAO dao = ExternalTourDAO.getDAO(DAO_TYPE);
        TourCriteria tourCriteria = TourService.getInstance().getCriteriaByType(TRANSPORT_CRITERIA_TYPE);
        List<Tour> tours = TOUR_SERVICE.findTours(tourCriteria);

        if (dao != null) {
            dao.saveTours(tours);
            dao.readTours();
        }
    }
}
