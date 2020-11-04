package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class TemplateController {

    @GetMapping("loginpage")
    public String getLogin(){
        return "loginpage";
    }


    @GetMapping("course")
    public String getCourses(){
        return "courses";
    }
}
