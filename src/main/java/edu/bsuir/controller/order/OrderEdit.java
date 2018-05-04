package edu.bsuir.controller.order;

import edu.bsuir.form.OrdersForm;
import edu.bsuir.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.sql.Time;
import java.sql.Date;

import static edu.bsuir.controller.order.OrderAdd.*;

@Controller
public class OrderEdit {
    @Value("${message.error}")
    private String messageError;

    @Value("${url.order}")
    private String URL_ORDER;

    @Value("${url.order.edit}")
    private String URL_ORDER_EDIT;

    @Value("${url.order.last}")
    private String URL_ORDER_LAST;

    @Value("${url.users.forwarder}")
    private String URL_USERS_FORWARDERS;

    @Value("${url.stocks}")
    private String URL_STOCKS;

    private int currentOrderId;
    private String currentOrderNumber;
    private Date currentOrderDate;
    private  String currentOrderStatus;

    @RequestMapping(value = {"/orderEdit/{orderId}"}, method = RequestMethod.GET)
    public String getOrder(Model model, @PathVariable("orderId") String orderId) {

        RestTemplate restTemplate = new RestTemplate();

        Orders order = restTemplate.getForObject(URL_ORDER + "/" + orderId, Orders.class);
        model.addAttribute("order", order);
        currentOrderId = order.getId();
        currentOrderNumber = order.getNumberOfOrder();
        currentOrderDate = order.getDateOfOrder();
        currentOrderStatus = order.getOrderStatus();

        Users[] users = restTemplate.getForObject(URL_USERS_FORWARDERS, Users[].class);
        model.addAttribute("users", users);

        Stocks[] stocks = restTemplate.getForObject(URL_STOCKS, Stocks[].class);
        model.addAttribute("stocks", stocks);

        return "orderEdit";
    }

    @RequestMapping(value = {"/editOrder"}, method = RequestMethod.POST)
    public String editOrder(Model model, @ModelAttribute("order") OrdersForm orderForm) {

        String orderStatus = orderForm.getOrderStatus();
        if(orderStatus == null)
            orderStatus = currentOrderStatus;

        Orders orderToAdd = new Orders(
                currentOrderDate, currentOrderNumber,
                orderStatus, orderForm.getFreightCost(),
                orderForm.getPaymentPeriod(), orderForm.getAdditionalInformation()
        );
        /* End Setting Order */

        Carriers carrierToAdd = setCarrierToAdd(
                orderForm.getCarrier().getCarrierCompanyName(),
                orderForm.getCarrier().getCarrierContact(),
                orderForm.getCarrier().getCarrierTelephone(),
                orderForm.getCarrier().getCarrierElMail()
        );
        /* End Adding Carrier */

        Drivers driverToAdd = setDriverToAdd(
                orderForm.getCarrier().getDriver().getPhoneNumber(),
                orderForm.getCarrier().getDriver().getName(),
                orderForm.getCarrier().getDriver().getTrukRegNumber()
        );
        carrierToAdd.setDriver(driverToAdd);
        /* End Adding Driver */

        Cargos cargoToAdd = setCargoToAdd(
                orderForm.getCargo().getCargoDescription(),
                orderForm.getCargo().getCargoWeight(),
                orderForm.getCargo().getCargoCount(),
                orderForm.getCargo().getCargoDocument()
        );
        /* End Adding Cargo */

        Loadings loadingToAdd = setLoadingToAdd(
                orderForm.getLoading().getLoadingCompanyName(),
                orderForm.getLoading().getLoadingAdress(),
                orderForm.getLoading().getLoadingPostalCode(),
                orderForm.getLoading().getLoadingCity(),
                orderForm.getLoading().getLoadingCountry(),
                orderForm.getLoading().getLoadingDate(),
                Time.valueOf(orderForm.getLoading().getLoadingTime() + ":00")
        );
        /* End Adding Loading */

        Unloadings unloadingToAdd = setUnloadingToAdd(
                orderForm.getUnloading().getUnloadingClient(),
                orderForm.getUnloading().getUnloadingCity(),
                orderForm.getUnloading().getUnloadingCountry(),
                orderForm.getLoading().getLoadingDate(),
                Time.valueOf(orderForm.getUnloading().getUnloadingTime() + ":00")
        );
        /* End Adding Unloading */

        Stocks stockToAdd = setStockToAdd(
                orderForm.getUnloading().getStock().getStockName(),
                orderForm.getUnloading().getStock().getStockAdress(),
                orderForm.getUnloading().getStock().getStockPostalCode(),
                orderForm.getUnloading().getStock().getStockCity(),
                orderForm.getUnloading().getStock().getStockCountry()
        );
        unloadingToAdd.setStock(stockToAdd);
        /* End Adding Stock */

        Users userForwarderBYtoAdd = setUserForwarderBYToAdd(orderForm.getUserForwarderBY().getId());
        /* End Adding UserForwarderBY */

        orderToAdd.setId(currentOrderId);
        orderToAdd.setCarrier(carrierToAdd);
        orderToAdd.setCargo(cargoToAdd);
        orderToAdd.setLoading(loadingToAdd);
        orderToAdd.setUnloading(unloadingToAdd);
        orderToAdd.setUserForwarderBY(userForwarderBYtoAdd);
        /* End Setting Objects */

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Orders> requestBody = new HttpEntity<>(orderToAdd);

        ResponseEntity<Orders> result = restTemplate.postForEntity(URL_ORDER_EDIT, requestBody, Orders.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            return "redirect:/index";
        }

        model.addAttribute("errorMessage", messageError);
        return "addOrderP";
    }
}
