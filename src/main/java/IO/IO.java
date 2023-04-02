package IO;

import carsProcessor.Car;
import carsProcessor.CarsMap;

import java.util.Map;

public interface IO {
    Map<Integer, Car> readObjectsTxt(String fileName);
    void writeObjectsTxt(CarsMap cars, String fileName);
    Map<Integer, Car> readObjectsJson(String fileName);
    void writeObjectsJson(CarsMap cars, String fileName);
}