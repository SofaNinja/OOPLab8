package org.example;

import IO.IO;
import IO.IOProcessor;
import UI.CarsFunctionProcessor;
import UI.CarsFunctions;
import carsProcessor.CarsList;

import java.io.*;
import java.util.Scanner;

public class Main implements Serializable {
    public static void main(String[] args) { new Main().run(); }
    private void menu() {
        System.out.println("\nОберіть потрібний вам функціонал: ");
        System.out.println("1 - Прочитати файл.");
        System.out.println("2 - Вивести список всіх автомобілів.");
        System.out.println("3 - Список автомобілів заданої моделі.");
        System.out.println("4 - Список автомобілів заданої моделі, які експлуатуються більше заданих років.");
        System.out.println("5 - Список автомобілів заданого року випуску, ціна яких більше вказаної.");
        System.out.println("6 - Список автомобілів в порядку спадання ціни.");
        System.out.println("7 - Додати автомобіль до списку.");
        System.out.println("8 - Видалити зі списку за номером.");
        System.out.println("9 - Зберегти файл.");
        System.out.println("10 - Загрузити файл.");
        System.out.println("11 - Вихід.\n");
        System.out.println("Введіть ваш запит: ");
    }
    private void run() {
        CarsList cars = new CarsList();
        IO io = new IOProcessor();
        CarsFunctions funs = new CarsFunctionProcessor();
        loop:
        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            int request = scanner.nextInt();
            System.out.println();
            switch (request) {
                case 1 -> cars.setCarsList(io.readObjects(cars));
                case 2 -> funs.printAllCars(cars);
                case 3 -> funs.printCarOfTheSameModel(cars, scanner);
                case 4 -> funs.printModelInUseMoreThenYears(cars, scanner);
                case 5 -> funs.printReleaseYearWithPriceMoreThen(cars, scanner);
                case 6 -> funs.sortByPrice(cars, scanner);
                case 7 -> funs.addNewCar(cars, scanner);
                case 8 -> funs.deleteElementById(cars, scanner);
                case 9 -> io.writeObjects(cars);
                case 10 -> funs.createCarsArray(cars);
                case 11 -> { break loop; }
            }
        }
    }
}