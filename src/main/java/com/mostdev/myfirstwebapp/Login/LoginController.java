package com.mostdev.myfirstwebapp.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

    @GetMapping("Login")
    public String Login (){
        return "Login";
    }

}
