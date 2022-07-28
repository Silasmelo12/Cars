package com.cars.cars.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Car {

    @Id
    private String _id;
    private String title;
    private String brand;
    private String price;
    private Integer age;
    private Integer __v;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return _id != null && Objects.equals(_id, car._id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
