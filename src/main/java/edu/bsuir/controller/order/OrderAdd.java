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

import java.sql.Time;
import java.sql.Date;
import java.util.Calendar;

@Controller
public class OrderAdd {

    @Value("${message.error}")
    private String messageError;

    @Value("${url.order}")
    private String URL_ORDER;

    @RequestMapping(value = {"addOrder"}, method = RequestMethod.GET)
    public String showAddOrderPage(Model model) {

        Orders orderForm = new Orders();
        model.addAttribute("orderForm", orderForm);

        return "/order/addOrder";
    }

    @RequestMapping(value = {"/addOrder"}, method = RequestMethod.POST)
    public String saveOrder(Model model, @ModelAttribute("orderForm") Orders orderForm) {

        /* Start Setting Order */
        java.util.Date currentDateTime = new java.util.Date();

        Calendar calendar = Calendar.getInstance();

        Date dateOfOrder = new Date(currentDateTime.getTime());
        String numberOfOrder = "P" + calendar.get(Calendar.MONTH) + "001";
        String orderStatus = "В реализации";
        Double freightCost = orderForm.getFreightCost();
        String paymentPeriod = orderForm.getPaymentPeriod();
        String additionalInformation = orderForm.getAdditionalInformation();

        Orders orderToAdd = new Orders(dateOfOrder, numberOfOrder, orderStatus, freightCost, paymentPeriod, additionalInformation);
        /* End Setting Order */

        /* Start Adding Carrier */
        String carrierCompanyName = orderForm.getCarrier().getCarrierCompanyName();
        String carrierContact = orderForm.getCarrier().getCarrierContact();
        String carrierTelephone = orderForm.getCarrier().getCarrierTelephone();
        String carrierElMail = orderForm.getCarrier().getCarrierElMail();

        Carriers carrierToAdd = setCarrierToAdd(carrierCompanyName, carrierContact, carrierTelephone, carrierElMail);
        /* End Adding Carrier */

        /* Start Adding Cargo */
        String cargoDescription = orderForm.getCargo().getCargoDescription();
        int cargoWeight = orderForm.getCargo().getCargoWeight();
        int cargoCount = orderForm.getCargo().getCargoCount();
        String cargoDocument = orderForm.getCargo().getCargoDocument();

        Cargos cargoToAdd = setCargoToAdd(cargoDescription, cargoWeight, cargoCount, cargoDocument);
        /* End Adding Cargo */

        /* Start Adding Loading */
        String loadingCompanyName = orderForm.getLoading().getLoadingCompanyName();
        String loadingAdress = orderForm.getLoading().getLoadingAdress();
        String loadingPostalCode = orderForm.getLoading().getLoadingPostalCode();
        String loadingCity = orderForm.getLoading().getLoadingCity();
        String loadingCountry = orderForm.getLoading().getLoadingCountry();
        Date loadingDate = orderForm.getLoading().getLoadingDate();
        Time loadingTime = orderForm.getLoading().getLoadingTime();

        Loadings loadingToAdd = setLoadingToAdd(loadingCompanyName, loadingAdress, loadingPostalCode, loadingCity, loadingCountry, loadingDate, loadingTime);
        /* End Adding Loading */

        /* Start Adding Unloading */
        String unloadingClient = orderForm.getUnloading().getUnloadingClient();
        String unloadingCity = orderForm.getUnloading().getUnloadingCity();
        String unloadingCountry = orderForm.getUnloading().getUnloadingCountry();
        Date unloadingDate = orderForm.getUnloading().getUnloadingDate();
        Time unloadingTime = orderForm.getUnloading().getUnloadingTime();

        Unloadings unloadingToAdd = setUnloadingToAdd(unloadingClient, unloadingCity, unloadingCountry, unloadingDate, unloadingTime);
        /* End Adding Unloading */

        /* Start Adding UserForwarderBY */
        String userForwarderBYname = orderForm.getUserForwarderBY().getName();

        Users userForwarderBYtoAdd = setUserForwarderBYToAdd(userForwarderBYname);
        /* End Adding UserForwarderBY */

        /* Start Adding UserForwarderPL */
        String userForwarderPLname = "???";/* Тот пользователь, который оформляет заказ*/

        Users userForwarderPLtoAdd = setUserForwarderPLToAdd(userForwarderPLname);
        /* End Adding UserForwarderPL */

        /* Start Setting Objects*/
        orderToAdd.setCarrier(carrierToAdd);
        orderToAdd.setCargo(cargoToAdd);
        orderToAdd.setLoading(loadingToAdd);
        orderToAdd.setUnloading(unloadingToAdd);
        orderToAdd.setUserForwarderBY(userForwarderBYtoAdd);
        orderToAdd.setUserForwarderPL(userForwarderPLtoAdd);
        /* End Setting Objects */

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

    private Carriers setCarrierToAdd(String carrierCompanyName, String carrierContact, String carrierTelephone, String carrierElMail) {
        Carriers carrier = new Carriers();

        carrier.setCarrierCompanyName(carrierCompanyName);
        carrier.setCarrierContact(carrierContact);
        carrier.setCarrierTelephone(carrierTelephone);
        carrier.setCarrierElMail(carrierElMail);

        return carrier;
    }

    private Cargos setCargoToAdd(String cargoDescription, int cargoWeight, int cargoCount, String cargoDocument) {
        Cargos cargo = new Cargos();

        cargo.setCargoDescription(cargoDescription);
        cargo.setCargoWeight(cargoWeight);
        cargo.setCargoCount(cargoCount);
        cargo.setCargoDocument(cargoDocument);

        return cargo;
    }

    private Loadings setLoadingToAdd(String loadingCompanyName, String loadingAdress, String loadingPostalCode, String loadingCity, String loadingCountry, Date loadingDate, Time loadingTime) {
        Loadings loading = new Loadings();

        loading.setLoadingCompanyName(loadingCompanyName);
        loading.setLoadingAdress(loadingAdress);
        loading.setLoadingPostalCode(loadingPostalCode);
        loading.setLoadingCity(loadingCity);
        loading.setLoadingCountry(loadingCountry);
        loading.setLoadingDate(loadingDate);
        loading.setLoadingTime(loadingTime);

        return loading;
    }

    private Unloadings setUnloadingToAdd(String unloadingClient, String unloadingCity, String unloadingCountry, Date unloadingDate, Time unloadingTime) {
        Unloadings unloading = new Unloadings();

        unloading.setUnloadingClient(unloadingClient);
        unloading.setUnloadingCity(unloadingCity);
        unloading.setUnloadingCountry(unloadingCountry);
        unloading.setUnloadingDate(unloadingDate);
        unloading.setUnloadingTime(unloadingTime);

        return unloading;
    }

    private Users setUserForwarderBYToAdd(String userForwarderBYname) {
        Users userForwarderBY = new Users(userForwarderBYname);

        return userForwarderBY;
    }

    private Users setUserForwarderPLToAdd(String userForwarderPLname) {
        Users userForwarderPL = new Users(userForwarderPLname);

        return userForwarderPL;
    }
}
