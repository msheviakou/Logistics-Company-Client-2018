package edu.bsuir.controller.stock;

import edu.bsuir.model.Stocks;
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
public class StockAdd {

    @Value("${message.error}")
    private String messageError;

    @Value("${url.stock}")
    private String URL_STOCK;

    @RequestMapping(value = {"/addStock"}, method = RequestMethod.GET)
    public String showAddStockPage(Model model) {

        Stocks stockForm = new Stocks();
        model.addAttribute("stockForm", stockForm);

        return "addStock";
    }

    @RequestMapping(value = {"/addStock"}, method = RequestMethod.POST)
    public String saveStock(Model model, @ModelAttribute("stockForm") Stocks stockForm) {

        Stocks stockToAdd = new Stocks();

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Stocks> requestBody = new HttpEntity<>(stockToAdd);

        ResponseEntity<Stocks> result = restTemplate.postForEntity(URL_STOCK, requestBody, Stocks.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            stockToAdd = result.getBody();
            if (stockToAdd != null)
                return "redirect:/welcome";
        }

        model.addAttribute("errorMessage", messageError);
        return "addStock";
    }
}
