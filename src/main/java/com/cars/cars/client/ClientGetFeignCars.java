package com.cars.cars.client;

import com.cars.cars.DTO.CarsDTO;
import com.cars.cars.DTO.PostDTO;
import com.cars.cars.requests.CarPostResquestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cars", url = "http://api-test.bhut.com.br:3000/api")
public interface ClientGetFeignCars {

    @GetMapping(value = "/cars")
    List<CarsDTO> getAllCars();

    @PostMapping(value = "/cars")
    CarsDTO createCar(@RequestBody CarPostResquestBody car);

}
