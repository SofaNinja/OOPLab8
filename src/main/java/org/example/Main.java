package org.example;

import IO.IO;
import IO.IOProcessor;
import UI.CarsFunctionProcessor;
import UI.CarsFunctions;
import carsProcessor.CarsMap;

import java.util.Scanner;

public class Main {
    public final String  fileNameTxt = "cars.dat";
    public final String  fileNameJson = "cars.json";
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void menu() {
        System.out.println("\nОберіть потрібний вам функціонал: ");
        System.out.println("1 - Створити список автомобілів.");
        System.out.println("2 - Вивести список всіх автомобілів.");
        System.out.println("3 - Список автомобілів заданої моделі в порядку зростання року випуску.");
        System.out.println("4 - Список автомобілів заданої моделі, які експлуатуються більше n років;");
        System.out.println("5 - Список автомобілів заданого року випуску, ціна яких більше вказаної;");
        System.out.println("6 - Список автомобілів в порядку спадання ціни." +
                " Якщо ціна однакова, то в порядку зростання року випуску;");
        System.out.println("7 - Список моделей автомобілів, зареєстрованих у програмі;");
        System.out.println("8 - Для кожної моделі вивести список автомобілів.");
        System.out.println("9 - Додати автомобіль до списку.");
        System.out.println("10 - Видалити автомобіль за номером.");
        System.out.println("11 - Прочитати з текстового файлу");
        System.out.println("12 - Записати до текстового файлу");
        System.out.println("13 - Прочитати з Json файлу");
        System.out.println("14 - Записати до Json файлу");
        System.out.println("15 - Вийти");
        System.out.println("Введіть ваш запит: ");
    }
    private void run() {
        CarsFunctions carsFunctions = new CarsFunctionProcessor();
        IO io = new IOProcessor();
        CarsMap cars = new CarsMap();
        Scanner scanner = new Scanner(System.in);
        boolean status = true;
        menu();
        while (status) {
            int request = scanner.nextInt();
            switch (request) {
                case 1 -> carsFunctions.createCarsArray(cars);
                case 2 -> carsFunctions.printCarsMap(cars);
                case 3 -> carsFunctions.printCarOfTheSameModelByReleaseYear(cars, scanner);
                case 4 -> carsFunctions.printModelInUseMoreThenYears(cars, scanner);
                case 5 -> carsFunctions.printReleaseYearWithPriceMoreThen(cars, scanner);
                case 6 -> carsFunctions.printSortByPrice(cars);
                case 7 -> carsFunctions.printCarModels(cars);
                case 8 -> carsFunctions.printCarsByModels(cars);
                case 9 -> carsFunctions.addNewCar(cars, scanner);
                case 10 -> carsFunctions.deleteElementById(cars, scanner);
                case 11 -> cars.formatCarsMapList(io.readObjectsTxt(fileNameTxt));
                case 12 -> io.writeObjectsTxt(cars, fileNameTxt);
                case 13 -> cars.formatCarsMapList(io.readObjectsJson(fileNameJson));
                case 14 -> io.writeObjectsJson(cars, fileNameJson);
                case 15 -> status = false;
            }
        }

    }
}