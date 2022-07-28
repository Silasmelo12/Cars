package com.cars.cars.controller;

import com.cars.cars.DTO.CarsDTO;
import com.cars.cars.client.ClientGetFeignCars;
import com.cars.cars.requests.CarPostResquestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class CarsController {

    private ClientGetFeignCars clientGetFeignCars;

    @GetMapping("/listCars")
    public List<CarsDTO> getAllCars(){
        return clientGetFeignCars.getAllCars();
    }

    @GetMapping("/logs")
    public List<CarsDTO> logs(){
        return clientGetFeignCars.getAllCars();
    }

    @PostMapping("/createCar")
    public CarsDTO createCar(@RequestBody CarPostResquestBody car){
        return clientGetFeignCars.createCar(car);
    }
}
