package carsProcessor;

import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class CarsList{
    private int size = 0;
    private Car[] cars = new Car[12];
    public void addCar(Car car) {
        ensureCapacity(size + 1);
        cars[size++] = car;
    }
    public Car[] getCars(){ return cars; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public void setCarsList(Car[] cards){
        cars = cards;
        size = cars.length;
    }
    public void printCarsOfTheSameModel(String model) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getModel().equals(model)) {
                System.out.println(cars[i]);
            }
        }
    }
    public void printModelInUseMoreThenYears(String model, int exploitationYears) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(cars[i].getModel(), model)){
                if (((Year.now().getValue() - cars[i].getReleaseYear()) > exploitationYears)) {
                    System.out.println(cars[i]);
                }
            }
        }
    }
    public void printReleaseYearWithPriceMoreThen(int releaseYear, int price) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getReleaseYear() == releaseYear) {
                if (cars[i].getPrice() > price) {
                    System.out.println(cars[i]);
                }
            }
        }
    }
    public void sortByPrice() {
        Car[] newArray = new Car[size];
        System.arraycopy(cars, 0, newArray, 0, size);
        Arrays.sort(newArray, Comparator.comparing(Car::getPrice).reversed().thenComparing(Car::getReleaseYear));
        System.arraycopy(newArray, 0, cars, 0, size);
    }
    public void deleteById(int id){
        Car[] cards = new Car[cars.length-1];
        int num = 0;

        for (int i = 0, k = 0; i < size; i++) {
            if (cars[i].getId() != id) {
                cards[k] = cars[i];
                k++;
            }else num++;
        }
        size -= num;
        cars = Arrays.copyOf(cards, cards.length);
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity <= cars.length) return;
        Car[] newArray = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newArray, 0, cars.length);
        cars = newArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(cars[i]).append(",\n");
        }
        return sb.toString();
    }
}