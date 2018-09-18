package by.epam.traveltours.services;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.dao.TourDAO;

import java.util.List;

public class TourServiceImpl implements TourService {

    private TourDAO tourDAO;

    public void setUpTours() {
        tourDAO.setUpTours();
    }

    public List<Tour> getAllTours() {
        return tourDAO.getAllTours();
    }

    public List<Tour> filterToursByType(Tour filterBy) {
        return tourDAO.filterToursByType(filterBy);
    }

    public List<Tour> filterToursByAmountOfDays(short amountOfDays) {
        return null;
    }

    public List<Tour> filterToursByTypeOfFood() {
        return null;
    }

    public List<Tour> filterToursByTypeOfTransport() {
        return null;
    }

    public List<Tour> sortToursByPrice() {
        return null;
    }

    public List<Tour> sortToursByType() {
        return null;
    }

    public List<Tour> sortToursByTourId() {
        return null;
    }


}