package com.cars.cars.service;

import com.cars.cars.domain.Logs;
import com.cars.cars.requests.CarGetResponseBody;
import com.cars.cars.requests.CarPostResponseBody;
import com.cars.cars.requests.CarPostResquestBody;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    public Logs saveLog(CarPostResponseBody carPostResponseBody);

    public List<Logs> listAllLog();

    public List<CarGetResponseBody> listAllApi();

    public CarPostResponseBody createCarApi(CarPostResquestBody car);
}
