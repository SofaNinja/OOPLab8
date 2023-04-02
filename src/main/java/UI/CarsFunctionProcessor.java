package UI;

import carsProcessor.Car;
import carsProcessor.CarsMap;

import java.util.*;

public class CarsFunctionProcessor implements CarsFunctions {
    @Override
    public void createCarsArray(CarsMap cars) {
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
    public void printCarsMap(CarsMap tempCars) {
        List<Car> cars = tempCars.getCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }
    @Override
    public void addNewCar(CarsMap cars, Scanner scanner){
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
    @Override
    public void deleteElementById(CarsMap cars, Scanner scanner){
        System.out.println("Enter id >> ");
        int id = scanner.nextInt();
        cars.deleteById(id);
    }
    @Override
    public void printCarOfTheSameModelByReleaseYear(CarsMap cars, Scanner scanner) {
        System.out.println("Enter model of cars >> ");
        String model = scanner.next();
        List<Car> carsList = new ArrayList<>(cars.getCars());
        carsList.sort(Comparator.comparing(Car::getReleaseYear));
        cars.printCarsOfTheSameModel(model);
    }
    @Override
    public void printModelInUseMoreThenYears(CarsMap cars, Scanner scanner) {
        System.out.println("Enter model >> ");
        String model = scanner.next();
        System.out.println("Enter years in use >> ");
        int exploitationYears = scanner.nextInt();

        cars.printModelInUseMoreThenYears(model, exploitationYears);
    }
    @Override
    public void printReleaseYearWithPriceMoreThen(CarsMap cars, Scanner scanner) {
        System.out.println("Enter release year >> ");
        int releaseYear =  scanner.nextInt();
        System.out.println("Enter price >> ");
        int price = scanner.nextInt();

        cars.printReleaseYearWithPriceMoreThen(releaseYear, price);
    }
//    @Override
//    public void printSortByReleaseYear(CarsMap cars, Scanner scanner){
//        System.out.println("Enter model of cars >> ");
//        String model = scanner.next();
//
//        cars.printCarsOfTheSameModel(model);
//        List<Car> carsList = new ArrayList<>(cars.getCars());
//        carsList.sort(Comparator.comparing(Car::getPrice).reversed().thenComparing(Car::getReleaseYear));
//        for (Car car : carsList) {
//            System.out.println(car);
//        }
//    }
    @Override
    public void printSortByPrice(CarsMap cars){
        List<Car> carsList = new ArrayList<>(cars.getCars());
        carsList.sort(Comparator.comparing(Car::getPrice).reversed().thenComparing(Car::getReleaseYear));
        for (Car car : carsList) {
            System.out.println(car);
        }
    }
    @Override
    public void printCarModels(CarsMap cars) {
        for (Map.Entry<String, List<Car>> entry : getStringListMap(cars).entrySet())  {
            System.out.print(entry.getKey() + ", ");
        }
        System.out.println();
    }
    @Override
    public void printCarsByModels(CarsMap cars) {
        Map<String, List<Car>> carsOfTheSameModel = getStringListMap(cars);
        cars.printByModel(carsOfTheSameModel);
    }

    private static Map<String, List<Car>> getStringListMap(CarsMap cars) {
        Map<String, List<Car>> productsByManufacturer = new HashMap<>();
        for (Car car : cars.getCars()) {
            String model = car.getModel();
            if (!productsByManufacturer.containsKey(model)) {
                productsByManufacturer.put(model, new ArrayList<>());
            }
            productsByManufacturer.get(model).add(car);
        }
        return productsByManufacturer;
    }
}