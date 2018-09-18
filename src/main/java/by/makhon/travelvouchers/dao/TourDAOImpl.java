package by.makhon.travelvouchers.dao;

import by.makhon.travelvouchers.bean.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourDAOImpl implements TourDAO {

    private List<Tour> tourList;
    public void setUpTours() {
        tourList = new ArrayList<Tour>();
        tourList.add(new Tour(1L, Tour.TourType.REST,1150, Tour.TransportType.BUS, Tour.TypeOfFood.BREAKFAST, (short) 7));
        tourList.add(new Tour(2L, Tour.TourType.REST,1550, Tour.TransportType.TRAIN, Tour.TypeOfFood.BREAKFAST_AND_DINNER, (short) 11));
        tourList.add(new Tour(3L, Tour.TourType.REST,1950, Tour.TransportType.PLANE, Tour.TypeOfFood.ALL_INCLUSIVE, (short) 14));

        tourList.add(new Tour(4L, Tour.TourType.THERAPEUTIC,2780, Tour.TransportType.BUS, Tour.TypeOfFood.BREAKFAST, (short) 7));
        tourList.add(new Tour(5L, Tour.TourType.THERAPEUTIC,3180, Tour.TransportType.TRAIN, Tour.TypeOfFood.BREAKFAST_AND_DINNER, (short) 11));
        tourList.add(new Tour(6L, Tour.TourType.THERAPEUTIC,4520, Tour.TransportType.PLANE, Tour.TypeOfFood.ALL_INCLUSIVE, (short) 14));

        tourList.add(new Tour(7L, Tour.TourType.EXCURSION,780, Tour.TransportType.BUS, Tour.TypeOfFood.BREAKFAST, (short) 7));
        tourList.add(new Tour(8L, Tour.TourType.EXCURSION,950, Tour.TransportType.TRAIN, Tour.TypeOfFood.BREAKFAST_AND_DINNER, (short) 11));
        tourList.add(new Tour(9L, Tour.TourType.EXCURSION,1300, Tour.TransportType.PLANE, Tour.TypeOfFood.ALL_INCLUSIVE, (short) 14));


        tourList.add(new Tour(7L, Tour.TourType.SHOPPING,1900, Tour.TransportType.BUS, Tour.TypeOfFood.BREAKFAST, (short) 7));
        tourList.add(new Tour(8L, Tour.TourType.SHOPPING,2200, Tour.TransportType.TRAIN, Tour.TypeOfFood.BREAKFAST_AND_DINNER, (short) 11));
        tourList.add(new Tour(9L, Tour.TourType.SHOPPING,2650, Tour.TransportType.PLANE, Tour.TypeOfFood.ALL_INCLUSIVE, (short) 14));

        tourList.add(new Tour(10L, Tour.TourType.CRUISE,1750, Tour.TransportType.BUS, Tour.TypeOfFood.BREAKFAST, (short) 7));
        tourList.add(new Tour(11L, Tour.TourType.CRUISE,2250, Tour.TransportType.TRAIN, Tour.TypeOfFood.BREAKFAST_AND_DINNER, (short) 11));
        tourList.add(new Tour(12L, Tour.TourType.CRUISE,2700, Tour.TransportType.PLANE, Tour.TypeOfFood.ALL_INCLUSIVE, (short) 14));
    }

    public List<Tour> getAllTours() {
        return tourList;
    }

    public List<Tour> filterToursByType(Tour filterBy) {
        List<Tour> filteredByTypeTours = new ArrayList<Tour>();
        for (Tour tour : tourList) {
            if (tour.tourType.equals(filterBy.tourType)){
                filteredByTypeTours.add(tour);
            }
        }
        if (tourList.isEmpty()) {
            System.out.println("There are no tours with type " + filterBy.tourType);
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

}
