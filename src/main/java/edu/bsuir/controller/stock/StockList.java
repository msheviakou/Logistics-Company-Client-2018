package edu.bsuir.controller.stock;

import edu.bsuir.model.Stocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class StockList {

    @Value("${url.stocks}")
    private String URL_STOCKS;

    @RequestMapping(value = {"/stocksList"}, method = RequestMethod.GET)
    public String ordersList(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Stocks[] list = restTemplate.getForObject(URL_STOCKS, Stocks[].class);

        model.addAttribute("stocks", list);

        return "stocksList";
    }
}
