package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.model.Car;
import com.example.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService service;

    public CarController(){}

    public CarController(CarService service){
        this.service=service;
    }

    @PostMapping
    public String save(@RequestBody Car car){

        service.save(car);

        return "Car Saved";
    }

    @GetMapping
    public List<Car> getCars(){

        return service.findAll();
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable int id){

        return service.findById(id);
    }

    @PutMapping
    public String update(@RequestBody Car car){

        service.update(car);

        return "Updated Successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){

        service.deleteById(id);

        return "Deleted Successfully";
    }

}
