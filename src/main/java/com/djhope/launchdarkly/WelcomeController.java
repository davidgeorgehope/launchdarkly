package com.djhope.launchdarkly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class WelcomeController {
    @RequestMapping("/welcome")
    public String loginMessage(){
        return "welcome";
    }
    @RequestMapping("/")
    public String hello(){
        return "NEW";
    }

    @GetMapping("/viewBooks")
    public String viewBooks(Model model) {
        model.addAttribute("books","");
        return "welcome";
    }
}