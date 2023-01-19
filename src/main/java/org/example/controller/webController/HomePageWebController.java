package org.example.controller.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageWebController {

    @GetMapping("/welcome")
    public String goToHomePage(){
        return "homePage";

    }
}
