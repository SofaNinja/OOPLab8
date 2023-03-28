package carsProcessor;

import java.io.Serializable;
import java.util.Objects;


public class Car implements Serializable, Comparable<Car> {
    private int id;
    private String model;
    private int releaseYear;
    private int price;
    private String registrationNumber;

    public Car(int id, String model, int releaseYear, int price, String registrationNumber) {
        this.id = id;
        this.model = model;
        this.releaseYear = releaseYear;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public void setID(int id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    public void setPrice(int price) { this.price = price; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }
    public int getId() { return id; }
    public String getModel() { return model; }
    public int getReleaseYear() { return releaseYear; }
    public int getPrice() { return price; }
    public String getRegistrationNumber() { return registrationNumber; }

    @Override
    public String toString() {
        return
                id + ", Model = " + model + ", Year = " + releaseYear + ", Price = "
                        + price + ", Registration number = " + registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return
                id == car.id &&
                        Objects.equals(model, car.model) &&
                        releaseYear == car.releaseYear &&
                        price == car.price &&
                        Objects.equals(registrationNumber, car.registrationNumber);
    }
    public int compareTo(Car o) { return Integer.compare(price, o.getPrice()); }
}