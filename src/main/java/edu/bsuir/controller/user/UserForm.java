package edu.bsuir.controller.user;

import edu.bsuir.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserForm {

    @Value("${url.user}")
    private String URL_USER;

    @RequestMapping(value = {"/userForm/{userId}"}, method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("userId") String userId) {

        RestTemplate restTemplate = new RestTemplate();

        Users userToGet = restTemplate.getForObject(URL_USER + "/" + userId, Users.class);

        model.addAttribute("userForm", userToGet);

        return "userForm";
    }
}
