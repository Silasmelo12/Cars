package com.cars.cars.service;

import com.cars.cars.client.ClientGetFeignCars;
import com.cars.cars.domain.Logs;
import com.cars.cars.repository.CarsRepository;
import com.cars.cars.requests.CarGetResponseBody;
import com.cars.cars.requests.CarPostResponseBody;
import com.cars.cars.requests.CarPostResquestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CarServiceimpl implements CarService{

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private ClientGetFeignCars clientGetFeignCars;

    @Override
    public List<Logs> listAllLog() {
        return carsRepository.findAll();
    }

    @Override
    public List<CarGetResponseBody> listAllApi() {
        List<CarGetResponseBody> list = clientGetFeignCars.getAllCars();
        return list;
    }

    @Override
    public Logs saveLog(CarPostResponseBody carPostResponseBody){

        Logs logs = new Logs();

        logs.setCar_id(carPostResponseBody.get_id());
        logs.setLocalDate(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()));

        logs = carsRepository.save(logs);

        return logs;
    }

    @Override
    public CarPostResponseBody createCarApi(CarPostResquestBody car) {
        CarPostResponseBody carPostResponseBody = new CarPostResponseBody();
        carPostResponseBody = clientGetFeignCars.createCar(car);
        System.out.println("o ide cadastrado é : "+carPostResponseBody.get_id());
        if (!carPostResponseBody.get_id().isEmpty()){
            saveLog(carPostResponseBody);
        }
        return carPostResponseBody;
    }
}
