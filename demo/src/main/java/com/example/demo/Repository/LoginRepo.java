package com.example.demo.Repository;

import com.example.demo.Model.Login;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<User, Integer> {

    Login findByEmail(String email);

    Login findByPassword(String password);
}
