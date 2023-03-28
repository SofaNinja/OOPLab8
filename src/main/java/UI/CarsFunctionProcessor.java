package UI;

import carsProcessor.Car;
import carsProcessor.CarsList;

import java.util.Scanner;

public class CarsFunctionProcessor implements CarsFunctions {
    public void printAllCars(CarsList cars) {
        System.out.println(cars.getSize());
        System.out.println(cars);
    }
    public void addNewCar(CarsList cars, Scanner scanner){
        System.out.println("Enter id >> ");
        int id = scanner.nextInt();
        System.out.println("Enter model >> ");
        scanner.nextLine();
        String model = scanner.next();
        System.out.println("Enter release year >> ");
        int releaseYear = scanner.nextInt();
        System.out.println("Enter price >> ");
        int price = scanner.nextInt();
        System.out.println("Enter registration number >> ");
        scanner.nextLine();
        String registrationNumber = scanner.next();
        cars.addCar(new Car(id, model, releaseYear, price, registrationNumber));
    }
    public void deleteElementById(CarsList cars, Scanner scanner){
        System.out.println("Enter id >> ");
        int id = scanner.nextInt();
        cars.deleteById(id);
    }
    public void printCarOfTheSameModel(CarsList cars, Scanner scanner) {
        System.out.println("Enter model of cars >> ");
        String model = scanner.next();

        cars.printCarsOfTheSameModel(model);
    }
    public void printModelInUseMoreThenYears(CarsList cars, Scanner scanner) {
        System.out.println("Enter model >> ");
        String model = scanner.next();
        System.out.println("Enter years in use >> ");
        int exploitationYears = scanner.nextInt();

        cars.printModelInUseMoreThenYears(model, exploitationYears);
    }
    public void printReleaseYearWithPriceMoreThen(CarsList cars, Scanner scanner) {
        System.out.println("Enter release year >> ");
        int releaseYear =  scanner.nextInt();
        System.out.println("Enter price >> ");
        int price = scanner.nextInt();

        cars.printReleaseYearWithPriceMoreThen(releaseYear, price);
    }
    public void sortByPrice(CarsList cars, Scanner scanner){
        cars.sortByPrice();
        printAllCars(cars);
    }
    public void createCarsArray(CarsList cars) {
        cars.addCar(new Car(1, "Camry", 2015, 15000, "AA1234BB"));
        cars.addCar(new Car(2, "Corolla", 2018, 18000, "BC2345CD"));
        cars.addCar(new Car(3, "RAV4", 2016, 12000, "DE3456EF"));
        cars.addCar(new Car(4, "Highlander", 2017, 14000, "FG4567GH"));
        cars.addCar(new Car(5, "Prius", 2014, 10000, "HI5678IJ"));
        cars.addCar(new Car(6, "Camry", 2019, 20000, "KL6789MN"));
        cars.addCar(new Car(7, "Corolla", 2017, 16000, "OP7890QR"));
        cars.addCar(new Car(8, "RAV4", 2015, 13000, "ST9012UV"));
        cars.addCar(new Car(9, "Highlander", 2016, 15000, "WX1234YZ"));
        cars.addCar(new Car(10, "Camry", 2020, 22000, "AB2345CD"));
        cars.addCar(new Car(11, "Corolla", 2019, 19000, "EF3456GH"));
        cars.addCar(new Car(12, "RAV4", 2018, 17000, "IJ4567KL"));
    }
}