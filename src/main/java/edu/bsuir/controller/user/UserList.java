package edu.bsuir.controller.user;

import edu.bsuir.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserList {

    @Value("${url.users}")
    private String URL_USERS;

    @RequestMapping(value = {"/usersList"}, method = RequestMethod.GET)
    public String usersList(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Users[] list = restTemplate.getForObject(URL_USERS, Users[].class);

        model.addAttribute("users", list);

        return "usersList";
    }
}
