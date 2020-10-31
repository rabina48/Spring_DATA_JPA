package com.example.demo.Services;

import com.example.demo.Model.Register;
import com.example.demo.Model.Response;
import com.example.demo.Model.Login;
import com.example.demo.Model.User;
import com.example.demo.Repository.LoginRepo;
import com.example.demo.Repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices extends  UserDaoImpl{

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private UserDaoImpl userDaoImpl;

    public Response loginData(Login login) {

        User user = loginRepo.findByEmail(login.getEmail());


        if ( user == null) {
            return new Response(false, "Email cannot be null!!");

        } else if (!user.getPassword().equals(login.getPassword())) {
            return new Response(false, "Password Mismatch!!");

        } else if ((user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword()))) {
            return new Response(true, "login Success!!");
        }
        return  null;
    }

    public Response registerData(Register register) {

        return new Response(true,"login Success!!");
    }
}
