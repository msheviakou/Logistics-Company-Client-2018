package edu.bsuir.controller;

import edu.bsuir.form.UsersForm;
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
public class MainController {

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @Value("${url.users}")
    private String URL_USERS;

    @Value("${url.user}")
    private String URL_USER;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/usersList"}, method = RequestMethod.GET)
    public String usersList(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Users[] list = restTemplate.getForObject(URL_USERS, Users[].class);

        model.addAttribute("persons", list);

        return "usersList";
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public String showAddUserPage(Model model) {

        UsersForm personForm = new UsersForm();
        model.addAttribute("personForm", personForm);

        return "addUser";
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("personForm") UsersForm personForm) {

        int number = personForm.getId();
        String firstName = personForm.getName();
        String position = personForm.getPost();
        String login = personForm.getLogin();
        String password = personForm.getPassword();

        if (number != 0
                && firstName != null && firstName.length() > 0
                && position != null && position.length() > 0
                && login != null && login.length() > 0
                && password != null && password.length() > 0) {

            Users newEmployee = new Users(number, firstName, position, login, password);

            RestTemplate restTemplate = new RestTemplate();

            // Data attached to the request.
            HttpEntity<Users> requestBody = new HttpEntity<>(newEmployee);

            // Send request with POST method.
            ResponseEntity<Users> result = restTemplate.postForEntity(URL_USER, requestBody, Users.class);

            System.out.println("Status code:" + result.getStatusCode());

            // Code = 200.
            if (result.getStatusCode() == HttpStatus.OK) {
                Users e = result.getBody();
                System.out.println("(Client Side) EmployeeForm Created: " + e.getId());
            }

            return "redirect:/usersList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addUser";
    }

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.GET)
    public String showDeleteUserPage(Model model) {

        UsersForm personForm = new UsersForm();
        model.addAttribute("personForm", personForm);

        return "deleteUser";
    }

    @RequestMapping(value = {"/deleteUser"}, method = RequestMethod.POST)
    public String deleteUser(Model model, @ModelAttribute("personForm") UsersForm personForm) {

        int number = personForm.getId();

        if (number != 0) {

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.delete(URL_USER + "/" + number);

            return "redirect:/usersList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "deleteUser";
    }
}
