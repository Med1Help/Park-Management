package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.service.lead_manager_service;
import com.ParkManagement.ParkManagement.service.manager_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manager")
public class manager_controller {

    manager_service manager_serv;

    public manager_controller(manager_service manager_serv) {
        this.manager_serv = manager_serv;
    }
    @PostMapping("/add_manager")
    public String addManager(@RequestBody Manager manager){
        int result = manager_serv.insertManager(manager);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_manager")
    public String updateManager(@RequestBody myObject object ){
        int result = manager_serv.updateManager(object.getUpdate(), object.getReference(), object.getParams());
        return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteManager(@RequestBody Object[] params){
        int result = manager_serv.deleteManager("e_mail",params);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allmanagers")
    public List<Manager> allManagers(){
        return manager_serv.selectAllManager();
    }

}
