package com.mostdev.myfirstwebapp.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//we have to tell spring this is a bean
@Controller
public class sayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello what are you learning?";
    }

    @RequestMapping("sayHello")
    public String sayHelloJSP() {
        return "sayHello";
    }

}
