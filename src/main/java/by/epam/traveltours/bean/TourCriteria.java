package by.epam.traveltours.bean;

import java.util.List;
import java.util.Objects;

public class TourCriteria {

    public enum SortField {
        PRICE, AMOUNT_OF_DAYS
    }

    private List<Tour.TourType> tourType;
    private Float minPrice;
    private Float maxPrice;
    private List<Tour.TransportType> transportType;
    private List<Tour.TypeOfFood> typeOfFood;
    private Integer minAmountOfDays;
    private Integer maxAmountOfDays;
    private SortField sortField;

    public List<Tour.TourType> getTourType() {
        return tourType;
    }

    public void setTourType(List<Tour.TourType> tourType) {
        this.tourType = tourType;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<Tour.TransportType> getTransportType() {
        return transportType;
    }

    public void setTransportType(List<Tour.TransportType> transportType) {
        this.transportType = transportType;
    }

    public List<Tour.TypeOfFood> getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(List<Tour.TypeOfFood> typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public Integer getMinAmountOfDays() {
        return minAmountOfDays;
    }

    public void setMinAmountOfDays(Integer minAmountOfDays) {
        this.minAmountOfDays = minAmountOfDays;
    }

    public Integer getMaxAmountOfDays() {
        return maxAmountOfDays;
    }

    public void setMaxAmountOfDays(Integer maxAmountOfDays) {
        this.maxAmountOfDays = maxAmountOfDays;
    }

    public SortField getSortField() {
        return sortField;
    }

    public void setSortField(SortField sortField) {
        this.sortField = sortField;
    }

    public static class Builder {
        private TourCriteria tourCriteria = new TourCriteria();

        public static Builder create() {
            return new Builder();
        }

        public Builder withTourTypes(List<Tour.TourType> tourType) {
            tourCriteria.tourType = tourType;
            return this;
        }

        public Builder withPrices(Float minPrice, Float maxPrice) {
            tourCriteria.minPrice = minPrice;
            tourCriteria.maxPrice = maxPrice;
            return this;
        }

        public Builder withTransportType(List<Tour.TransportType> transportType) {
            tourCriteria.transportType = transportType;
            return this;
        }

        public Builder withTypeOfFood(List<Tour.TypeOfFood> typeOfFood) {
            tourCriteria.typeOfFood = typeOfFood;
            return this;
        }

        public Builder withAmountsOfDays(Integer minDays, Integer maxDays) {
            tourCriteria.minAmountOfDays = minDays;
            tourCriteria.maxAmountOfDays = maxDays;
            return this;
        }

        public Builder withSortField(SortField sortField) {
            tourCriteria.sortField = sortField;
            return this;
        }

        public TourCriteria build() {
            return tourCriteria;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourCriteria that = (TourCriteria) o;
        return Objects.equals(tourType, that.tourType) &&
                Objects.equals(minPrice, that.minPrice) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(transportType, that.transportType) &&
                Objects.equals(typeOfFood, that.typeOfFood) &&
                Objects.equals(minAmountOfDays, that.minAmountOfDays) &&
                Objects.equals(maxAmountOfDays, that.maxAmountOfDays) &&
                sortField == that.sortField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourType, minPrice, maxPrice, transportType, typeOfFood, minAmountOfDays, maxAmountOfDays, sortField);
    }
}
