package by.epam.traveltours.dao;

import by.epam.traveltours.bean.Tour;

import java.util.ArrayList;
import java.util.List;

import static by.epam.traveltours.bean.Tour.TourType.CRUISE;
import static by.epam.traveltours.bean.Tour.TourType.EXCURSION;
import static by.epam.traveltours.bean.Tour.TourType.REST;
import static by.epam.traveltours.bean.Tour.TourType.SHOPPING;
import static by.epam.traveltours.bean.Tour.TourType.THERAPEUTIC;
import static by.epam.traveltours.bean.Tour.TransportType.BUS;
import static by.epam.traveltours.bean.Tour.TransportType.PLANE;
import static by.epam.traveltours.bean.Tour.TransportType.TRAIN;
import static by.epam.traveltours.bean.Tour.TypeOfFood.ALL_INCLUSIVE;
import static by.epam.traveltours.bean.Tour.TypeOfFood.BREAKFAST;
import static by.epam.traveltours.bean.Tour.TypeOfFood.BREAKFAST_AND_DINNER;
import static java.util.Arrays.asList;

public class TourDAOImpl implements TourDAO {

    private List<Tour> tourList = asList(
            buildTour(1L, REST,1150F, BUS, BREAKFAST,7),
            buildTour(2L, REST,1550F, TRAIN, BREAKFAST_AND_DINNER,11),
            buildTour(3L, REST,1950F, PLANE, ALL_INCLUSIVE,14),
            buildTour(4L, THERAPEUTIC,2780F, BUS, BREAKFAST,7),
            buildTour(5L, THERAPEUTIC,3180F, TRAIN, BREAKFAST_AND_DINNER, 11),
            buildTour(6L, THERAPEUTIC,4520F, PLANE, ALL_INCLUSIVE, 14),
            buildTour(7L, EXCURSION,780F, BUS, BREAKFAST, 7),
            buildTour(8L, EXCURSION,950F, TRAIN, BREAKFAST_AND_DINNER,11),
            buildTour(9L, EXCURSION,1300F, PLANE, ALL_INCLUSIVE, 14),
            buildTour(10L, SHOPPING,1900F, BUS, BREAKFAST, 7),
            buildTour(11L, SHOPPING,2200F, TRAIN, BREAKFAST_AND_DINNER, 11),
            buildTour(12L, SHOPPING,2650F, PLANE, ALL_INCLUSIVE, 14),
            buildTour(13L, CRUISE,1750F, BUS, BREAKFAST, 7),
            buildTour(14L, CRUISE,2250F, TRAIN, BREAKFAST_AND_DINNER, 11),
            buildTour(15L, CRUISE,2700F, PLANE, ALL_INCLUSIVE, 14)
    );

    public List<Tour> getAllTours() {
        return tourList;
    }

    public List<Tour> filterToursByType(Tour filterBy) {
        List<Tour> filteredByTypeTours = new ArrayList<Tour>();
        for (Tour tour : tourList) {
            if (tour.getTourType().equals(filterBy.getTourType())){
                filteredByTypeTours.add(tour);
            }
        }
        if (tourList.isEmpty()) {
            System.out.println("There are no tours with type " + filterBy.getTourType());
        }

        return filteredByTypeTours;
    }

    public List<Tour> filterToursByAmountOfDays(short amountOfDays) {
        if (amountOfDays == 7 || amountOfDays == 11 || amountOfDays == 14) {
            List<Tour> filteredToursByAmountOfDays = new ArrayList<Tour>();
            for (Tour tour : tourList) {
                if (tour.getAmountOfDays() == amountOfDays) {
                    filteredToursByAmountOfDays.add(tour);
                }
            }
            if (tourList.isEmpty()) {
                System.out.println("There are no tours with amount of days " + amountOfDays);
                return null;
            }
            return filteredToursByAmountOfDays;
        }
        System.out.println("The duration of tour can be only 7, 11, 14 days! ");
        return null;
    }

    public List<Tour> filterToursByTypeOfFood() {
        return null;
    }

    public List<Tour> filterToursByTypeOfTransport() {
        return null;
    }

    public List<Tour> sortToursByType() {
        return null;
    }

    public List<Tour> sortToursByTourId() {
        return null;
    }

    public List<Tour> sortToursByPrice() {
        return null;
    }

    private Tour buildTour(Long tourId, Tour.TourType tourType, Float price,
                           Tour.TransportType transportType, Tour.TypeOfFood typeOfFood, int amountOfDays) {

        return Tour.Builder.create()
                .withTourId(tourId)
                .withTourType(tourType)
                .withPrice(price)
                .withTransportType(transportType)
                .withTypeOfFood(typeOfFood)
                .withAmountOfDays(amountOfDays)
                .build();
    }

}
