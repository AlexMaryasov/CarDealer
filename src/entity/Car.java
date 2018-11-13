package entity;

import java.util.Objects;

public class Car {
    private String make;
    private String model;
    private int year;
    private int price;
    private double volume;


    public Car(String make, String model, int year, int price, double volume) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.volume = volume;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                price == car.price &&
                Double.compare(car.volume, volume) == 0 &&
                Objects.equals(make, car.make) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, price, volume);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}
