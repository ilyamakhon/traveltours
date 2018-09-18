package by.makhon.travelvouchers;

import by.makhon.travelvouchers.bean.Tour;
import by.makhon.travelvouchers.dao.TourDAOImpl;
import by.makhon.travelvouchers.services.TourService;
import by.makhon.travelvouchers.services.TourServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private TourDAOImpl tourService;

    public void test() {
        List<Tour> tourList = new ArrayList<Tour>();

        tourService.setUpTours();
        tourList = tourService.getAllTours();

        for (Tour tour: tourList) {
            System.out.println(tour.toString());
        }
    }
}
