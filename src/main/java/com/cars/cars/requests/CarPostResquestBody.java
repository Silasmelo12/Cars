package com.cars.cars.requests;

import lombok.Data;

@Data
public class CarPostResquestBody {
    private String title;
    private String brand;
    private String price;
    private Integer age;
}
