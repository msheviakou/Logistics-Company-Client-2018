package edu.bsuir.controller.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserDelete {

    @Value("${url.user}")
    private String URL_USER;

    @RequestMapping(value = {"/deleteUser/{userId}"}, method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") String userId) {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(URL_USER + "/" + userId);

        System.out.println("Пользователь успешно удалён!");

        return "redirect:/administration";
    }
}
