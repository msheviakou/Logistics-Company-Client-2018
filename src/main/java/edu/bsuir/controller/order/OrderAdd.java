package edu.bsuir.controller.order;

import edu.bsuir.model.*;
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

import java.sql.Date;

@Controller
public class OrderAdd {

    @Value("${message.error}")
    private String messageError;

    @Value("${url.order}")
    private String URL_ORDER;

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.GET)
    public String showAddOrderPage(Model model) {

        Orders orderForm = new Orders();
        model.addAttribute("orderForm", orderForm);

        return "addOrder";
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute("orderForm") Orders orderForm) {

        Date dateOfOrder = orderForm.getDateOfOrder();
        String numberOfOrder = orderForm.getNumberOfOrder();
        String orderStatus = orderForm.getOrderStatus();
        Double freightCost = orderForm.getFreightCost();
        String paymentPeriod = orderForm.getPaymentPeriod();
        String additionalInformation = orderForm.getAdditionalInformation();

        Carriers carrierToAdd = new Carriers();
        Cargos cargoToAdd = new Cargos();
        Loadings loadingToAdd = new Loadings();
        Unloadings unloadingToAdd = new Unloadings();
        Notices noticeToAdd = new Notices();
        Users userForwarderBYtoAdd = new Users();
        Users userForwarderPLtoAdd = new Users();

        Orders orderToAdd = new Orders(dateOfOrder, numberOfOrder, orderStatus, freightCost, paymentPeriod, additionalInformation);

        orderToAdd.setCarrier(carrierToAdd);
        orderToAdd.setCargo(cargoToAdd);
        orderToAdd.setLoading(loadingToAdd);
        orderToAdd.setUnloading(unloadingToAdd);
        orderToAdd.setNotice(noticeToAdd);
        orderToAdd.setUserForwarderBY(userForwarderBYtoAdd);
        orderToAdd.setUserForwarderPL(userForwarderPLtoAdd);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Orders> requestBody = new HttpEntity<>(orderToAdd);

        ResponseEntity<Orders> result = restTemplate.postForEntity(URL_ORDER, requestBody, Orders.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            orderToAdd = result.getBody();
            if (orderToAdd != null)
                return "redirect:/welcome";
        }

        model.addAttribute("errorMessage", messageError);
        return "addOrder";
    }
}
