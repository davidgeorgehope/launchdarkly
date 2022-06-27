package com.djhope.launchdarkly;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class WelcomeController {
    public static CredentialsBean credentialsBean = new CredentialsBean();
    public static CredentialsBean credsSingleton() {
        return credentialsBean;
    }
    @RequestMapping("/welcome")
    public String loginMessage(){
        return "welcome";
    }


    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());

        return "login";
    }

    @RequestMapping("/submitLogin")
    public String submitLogin(@ModelAttribute("user")User user,
                              BindingResult result, ModelMap model) {
        model.addAttribute("userId", user.getUserId());
        model.addAttribute("clientId", user.getClientId());
        model.addAttribute("serverId", user.getServerId());
        CredentialsBean credsSingleton = credsSingleton();
        credsSingleton.setUserName(user.getUserId());
        credsSingleton.setUserId(user.getUserId());
        credsSingleton.setSDKKey(user.getServerId());

        return "welcome";
    }

}