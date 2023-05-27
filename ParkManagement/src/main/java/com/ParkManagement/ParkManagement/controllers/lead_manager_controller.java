package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.service.lead_manager_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lead_manager")
public class lead_manager_controller {
    lead_manager_service lead_serv;

    public lead_manager_controller(lead_manager_service lead_serv) {
        this.lead_serv = lead_serv;
    }
    @PostMapping("/add_lead")
    public String addLead(@RequestBody Lead_manager leadManager){
        int result = lead_serv.insertLead(leadManager);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_lead")
    public String updateLead(@RequestBody myObject object ){
       int result = lead_serv.updateLead(object.getUpdate(), object.getReference(), object.getParams());
       return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteLead(@RequestBody Object[] params){
        int result = lead_serv.deleteLead("e_mail",params);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allleads")
    public List<Lead_manager> allLeads(){
        return lead_serv.selectAllLeads();
    }
}
