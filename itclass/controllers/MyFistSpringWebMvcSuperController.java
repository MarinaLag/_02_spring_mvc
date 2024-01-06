package by.itclass.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFistSpringWebMvcSuperController {
    @GetMapping(value = "/toIndex")
    public String viewIndex(){
        return "index";
    };
}
