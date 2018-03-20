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

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String authentication(Model model) {

        Users userForm = new Users();
        model.addAttribute("userForm", userForm);

        return "login";
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.POST)
    public String authentication(Model model, @ModelAttribute("userForm") Users userForm) {

        String login = userForm.getLogin();
        String password = userForm.getPassword();

        if (login != null && login.length() > 0
                && password != null && password.length() > 0) {

            edu.bsuir.model.Users userToAuthenticate = new edu.bsuir.model.Users();
            userToAuthenticate.setLogin(login);
            userToAuthenticate.setPassword(password);

            RestTemplate restTemplate = new RestTemplate();

            HttpEntity<edu.bsuir.model.Users> requestBody = new HttpEntity<>(userToAuthenticate);

            ResponseEntity<edu.bsuir.model.Users> result = restTemplate.postForEntity(URL_AUTHENTICATE, requestBody, edu.bsuir.model.Users.class);

            // Logger: result.getStatusCode()

            if (result.getStatusCode() == HttpStatus.OK) {
                // Users userAuthenticated = result.getBody();
                // Logger:
            }

            return "redirect:/welcome";
        }

        model.addAttribute("errorMessage", messageErrorAuthenticate);
        return "login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome (){ return "welcome"; }
}
