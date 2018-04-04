package edu.bsuir.controller.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.support.SessionStatus;

@Controller
public class Logout {

    @Value("${message.logoutSuccessful}")
    private String messageLogout;

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(Model model /*SessionStatus sessionStatus*/){
        //sessionStatus.setComplete();

        model.addAttribute("logoutMessage", messageLogout);

        return "redirect:/authenticate";
    }
}
