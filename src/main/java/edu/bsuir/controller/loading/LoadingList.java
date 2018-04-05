package edu.bsuir.controller.loading;

import edu.bsuir.model.Loadings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoadingList {

    @Value("${url.loadings}")
    private String URL_LOADINGS;

    @RequestMapping(value = {"/loadingsList"}, method = RequestMethod.GET)
    public String loadingsList(Model model) {

        RestTemplate restTemplate = new RestTemplate();

        Loadings[] list = restTemplate.getForObject(URL_LOADINGS, Loadings[].class);

        model.addAttribute("loadings", list);

        return "loadingsList";
    }
}
