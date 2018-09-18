package by.epam.traveltours.dao;

import by.epam.traveltours.bean.Tour;

import java.util.List;

public interface TourDAO {
    List<Tour> getAllTours();
    List<Tour> filterToursByType(Tour filterBy);
    List<Tour> filterToursByAmountOfDays(short amountOfDays);
    List<Tour> filterToursByTypeOfFood();
    List<Tour> filterToursByTypeOfTransport();
    List<Tour> sortToursByType();
    List<Tour> sortToursByTourId();
    List<Tour> sortToursByPrice();
}