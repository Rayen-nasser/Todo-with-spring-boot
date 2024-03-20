package com.Step07.springboot.myFirstApp.welcome;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.net.Authenticator;


@Controller
@SessionAttributes("name")
public class WelcomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return authentication.getName();
        }
        return null;
    }
}
