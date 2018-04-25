package edu.bsuir.controller.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class OrderDelete {
    @Value("${url.order}")
    private String URL_ORDER;

    @RequestMapping(value = {"/deleteOrder/{orderId}"}, method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable("orderId") String orderId) {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(URL_ORDER + "/" + orderId);

        System.out.println("Заказ успешно удалён!");

        return "redirect:/welcome";
    }
}
