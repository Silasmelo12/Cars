package com.cars.cars.client;

import com.cars.cars.requests.CarGetResponseBody;
import com.cars.cars.requests.CarPostResponseBody;
import com.cars.cars.requests.CarPostResquestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "cars", url = "http://api-test.bhut.com.br:3000/api")
public interface ClientGetFeignCars {

    @GetMapping(value = "/cars")
    List<CarGetResponseBody> getAllCars();

    @PostMapping(value = "/cars")
    CarPostResponseBody createCar(@RequestBody CarPostResquestBody car);
}
