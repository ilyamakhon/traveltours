package by.makhon.travelvouchers.services;

import by.makhon.travelvouchers.bean.Tour;

import java.util.List;

public interface TourService {
    void setUpTours();
    List<Tour> getAllTours();
    List<Tour> filterToursByType(Tour filterBy);
    List<Tour> filterToursByAmountOfDays(short amountOfDays);
    List<Tour> filterToursByTypeOfFood();
    List<Tour> filterToursByTypeOfTransport();
    List<Tour> sortToursByType();
    List<Tour> sortToursByTourId();
    List<Tour> sortToursByPrice();
}
