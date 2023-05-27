package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.Users;
import com.ParkManagement.ParkManagement.service.users_service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class users_controller {

    users_service user_serv;

    public users_controller(users_service user_serv) {
        this.user_serv = user_serv;
    }
    @PostMapping("/add_user")
    public String addUser(@RequestBody Users user){
        int result = user_serv.insertUsers(user);
        return result == 1 ? "Insertion succesfuly " : "failed to insert";
    }
    @PostMapping("/update_user")
    public String updateUser(@RequestBody myObject object ){
        int result = user_serv.updateUsers(object.getUpdate(), object.getReference(), object.getParams());
        return result == 1 ? "Update succesfuly " : "failed to update";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestBody Object[] params){
        int result = user_serv.deleteUsers("e_mail",params);
        return result == 1 ? "Delete succesfuly " : "delete to update";
    }
    @GetMapping("/allusers")
    public List<Users> allUsers(){
        return user_serv.selectAllUsers();
    }

}
