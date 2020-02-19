package by.epam.traveltours.dao.internaldao;

import by.epam.traveltours.bean.Tour;
import by.epam.traveltours.bean.TourCriteria;
import by.epam.traveltours.storage.TourStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LocalTourDAOImpl implements LocalTourDAO {

    private static final LocalTourDAOImpl INSTANCE = new LocalTourDAOImpl();

    public static LocalTourDAOImpl getInstance() {
        return INSTANCE;
    }

    private List<Tour> tours = TourStorage.getInstance().getAllTours();

    private LocalTourDAOImpl() {
    }

    @Override
    public List<Tour> findTours(TourCriteria criteria) {
        if (criteria == null) {
            return tours;
        }

        List<Tour> foundTours = new ArrayList<>();
        for (Tour tour : tours) {
            if (matchesCriteria(tour, criteria)) {
                foundTours.add(tour);
            }
        }

        if (!foundTours.isEmpty()) {
            sortTours(foundTours, criteria);
        }

        return foundTours;
    }

    private boolean matchesCriteria(Tour tour, TourCriteria criteria) {
        List<Tour.TourType> criteriaTourType = criteria.getTourTypes();
        if (criteriaTourType != null && !criteriaTourType.isEmpty()) {
            Tour.TourType tourType = tour.getTourType();
            if (!criteriaTourType.contains(tourType)) {
                return false;
            }
        }

        Float minPrice = criteria.getMinPrice();
        if (minPrice != null) {
            Float tourPrice = tour.getPrice();
            if (tourPrice < minPrice) {
                return false;
            }
        }

        Float maxPrice = criteria.getMaxPrice();
        if (maxPrice != null) {
            Float tourPrice = tour.getPrice();
            if (tourPrice > maxPrice) {
                return false;
            }
        }

        List<Tour.TransportType> criteriaTransportType = criteria.getTransportTypes();
        if (criteriaTransportType != null && !criteriaTransportType.isEmpty()){
            Tour.TransportType transportType = tour.getTransportType();
            if (!criteriaTransportType.contains(transportType)) {
                return false;
            }
        }

        List<Tour.TypeOfFood> criteriaFoodType = criteria.getTypesOfFood();
        if (criteriaFoodType != null && !criteriaFoodType.isEmpty()){
            Tour.TypeOfFood typeOfFood = tour.getTypeOfFood();
            if (!criteriaFoodType.contains(typeOfFood)) {
                return false;
            }
        }

        Integer minDays = criteria.getMinAmountOfDays();
        if(minDays != null) {
            int amountOfDays = tour.getAmountOfDays();
            if (amountOfDays < minDays) {
                return false;
            }
        }

        Integer maxDays = criteria.getMaxAmountOfDays();
        if(maxDays != null) {
            int amountOfDays = tour.getAmountOfDays();
            return amountOfDays <= maxDays;
        }

        return true;
    }

    private void sortTours(List<Tour> tourList, TourCriteria criteria) {
        TourCriteria.SortField sortField = criteria.getSortField();
        Comparator<Tour> comparator;

        if (sortField != null) {
            switch (sortField) {
                case PRICE:
                    comparator = (tour1, tour2) -> {
                        Float tour1Price = tour1.getPrice();
                        Float tour2Price = tour2.getPrice();
                        return tour1Price.compareTo(tour2Price);
                    };
                    break;
                case AMOUNT_OF_DAYS:
                    comparator = (tour1, tour2) -> {
                        Integer tour1AmountOfDays = tour1.getAmountOfDays();
                        Integer tour2AmountOfDays = tour2.getAmountOfDays();
                        return tour1AmountOfDays.compareTo(tour2AmountOfDays);
                    };
                    break;
                default:
                    comparator = null;
                    break;
            }
            tourList.sort(comparator);
        }
    }
}
