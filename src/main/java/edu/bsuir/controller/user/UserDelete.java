package edu.bsuir.controller.user;

import edu.bsuir.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserDelete {

    @Value("${message.error}")
    private String messageError;

    @Value("${url.user}")
    private String URL_USER;

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.POST)
    public String deleteUser(Model model, @ModelAttribute("user") Users user) {

        int number = user.getId();

        if (number != 0) {

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.delete(URL_USER + "/" + number);

            return "redirect:/administration";
        }

        model.addAttribute("errorMessage", messageError);
        return "userForm";
    }
}
