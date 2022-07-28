package com.cars.cars.service;

import com.cars.cars.DTO.CarsDTO;
import com.cars.cars.domain.Car;
import com.cars.cars.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarsRepository carsRepository;
    public void save(String nome,String descr){
        CarsDTO car = new CarsDTO();
    }

}
