package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.Affectation;
import com.ParkManagement.ParkManagement.models.Lead_manager;
import com.ParkManagement.ParkManagement.models.Manager;
import com.ParkManagement.ParkManagement.service.affectation_service;
import com.ParkManagement.ParkManagement.service.lead_manager_service;
import com.ParkManagement.ParkManagement.service.manager_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("affectation")
public class affectation_controller {

    affectation_service affect_serv;

    public affectation_controller(affectation_service affect_serv) {
        this.affect_serv = affect_serv;
    }
    @PostMapping("/add_affectation")
    public String addManager(@RequestBody Affectation affect){
        int result = affect_serv.insertAffectation(affect);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_affectation")
    public String updateManager(@RequestBody myObject object ){
        int result = affect_serv.updateAffectation(object.getUpdate(), object.getReference(), object.getParams());
        return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteManager(@RequestBody Object[] params){
        int result = affect_serv.deleteAffectation("e_mail",params);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allaffectations")
    public List<Affectation> allManagers(@RequestHeader(value = "secteur") String secteur){
        return affect_serv.selectAllAffectation(secteur);
    }
    @GetMapping("/check_validity")
    public Boolean check(@RequestHeader("id") int idAffect){
        return affect_serv.checkAffectationValidity(idAffect);
    }

}
