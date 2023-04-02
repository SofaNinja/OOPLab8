package IO;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import carsProcessor.Car;
import carsProcessor.CarsMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOProcessor implements IO {
    @Override
    public void writeObjectsTxt(CarsMap cars, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Car> car = cars.getCars();
            objectMapper.writeValue(new File(fileName), car);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Map<Integer, Car> readObjectsTxt(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Car> cars = objectMapper.readValue(new File(fileName), new TypeReference<List<Car>>() {});
            Map<Integer, Car> carMap = new HashMap<>();
            for (Car car : cars) carMap.put(car.getId(), car);
            return carMap;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        }
        return null;
    }
    @Override
    public void writeObjectsJson(CarsMap cars, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Car> car = cars.getCars();
            objectMapper.writeValue(new File(fileName), car);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Map<Integer, Car> readObjectsJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            List<Car> cars = objectMapper.readValue(new File(fileName), new TypeReference<List<Car>>() {});
            Map<Integer, Car> productMap = new HashMap<>();
            for (Car car : cars) productMap.put(car.getId(), car);
            return productMap;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("File Read ERROR!");
        }
        return null;
    }
}