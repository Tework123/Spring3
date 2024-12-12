package com.spring3.spring3.services;

import com.spring3.spring3.entities.Car;
import com.spring3.spring3.entities.User;
import com.spring3.spring3.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.List;


@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public void createCar(Car car, User currentUser) {
        car.getUsers().add(currentUser);
        carRepository.save(car);

    }

    public List<Car> listCars() {
        return carRepository.findAll();
    }

    public Car getCar(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

}
