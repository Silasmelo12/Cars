package com.cars.cars.DTO;

public class CarsDTO {

    private String _id;
    private String title;
    private String brand;
    private String price;
    private String age;

    public CarsDTO() {
    }

    public CarsDTO(String _id, String title, String brand, String price, String age) {
        this._id = _id;
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.age = age;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
