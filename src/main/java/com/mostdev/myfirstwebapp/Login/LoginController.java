package com.mostdev.myfirstwebapp.Login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;


    @RequestMapping(value = "Login", method = RequestMethod.GET)
    public String Login () {
        return "Login";
    }
    @RequestMapping(value = "Login", method = RequestMethod.POST)
    public String RedirectToWelcomePage(
            @RequestParam String name, @RequestParam String password,
            ModelMap model) {

        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);

            return "Welcome";
        }

        model.put("errorMessage", "InValid Credentials! Please try again.");
        return "Login";
    }

}
