package by.epam.traveltours;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.services.TourService;

import java.util.Collections;
import java.util.List;

public class Main {
    private static TourService TOUR_SERVICE = TourService.getInstance();
    public static void main(String[] args) {
        TourCriteria tourCriteria = TourCriteria.Builder.create().withTypeOfFood(Collections.singletonList(Tour.TypeOfFood.BREAKFAST)).build();
        List<Tour> tours = TOUR_SERVICE.findTours(tourCriteria);
        for (Tour tour : tours) {
            System.out.println(tour.toString());
        }
    }
}
