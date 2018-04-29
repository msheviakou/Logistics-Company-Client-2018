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

    @Value("${url.user.login}")
    private String URL_USER_LOGIN;

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public String showAddUserPage(Model model) {

        Users userForm = new Users();
        model.addAttribute("userForm", userForm);

        return "addUser";
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("userForm") Users userForm) {

        RestTemplate restTemplate = new RestTemplate();

        Users user = restTemplate.getForObject(URL_USER_LOGIN + "/" + userForm.getLogin(), Users.class);
        if(user.getId() == 0){
            HttpEntity<Users> requestBody = new HttpEntity<>(userForm);
            ResponseEntity<Users> result = restTemplate.postForEntity(URL_USER, requestBody, Users.class);

            if (result.getStatusCode() == HttpStatus.OK) {
                userForm = result.getBody();
                if (userForm != null)
                    return "redirect:/index";
            }
        }

        model.addAttribute("errorMessage", messageError);
        return "addUser";
    }


}
