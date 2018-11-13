package service;

import entity.Car;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CarDealer {
    private String name;
    private final Set<Car> cars = new HashSet<>();

    public CarDealer(String name) {
        this.name = name;
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Set<Car> getAllByMake(String make) {
        Set<Car> byMake = new HashSet<>();

        for (Car m : cars) {
            if (make.equals(m.getMake())) byMake.add(m);
        }
        return byMake;
    }

    public Set<Car> getAllByMake(String make, int limit) {
        Set<Car> byMake = new HashSet<>();
        int a = 0;
        for (Car m : cars) {
            if (make.equals(m.getMake())) {
                byMake.add(m);
                a++;
            }
            if (a == limit) {
                break;
            }

        }
        return byMake;
    }

    public boolean remove(Car car) {
        Iterator<Car> iterator = cars.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            Car m = iterator.next();
            if (m.equals(car)) {
                iterator.remove();
                b = true;
                break;
            }
        }
        return b;
    }

    public Car update(Car car) {
        Iterator<Car> iterator = cars.iterator();
        Car b = car;
        while (iterator.hasNext()) {
            Car m = iterator.next();
            if (m.equals(car)) {
                iterator.remove();
                b = m;
                break;
            }
        }
        return b;
    }

    public boolean removeAllByMake(String make) {
        Iterator<Car> iterator = cars.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (make.equals(car.getMake())) {
                iterator.remove();
                b = true;
            }

        }
        return b;
    }

    public Set<Car> getAllByVolume(double from, double to) {
        Set<Car> byVolume = new HashSet<>();

        for (Car m : cars) {
            if (m.getVolume() >= from && m.getVolume() <= to) byVolume.add(m);
        }
        return byVolume;
    }

    public Set<Car> getAllByPrice(int from, int to) {
        Set<Car> byPrice = new HashSet<>();

        for (Car m : cars) {
            if (m.getPrice() >= from && m.getPrice() <= to) byPrice.add(m);
        }
        return byPrice;
    }

    public Set<Car> getAllByYear(int from, int to) {
        Set<Car> byYear = new HashSet<>();

        for (Car m : cars) {
            if (m.getYear() >= from && m.getYear() <= to) byYear.add(m);
        }
        return byYear;
    }


}