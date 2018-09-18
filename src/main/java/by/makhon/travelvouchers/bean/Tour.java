package by.makhon.travelvouchers.bean;

public class Tour {
    public Long voucherId;

    public enum TourType {
        REST,
        THERAPEUTIC,
        EXCURSION,
        SHOPPING,
        CRUISE
    }
    public TourType tourType;

    public float price;

    public enum TransportType {
        BUS,
        TRAIN,
        PLANE
    }
    public TransportType transportType;

    public enum TypeOfFood {
        BREAKFAST,
        BREAKFAST_AND_DINNER,
        ALL_INCLUSIVE
    }
    public TypeOfFood typeOfFood;

    public short amountOfDays;

    public Tour(Long voucherId, TourType tourType, float price, TransportType transportType, TypeOfFood typeOfFood, short amountOfDays) {
        this.voucherId = voucherId;
        this.tourType = tourType;
        this.price = price;
        this.transportType = transportType;
        this.typeOfFood = typeOfFood;
        this.amountOfDays = amountOfDays;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public short getAmountOfDays() {
        return amountOfDays;
    }

    public void setAmountOfDays(short amountOfDays) {
        this.amountOfDays = amountOfDays;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "voucherId=" + voucherId +
                ", tourType=" + tourType +
                ", price=" + price +
                ", transportType=" + transportType +
                ", typeOfFood=" + typeOfFood +
                ", amountOfDays=" + amountOfDays +
                '}';
    }
}
