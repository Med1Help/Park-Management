package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.Car;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.service.car_service;
import com.ParkManagement.ParkManagement.service.lead_manager_service;
import com.ParkManagement.ParkManagement.service.manager_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class car_controller {

    car_service car_serv;

    public car_controller(car_service car_serv) {
        this.car_serv = car_serv;
    }
    @PostMapping("/add_car")
    public String addManager(@RequestBody Car car){
        int result = car_serv.insertCar(car);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_car")
    public String updateManager(@RequestBody myObject object ){
        int result = car_serv.updateCar(object.getUpdate(), object.getReference(), object.getParams());
        return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteManager(@RequestBody Object[] params){
        int result = car_serv.deleteCar("e_mail",params);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allcars")
    public List<Car> allManagers(){
        return car_serv.selectAllCar();
    }

}
