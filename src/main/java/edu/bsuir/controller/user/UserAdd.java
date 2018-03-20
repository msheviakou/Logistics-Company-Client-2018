package edu.bsuir.controller.user;

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
public class UserAdd {

    @Value("${message.error}")
    private String messageError;

    @Value("${url.user}")
    private String URL_USER;

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public String showAddUserPage(Model model) {

        Users userForm = new Users();
        model.addAttribute("userForm", userForm);

        return "addUser";
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("userForm") Users userForm) {

        int number = userForm.getId();
        String firstName = userForm.getName();
        String position = userForm.getPost();
        String login = userForm.getLogin();
        String password = userForm.getPassword();

        if (number != 0
                && firstName != null && firstName.length() > 0
                && position != null && position.length() > 0
                && login != null && login.length() > 0
                && password != null && password.length() > 0) {

            edu.bsuir.model.Users newEmployee = new edu.bsuir.model.Users(number, firstName, position, login, password);

            RestTemplate restTemplate = new RestTemplate();

            HttpEntity<edu.bsuir.model.Users> requestBody = new HttpEntity<>(newEmployee);

            ResponseEntity<edu.bsuir.model.Users> result = restTemplate.postForEntity(URL_USER, requestBody, edu.bsuir.model.Users.class);

            // Logger: result.getStatusCode()

            if (result.getStatusCode() == HttpStatus.OK) {
                //Users userAdded = result.getBody();
                // Logger:
            }

            return "redirect:/usersList";
        }

        model.addAttribute("errorMessage", messageError);
        return "addUser";
    }
}
