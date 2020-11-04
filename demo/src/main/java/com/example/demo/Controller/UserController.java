package com.example.demo.Controller;


import com.example.demo.Model.Login;
import com.example.demo.Model.Register;
import com.example.demo.Model.User;
import com.example.demo.Model.Response;
import com.example.demo.Services.UserServices;
import com.example.demo.Services.RegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private RegisterServices registerServices;

    @Autowired
    private UserServices userservices;

    @PostMapping(value = "add")
    public Response addPerson(@RequestBody User registrationModel) {
        return registerServices.addData(registrationModel);
        //return  new Response(true, "Person information added");
    }

    @GetMapping(value ="{id}")
    public Response<User> getRegisterById(@PathVariable int id){
        return registerServices.getById(id);
    }

    @GetMapping("/all")
    public Response<List<User>>getAll(){

        return registerServices.getAll();

    }
    @GetMapping("/me")
    public Object getMe(){
        return SecurityContextHolder.getContext().getAuthentication().getDetails();
      //  return registerServices.getAll();

    }

    @PostMapping (value ="/login")
    public Response login(@RequestBody Login login){

        return userservices.loginData(login);

    }


}




