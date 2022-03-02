package tn.esprit.spring.service;

import tn.esprit.spring.entity.Car;
import tn.esprit.spring.entity.Employee;

import java.util.List;

public interface ICar {

    List<Car> retrieveAllCars();
    Car getCarById(int id);
    Car AddCar(Car car);
    Car UpdateCar(Car car);
    void DeleteCar(int id);
    List<String> getAllCarModel();
    List<String> getAscPrice();
    List<String> getDecPrice();

}
