package UI;

import carsProcessor.CarsList;

import java.util.Scanner;

public interface CarsFunctions {
    void printAllCars(CarsList cars);
    void addNewCar(CarsList cars, Scanner scanner);
    void deleteElementById(CarsList cars, Scanner scanner);
    void printCarOfTheSameModel(CarsList cars, Scanner scanner);
    void printModelInUseMoreThenYears(CarsList cars, Scanner scanner);
    void printReleaseYearWithPriceMoreThen(CarsList cars, Scanner scanner);
    void sortByPrice(CarsList cars, Scanner scanner);
    void createCarsArray(CarsList cars);
}