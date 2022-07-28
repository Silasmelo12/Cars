package com.cars.cars.controller;

import com.cars.cars.domain.Logs;
import com.cars.cars.requests.CarGetResponseBody;
import com.cars.cars.requests.CarPostResponseBody;
import com.cars.cars.requests.CarPostResquestBody;
import com.cars.cars.service.CarServiceimpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class CarsController {

    private CarServiceimpl carServiceimpl;

    @GetMapping("/listCars")
    public List<CarGetResponseBody> getAllCars(){
        return carServiceimpl.listAllApi();
    }

    @GetMapping("/logs")
    public List<Logs> logs(){
        return carServiceimpl.listAllLog();
    }

    @PostMapping("/createCar")
    public CarPostResponseBody createCar(@RequestBody CarPostResquestBody car){
        return carServiceimpl.createCarApi(car);
    }
}
