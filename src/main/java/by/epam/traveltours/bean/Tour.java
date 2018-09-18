package by.epam.traveltours.bean;

import java.io.Serializable;
import java.util.Objects;

public class Tour implements Serializable {

    private static final long serialVersionUID = 1889581583218754321L;

    public enum TourType {
        REST, THERAPEUTIC, EXCURSION, SHOPPING, CRUISE
    }

    public enum TransportType {
        BUS, TRAIN, PLANE
    }

    public enum TypeOfFood {
        BREAKFAST, BREAKFAST_AND_DINNER, ALL_INCLUSIVE
    }

    private Long tourId;
    private TourType tourType;
    private Float price;
    private TransportType transportType;
    private TypeOfFood typeOfFood;
    private int amountOfDays;

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(TypeOfFood typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public int getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(int amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    public static class Builder {
        private Tour tour = new Tour();

        public static Builder create() {
            return new Builder();
        }

        public Builder withTourId(Long tourId) {
            tour.tourId = tourId;
            return this;
        }

        public Builder withTourType(TourType tourType) {
            tour.tourType = tourType;
            return this;
        }

        public Builder withPrice(Float price) {
            tour.price = price;
            return this;
        }

        public Builder withTransportType(TransportType transportType) {
            tour.transportType = transportType;
            return this;
        }

        public Builder withTypeOfFood(TypeOfFood typeOfFood) {
            tour.typeOfFood = typeOfFood;
            return this;
        }

        public Builder withAmountOfDays(int amountOfDays) {
            tour.amountOfDays = amountOfDays;
            return this;
        }

        public Tour build() {
            return tour;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return amountOfDays == tour.amountOfDays &&
                Objects.equals(tourId, tour.tourId) &&
                tourType == tour.tourType &&
                Objects.equals(price, tour.price) &&
                transportType == tour.transportType &&
                typeOfFood == tour.typeOfFood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourId, tourType, price, transportType, typeOfFood, amountOfDays);
    }
}
