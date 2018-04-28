package edu.bsuir.controller.security;

import edu.bsuir.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class Administration {

  @Value("${url.users}")
  private String URL_USERS;

  @RequestMapping(value = {"/administration"}, method = RequestMethod.GET)
  public String usersList(Model model) {

    RestTemplate restTemplate = new RestTemplate();

    Users[] users = restTemplate.getForObject(URL_USERS, Users[].class);

    model.addAttribute("users", users);

    Users userObj = new Users();
    model.addAttribute("userObj", userObj);

    return "administration";
  }
}
