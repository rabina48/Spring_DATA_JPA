package com.example.demo.Services;

import com.example.demo.Model.*;
import com.example.demo.Repository.UserRepoLogin;
import com.example.demo.Repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    private UserRepoLogin userRepoLogin;

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response loginData(Login login) {

        User user = userRepoLogin.findByEmail(login.getEmail());


        if ( user == null) {
            return new Response(false, "Email cannot be null!!");

//        }else if (user.getPassword().length()<6 || user.getPassword().length() > 15){
//            return new Response(false, "Password Should be greater than 6 and less than 15 !!");

        } else if (!passwordEncoder.matches(login.getPassword(),user.getPassword())) {
            return new Response(false, "Password Mismatch!!");

        } else {
            return new Response(true, "login Success!!");
        }

    }
//(user.getEmail().equals(login.getEmail()) && user.getPassword().equals(login.getPassword()


        public Response registerData(User register) {

            User user = userRepoLogin.findByEmail(register.getEmail());

            if (user == null) {
                return new Response(false, "Email cannot be null!!");
            } else if (user != null) {
                return new Response(true, "Added Success!!", userRepoLogin.save(register));

            }

            return  null;
        }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            User user =userRepoLogin.findByEmail(s);
        return new CustomUserDetails(user);
    }
}

