package IO;

import carsProcessor.Car;
import carsProcessor.CarsList;

import java.io.*;

public class IOProcessor implements IO {

    public Car[] readObjects(CarsList cars) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            Car[] car1 = (Car[]) ois.readObject();
            System.out.println("File read success!");
            return car1;
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        } catch (ClassNotFoundException e) {
            System.out.println("File Not Found!");
        }
        return new Car[0];
    }

    public void writeObjects(CarsList cars) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(cars.getCars());
            System.out.println("File write success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}