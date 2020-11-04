package com.example.demo.Services;

import com.example.demo.Model.Register;
import com.example.demo.Model.User;
import com.example.demo.Model.Response;
import com.example.demo.Repository.UserRepoLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServices  {

    @Autowired
    private UserRepoLogin userRepoLogin;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response<User> addData(User register) {

        if (register.getEmail()== null){
            return new Response(false, "Email cannot be null!!");
        }
        User user = userRepoLogin.findByEmail(register.getEmail());


        if (user == null) {
            String password = register.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            register.setPassword(encodedPassword);

            return new Response(true, "Added Success!", userRepoLogin.save(register));


        } else {

                return new Response(true, "Already exist email!!");

        }
    }


    public Response<User> getById(int id) {


         Optional<User> data = userRepoLogin.findById(id);
         if (data.isPresent()){
             return new Response<>(true, "Id data",data.get());
         }
        return  new Response<>(false, "Doesnot exist!");

    }

    public Response<List<User>> getAll() {
        return new Response<>(true,"sucess!", userRepoLogin.findAll());
    }


}
