package by.epam.traveltours;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.dao.externaldao.TourDAO;
import by.epam.traveltours.propertyloader.PropertyLoader;
import by.epam.traveltours.services.TourService;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final String DAO_TYPE = PropertyLoader.loadProperty("type.of.dao");
    private static TourService TOUR_SERVICE = TourService.getInstance();

    public static void main(String[] args) {
        TourDAO dao = TourDAO.getDAO(DAO_TYPE);
        TourCriteria tourCriteria = TourCriteria.Builder.create().withTransportType(Collections.singletonList(Tour.TransportType.BUS)).build();
        List<Tour> tours = TOUR_SERVICE.findTours(tourCriteria);

        if (dao != null) {
            dao.saveTours(tours);
            dao.readTours();
        }
    }


}
