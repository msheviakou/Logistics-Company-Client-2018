package edu.bsuir.controller.statistics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Statistics {

    @RequestMapping(value = {"/statistics"}, method = RequestMethod.GET)
    public String getStatistics() {
        return "statistics";
    }
}
