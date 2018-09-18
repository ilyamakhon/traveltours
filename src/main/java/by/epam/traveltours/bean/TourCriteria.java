package by.epam.traveltours.bean;

import java.util.List;
import java.util.Objects;

public class TourCriteria {

    public enum SortField {
        PRICE, AMOUNT_OF_DAYS
    }

    private List<Tour.TourType> tourTypes;
    private Float minPrice;
    private Float maxPrice;
    private List<Tour.TransportType> transportTypes;
    private List<Tour.TypeOfFood> typesOfFood;
    private Integer minAmountOfDays;
    private Integer maxAmountOfDays;
    private SortField sortField;

    public List<Tour.TourType> getTourTypes() {
        return tourTypes;
    }

    public void setTourTypes(List<Tour.TourType> tourTypes) {
        this.tourTypes = tourTypes;
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

    public List<Tour.TransportType> getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(List<Tour.TransportType> transportTypes) {
        this.transportTypes = transportTypes;
    }

    public List<Tour.TypeOfFood> getTypesOfFood() {
        return typesOfFood;
    }

    public void setTypesOfFood(List<Tour.TypeOfFood> typesOfFood) {
        this.typesOfFood = typesOfFood;
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
            tourCriteria.tourTypes = tourType;
            return this;
        }

        public Builder withPrices(Float minPrice, Float maxPrice) {
            tourCriteria.minPrice = minPrice;
            tourCriteria.maxPrice = maxPrice;
            return this;
        }

        public Builder withTransportType(List<Tour.TransportType> transportType) {
            tourCriteria.transportTypes = transportType;
            return this;
        }

        public Builder withTypeOfFood(List<Tour.TypeOfFood> typeOfFood) {
            tourCriteria.typesOfFood = typeOfFood;
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
        return Objects.equals(tourTypes, that.tourTypes) &&
                Objects.equals(minPrice, that.minPrice) &&
                Objects.equals(maxPrice, that.maxPrice) &&
                Objects.equals(transportTypes, that.transportTypes) &&
                Objects.equals(typesOfFood, that.typesOfFood) &&
                Objects.equals(minAmountOfDays, that.minAmountOfDays) &&
                Objects.equals(maxAmountOfDays, that.maxAmountOfDays) &&
                sortField == that.sortField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourTypes, minPrice, maxPrice, transportTypes, typesOfFood, minAmountOfDays, maxAmountOfDays, sortField);
    }

    @Override
    public String toString() {
        return "TourCriteria{" +
                "tourTypes=" + tourTypes +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", transportTypes=" + transportTypes +
                ", typesOfFood=" + typesOfFood +
                ", minAmountOfDays=" + minAmountOfDays +
                ", maxAmountOfDays=" + maxAmountOfDays +
                ", sortField=" + sortField +
                '}';
    }
}
