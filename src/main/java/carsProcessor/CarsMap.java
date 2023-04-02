package carsProcessor;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarsMap {
    private Map<Integer, Car> carMap = new HashMap<>();
    public CarsMap() {}
    public List<Car> getCars() { return new ArrayList<>(carMap.values()); }
    public void addCar(Car car) { carMap.put(car.getId(), car); }
    public void deleteById(int id){ carMap.remove(id); }
    public void printCarsOfTheSameModel(String model) {
        for (Car car : carMap.values()) {
            if (car.getModel().equals(model)) {
                System.out.println(car);
            }
        }
    }
    public void printModelInUseMoreThenYears(String model, int exploitationYears) {
        for (Car car : carMap.values()) {
            if (car.getModel().equals(model)) {
                if (((Year.now().getValue() - car.getReleaseYear()) > exploitationYears)) {
                    System.out.println(car);
                }
            }
        }
    }
    public void printReleaseYearWithPriceMoreThen(int releaseYear, int price) {
        for (Car car : carMap.values()) {
            if (car.getReleaseYear() == releaseYear) {
                if (car.getPrice() > price) {
                    System.out.println(car);
                }
            }
        }
    }
    public void printByModel(Map<String, List<Car>> productsByManufacturer) {
        for (Map.Entry<String, List<Car>> entry : productsByManufacturer.entrySet()) {
            List<Car> carsModel = entry.getValue();
            System.out.println("Модель: " + entry.getKey());
            for (Car car : carsModel) {
                System.out.println("\tid: " + car.getId() + ",\tРік випуску = " + car.getReleaseYear()
                        + ",\tЦіна = " + car.getPrice() + ",\tНомер = " + car.getRegistrationNumber());
            }
            System.out.println();
        }
    }
    public void formatCarsMapList(Map<Integer, Car> cars){ carMap = cars; }
}