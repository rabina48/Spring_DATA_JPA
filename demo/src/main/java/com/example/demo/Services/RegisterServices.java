package com.example.demo.Services;

import com.example.demo.Model.User;
import com.example.demo.Model.Response;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServices  {

    @Autowired
    private UserRepo registerRepo;

    public User addData(User registrationModel){

        return registerRepo.save(registrationModel);
    }


    public Response<User> getById(int id) {


         Optional<User> data = registerRepo.findById(id);
         if (data.isPresent()){
             return new Response<>(true, "Id data",data.get());
         }
        return  new Response<>(false, "Doesnot exist!");

    }

    public Response<List<User>> getAll() {
        return new Response<>(true,"sucess!",registerRepo.findAll());
    }
}
