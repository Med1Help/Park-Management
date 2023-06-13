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
    public String addManager(@RequestBody Manager manager,@RequestHeader(value = "secteur") String secteur ){
        int result = manager_serv.insertManager(manager,secteur);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_manager")
    public String updateManager(@RequestBody myObject object ,@RequestHeader(value = "secteur") String secteur ){
        System.out.println(object.getUpdate()+" "+object.getReference()+" "+object.getParams()[0]+" "+object.getParams()[1]);
        int result = manager_serv.updateManager(object.getUpdate(), object.getReference(), object.getParams(),secteur);
        return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteManager(@RequestBody Object[] params,@RequestHeader(value = "secteur") String secteur ){
        int result = manager_serv.deleteManager("e_mail",params,secteur);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allmanagers")
    public List<Manager> allManagers(@RequestHeader(value = "secteur") String secteur ){
       System.out.print("request from secteur: "+secteur);
        return manager_serv.selectAllManager(secteur);
    }
    @GetMapping("/allmanagersAdmin")
    public List<Manager> selectAllManagerAdmin(){
        System.out.print("request from ");
        return manager_serv.selectAllManagerAdmin();
    }
    @PostMapping("/manager")
    public List<Manager> manager(@RequestBody myObject object,@RequestHeader(value = "secteur") String secteur){
        return manager_serv.selectManager(object.getReference(), object.getParams(),secteur);
    }

}
