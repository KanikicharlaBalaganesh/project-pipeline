package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Car;
import com.example.repository.CarRepository;

@Service
public class CarService {

    private CarRepository repository;

    public CarService(CarRepository repository){
        this.repository=repository;
    }

    public void save(Car car){
        repository.save(car);
    }

    public List<Car> findAll(){
        return repository.findAll();
    }

    public Car findById(int id){
        return repository.findById(id);
    }

    public void update(Car car){
        repository.update(car);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
