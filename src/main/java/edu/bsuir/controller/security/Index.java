package edu.bsuir.controller.security;

import edu.bsuir.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class Index {

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(Model model, @SessionAttribute ("userForm") Users userForm){
        model.addAttribute("userForm", userForm);

        return "index";
    }
}
