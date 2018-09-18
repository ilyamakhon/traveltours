package by.epam.traveltours;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.dao.TourDAOImpl;

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
