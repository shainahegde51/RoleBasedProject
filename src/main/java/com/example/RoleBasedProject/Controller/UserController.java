package com.example.RoleBasedProject.Controller;

import com.example.RoleBasedProject.Entity.User;
import com.example.RoleBasedProject.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //This api can only be used by user
    @GetMapping({"/user"})
    public String home(){
        return "Hi welcome to the Home Page";
    }


    //This api can be used only by admin
    @GetMapping({"/admin"})
    public String admin(){

        return "Hi welcome to the Admin Page";
    }


    //Its a public api where both user and admin can use it
    @PostMapping({"/addUser"})
    public String addUser(@RequestBody User user){
        userDetailsService.createUser(user);
        return  "New User Added";
    }


    //Its a public api where both user and admin can use it
    @GetMapping({"/"})
    public String publicPage(){
        return "Welcome to the public page";

    }
    }

