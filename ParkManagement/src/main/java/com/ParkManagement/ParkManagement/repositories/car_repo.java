package com.ParkManagement.ParkManagement.repositories;

import com.ParkManagement.ParkManagement.models.Car;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;

import java.util.List;

public interface car_repo {

    int insertCar(Car car,String secteur);
    int updateCar(String update , String reference , Object[] params);
    int deleteCar(String reference,Object[] params);
    List<Car> selectCar(String reference, Object[] params);
}
