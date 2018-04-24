package edu.bsuir.controller.order;

import edu.bsuir.model.Orders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class OrderList {

    @Value("${url.orders}")
    private String URL_ORDERS;

    @RequestMapping(value = {"/ordersRealization"}, method = RequestMethod.GET)
    public String ordersList(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Orders[] list = restTemplate.getForObject(URL_ORDERS, Orders[].class);

        model.addAttribute("orders", list);

        return "ordersRealization";
    }
}
