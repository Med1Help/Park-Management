package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.models.Rider;
import com.ParkManagement.ParkManagement.service.lead_manager_service;
import com.ParkManagement.ParkManagement.service.manager_service;
import com.ParkManagement.ParkManagement.service.rider_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rider")
public class rider_controller {

    rider_service rider_serv;

    public rider_controller(rider_service rider_serv) {
        this.rider_serv = rider_serv;
    }
    @PostMapping("/add_rider")
    public String addRider(@RequestBody Rider rider){
        int result = rider_serv.insertRider(rider);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_rider")
    public String updateRider(@RequestBody myObject object ){
        int result = rider_serv.updateRider(object.getUpdate(), object.getReference(), object.getParams());
        return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteRider(@RequestBody Object[] params){
        int result = rider_serv.deleteRider("e_mail",params);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allriders")
    public List<Rider> allRiders(){
        return rider_serv.selectAllRider();
    }

}

