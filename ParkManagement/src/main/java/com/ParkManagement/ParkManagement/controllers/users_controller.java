package com.ParkManagement.ParkManagement.controllers;

import com.ParkManagement.ParkManagement.models.User;
import com.ParkManagement.ParkManagement.service.JwtService;
import com.ParkManagement.ParkManagement.service.users_service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class users_controller {

    users_service user_serv;
   private PasswordEncoder passwordEncoder;
   private final JwtService jwtService;
    public users_controller(users_service user_serv, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.user_serv          = user_serv;
        this.passwordEncoder    = passwordEncoder;
        this.jwtService         = jwtService;
    }
    @GetMapping("/add_user")
    public String addUser(@RequestBody User user){
        System.out.println("result : ");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int result = user_serv.insertUsers(user);
        String jwtoken = jwtService.genToken(new HashMap<>(),user);
        return result == 1 ? jwtoken : "failed to insert";
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
    @PostMapping("/allusers")
    public User allUsers(){
        return user_serv.selectUsers("e_mail",new Object[]{"leader3@gmail.com"});
    }
    @PostMapping("/login")
    public LoginResp login(@RequestBody User user) throws  Exception{
        System.out.println("login ...");
        User myUser = user_serv.selectUsers("e_mail",new Object[]{user.getE_mail()});
        user.setRole(myUser.getRole());
        System.out.println(user);
        System.out.println(user);
        String token = "";
        if(user != null) token = this.user_serv.authenticate(user);
        LoginResp resp = new LoginResp();
        if(!token.isEmpty()){
            resp.setToken(token);
            resp.setSecteur(myUser.getSecteur());
            resp.setRole(myUser.getRole());
        }
        return resp ;
    }

}
