package UI;

import carsProcessor.CarsMap;

import java.util.Scanner;

public interface CarsFunctions {
    void createCarsArray(CarsMap cars);
    void printCarsMap(CarsMap cars);
    void addNewCar(CarsMap cars, Scanner scanner);
    void deleteElementById(CarsMap cars, Scanner scanner);
    void printCarOfTheSameModelByReleaseYear(CarsMap cars, Scanner scanner);
    void printModelInUseMoreThenYears(CarsMap cars, Scanner scanner);
    void printReleaseYearWithPriceMoreThen(CarsMap cars, Scanner scanner);
    void printSortByPrice(CarsMap cars);
    void printCarModels(CarsMap cars);
    void printCarsByModels(CarsMap cars);
}