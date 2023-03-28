package IO;

import carsProcessor.Car;
import carsProcessor.CarsList;
public interface IO {
    Car[] readObjects(CarsList cars);
    void writeObjects(CarsList cars);
}