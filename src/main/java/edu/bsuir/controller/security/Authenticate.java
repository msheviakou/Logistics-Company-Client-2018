package edu.bsuir.controller.security;

import edu.bsuir.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class Authenticate {

    @Value("${message.errorAuthenticate}")
    private String messageErrorAuthenticate;

    @Value("${url.authenticate}")
    private String URL_AUTHENTICATE;

    @RequestMapping(value = {"/", "/authenticate"}, method = RequestMethod.GET)
    public String authentication(Model model) {

        Users userForm = new Users();
        model.addAttribute("userForm", userForm);

        return "authenticate";
    }

    @RequestMapping(value = {"/", "/authenticate"}, method = RequestMethod.POST)
    public String authentication(Model model, @ModelAttribute("userForm") Users userForm) {

        String login = userForm.getLogin();
        String password = userForm.getPassword();

        if (login != null && login.length() > 0
            && password != null && password.length() > 0) {

            Users userToAuthenticate = new Users();

            userToAuthenticate.setLogin(login);
            userToAuthenticate.setPassword(password);

            RestTemplate restTemplate = new RestTemplate();

            HttpEntity<Users> requestBody = new HttpEntity<>(userToAuthenticate);

            ResponseEntity<Users> result = restTemplate.postForEntity(URL_AUTHENTICATE, requestBody, Users.class);

            if (result.getStatusCode() == HttpStatus.OK) {
                userToAuthenticate = result.getBody();
                if (userToAuthenticate != null)
                    return "redirect:/welcome";
            }
        }

        model.addAttribute("errorMessage", messageErrorAuthenticate);
        return "authenticate";
    }
}
