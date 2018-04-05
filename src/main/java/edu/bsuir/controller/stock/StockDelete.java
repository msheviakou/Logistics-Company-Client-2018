package edu.bsuir.controller.stock;

import edu.bsuir.model.Stocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class StockDelete {

    @Value("${message.error}")
    private String messageError;

    @Value("${url.stock}")
    private String URL_STOCK;

    @RequestMapping(value = {"/deleteStock"}, method = RequestMethod.GET)
    public String showDeleteStockPage(Model model) {

        Stocks stockForm = new Stocks();
        model.addAttribute("stockForm", stockForm);

        return "deleteStock";
    }

    @RequestMapping(value = {"/deleteStock"}, method = RequestMethod.POST)
    public String deleteStock(Model model, @ModelAttribute("stockForm") Stocks stockForm) {

        int number = stockForm.getId();

        if (number != 0) {

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.delete(URL_STOCK + "/" + number);

            return "redirect:/stocksList";
        }

        model.addAttribute("errorMessage", messageError);
        return "deleteStock";
    }
}
