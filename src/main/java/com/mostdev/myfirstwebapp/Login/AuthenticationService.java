package com.mostdev.myfirstwebapp.Login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isUserNameValid = username.equalsIgnoreCase("Caleb");
        boolean isPasswordValid = password.equalsIgnoreCase("Spidey");


        return isPasswordValid && isUserNameValid;


    }

}
