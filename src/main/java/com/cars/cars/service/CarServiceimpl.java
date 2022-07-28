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
    public Logs saveLog(CarPostResponseBody carPostResponseBody){

        Logs logs = new Logs();

        logs.set_id(carPostResponseBody.get_id());
        logs.setTitle(carPostResponseBody.getTitle());
        logs.setAge(carPostResponseBody.getAge());
        logs.setPrice(carPostResponseBody.getPrice());
        logs.setBrand(carPostResponseBody.getBrand());
        logs.set__v(carPostResponseBody.get__v());
        logs.setLocalDate(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()));

        Logs logs1 = carsRepository.save(logs);

        return logs1;
    }

    @Override
    public List<Logs> listAllLog() {
        return carsRepository.findAll();
    }

    @Override
    public List<CarGetResponseBody> listAllApi() {
        System.out.println("Chegou na fase 2");
        List<CarGetResponseBody> list = clientGetFeignCars.getAllCars();
        System.out.println("Chegou na fase 3"+list.get(0));
        return list;

    }

    @Override
    public CarPostResponseBody createCarApi(CarPostResquestBody car) {
        CarPostResponseBody carPostResponseBody = new CarPostResponseBody();
        carPostResponseBody = clientGetFeignCars.createCar(car);
        if (!carPostResponseBody.get_id().isEmpty()){
            saveLog(carPostResponseBody);
        }
        return clientGetFeignCars.createCar(car);
    }


}
